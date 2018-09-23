<%-- 
    Document   : Search
    Created on : Sep 20, 2018, 10:56:49 AM
    Author     : HEROS
--%>

<%@page import="javax.persistence.Persistence"%>
<%@page import="java.util.List"%>
<%@page import="DAo.Products"%>
<%@page import="javax.persistence.Query"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mlite Shop | Online Shopping Site</title>
        <link rel="icon" type="image/png" href="images/icon.png"/>
    </head>
    <body>
        <jsp:include page="Header.jsp"></jsp:include>
        <%
            try
            {
                String Search = request.getParameter("search");

                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EliteShopPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();

                Query q = em.createQuery("SELECT p FROM Products p WHERE UPPER(p.proName) LIKE UPPER(:proName)ORDER BY p.proName");
                q.setParameter("proName", "%" + Search + "%");
                List<Products> list = (List<Products>) q.getResultList();
                String result = "";
                out.println("<br>");
                out.println("<center><h4><b>Results:</b></h4></center>");
                if (list.size()== 0)
                    {
                        out.println("<br><br><br><br><br><br><br><br><br>");
                        out.println("<center><h1>Sorry, No result Found :)!!<h1></center>");
                    }
                
                for (Products product : list)
                {

                    result = result.concat("<div class='col-md-3 product-men'><div class='men-pro-item simpleCart_shelfItem'><div class='men-thumb-item'><img src='" + product.getProductimage() + "' alt='' class='pro-image-front'><img src='" + product.getProductimage() + "' alt='' class='pro-image-back'><div class='men-cart-pro'><div class='inner-men-cart-pro'><a href='view.jsp?pid=" + product.getProductId() + "' class='link-product-add-cart' target='_blank'>Quick View</a></div></div><span class='product-new-top'>New</span></div><div class='item-info-product '><h4><a href='view.jsp?pid=" + product.getProductId() + "'>" + product.getProName() + "</a></h4><div class='info-product-price'><span class='item_price'>Rs." + product.getProPrice() + "</span></div><div class='snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2'><form action='CustomerCart' method='post'><fieldset><input type='hidden' name='PID' value='" + product.getProductId() + "' /><input type='submit' name='submit' value='Add to cart' class='button' /></fieldset></form></div></div></div></div>");
                }
                out.println(result);
            }
            catch (Exception ex)
            {
                out.println(ex);
            }
        %>
        <%
            out.println("<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>");
        %>
        <jsp:include page="Footer.jsp"></jsp:include>

    </body>
</html>
