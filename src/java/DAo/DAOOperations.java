package DAo;

import Model.CartItems;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author HEROS
 */
public class DAOOperations
{

    static EntityManagerFactory emf;
    static EntityManager em;
    static EntityTransaction tm;
    static String uName, uPassword;
    static int pid;
    static int cartid;
    static Query query, query1, query2;
    static List<Cart> cartList;
    static String productName;
    static double unitPrice, subTotal, totalOrderCost;
    static ArrayList<CartItems> cartItems;

    public static void initialize()
    {
        try
        {
            emf = Persistence.createEntityManagerFactory("EliteShopPU");

            em = emf.createEntityManager();

            tm = em.getTransaction();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public static boolean verifyAdmin(String username, String password)
    {
        try
        {
            tm.begin();
            Admin result = em.find(Admin.class, username);

            uPassword = result.getPassword();
            if (password.equals(uPassword))
            {
                return true;

            }
        }

        catch (Exception ex)
        {

            System.out.println(ex);
        }

        return false;
    }

    public static boolean verifyUser(String username, String password)
    {

        tm.begin();
        CustomerRegistration result = em.find(CustomerRegistration.class, username);
        if (result == null)
        {
            return false;
        }
        else
        {
            uPassword = result.getPassword().trim();
            if (password.equals(uPassword))
            {

                return true;

            }

        }

        return false;

    }

    public static boolean getUserStatus(String username)
    {
        CustomerRegistration cust = em.find(CustomerRegistration.class, username);
        return cust.getStatus();
    }

    public static Orders getOrderDetails(String username)
    {
        Orders od = em.find(Orders.class, username);
        return od;
    }

    public static Products findProduct(int pid)
    {
        Products pr = em.find(Products.class, pid);
        return pr;
    }

    public static List<CustomerRegistration> getAllUsers()
    {

        tm.begin();
        query = em.createQuery("SELECT c FROM CustomerRegistration c");
        List<CustomerRegistration> list = (List<CustomerRegistration>) query.getResultList();
        return list;

    }

    public static List<Products> getALLProducts()
    {
        tm.begin();
        query = em.createQuery("SELECT p FROM Products p");
        List<Products> list = (List<Products>) query.getResultList();
        return list;
    }

    public static List<String> getProductCategories()
    {
        tm.begin();
        query2 = em.createQuery("SELECT distinct p.proCategory FROM Products p");
        List<String> list = (List<String>) query2.getResultList();
        return list;
    }

    public static List<Products> getProductList(String catName)
    {
        tm.begin();
        query = em.createQuery("SELECT p FROM Products p WHERE LOWER(p.proCategory) LIKE :category");
        query.setParameter("category", catName.toLowerCase());
        List<Products> list = (List<Products>) query.getResultList();
        return list;
    }

    public static String getUserName(String username)
    {
        CustomerRegistration cr = em.find(CustomerRegistration.class, username);
        uName = cr.getName();

        return uName;

    }

    public static void storeProducts(String prodName, int prodQty, double price, String category, String description, String image)
    {
        try
        {
            tm.begin();
            Query query = em.createNamedQuery("Products.findAll");
            List<Products> list = query.getResultList();
            if (list.isEmpty())
            {
                pid = pid + 1;
            }
            else
            {
                for (Products pr : list)
                {
                    pid = pr.getProductId();
                }
                if (pid == list.size())
                {
                    pid = pid + 1;
                }
                else
                {
                    pid = pid + 1;
                }

            }

            Products product = new Products(pid, prodName, category, price, description, prodQty, image);
            em.persist(product);
            tm.commit();
//            em.close();
//            emf.close();

        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

    }

    public static boolean inCart(String email)
    {
        query = em.createQuery("SELECT c FROM Cart c WHERE c.emailid=:emailid");
        query.setParameter("emailid", email);
        cartList = (List<Cart>) query.getResultList();
        return cartList.isEmpty();
    }

    private static boolean checkCart(String email, int pid)
    {
        try
        {

            query = em.createQuery("SELECT c FROM Cart c WHERE c.emailid=:emailid AND c.productcode=:id");
            query.setParameter("emailid", email);
            query.setParameter("id", pid);
            cartList = (List<Cart>) query.getResultList();
            if (cartList.isEmpty())
            {
                return false;
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex);
        }

        return true;
    }

    public static void addItemToCart(String email, int pid)
    {
        int qty = 0;
        try
        {
            tm.begin();
            if (checkCart(email, pid) == true)
            {

                Cart cart = (Cart) query.getSingleResult();
                qty = cart.getQuantity() + 1;
                cartid = cart.getId();
                //Update Operation code for quantity on the basis of cart id 
                java.util.Date date = new java.util.Date();
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
                Cart cart1 = em.find(Cart.class, cartid);
                cart1.setQuantity(qty);
                cart1.setCartmodifieddate(format1.format(date));

                tm.commit();

            }
            else
            {
                qty = 1;

                query1 = em.createQuery("SELECT max(c.id) FROM Cart c");

                int cart2 = (int) query1.getSingleResult();

                cartid = cart2 + 1;
                java.util.Date date = new java.util.Date();
                SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

                Cart cart1 = new Cart();
                cart1.setEmailid(email);
                cart1.setProductcode(pid);
                cart1.setId(cartid);
                cart1.setQuantity(qty);
                cart1.setCartmodifieddate(format1.format(date));
                em.persist(cart1);
                tm.commit();
            }

        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.out.println(ex);
        }
    }

    public static ArrayList<CartItems> getCartitems(String email)
    {
        cartItems = new ArrayList();
        tm.begin();
        query = em.createQuery("SELECT c FROM Cart c WHERE c.emailid = :emailid");
        query.setParameter("emailid", email);
        List<Cart> li = query.getResultList();
        System.out.println(li.size());
        for (Cart cart : li)
        {
            Query querys = em.createQuery("SELECT p from Products p WHERE p.productId=:id");
            querys.setParameter("id", cart.getProductcode());
            Products pr = (Products) querys.getSingleResult();
            productName = pr.getProName();
            unitPrice = pr.getProPrice();
            pid = cart.getProductcode();
            subTotal = unitPrice * cart.getQuantity();
            totalOrderCost = subTotal + totalOrderCost;
            CartItems items = new CartItems();
            items.setEmail(email);
            items.setPrice(unitPrice);
            items.setProductName(productName);
            items.setQuantity(cart.getQuantity());
            items.setSubTotal(subTotal);
            items.setPid(pid);
            items.setTotalOrderCost(totalOrderCost);
            cartItems.add(items);

        }

        return cartItems;

    }
}
