package view;

import DAo.DAOOperations;
import Model.CartItems;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "InCart", urlPatterns =
{
    "/InCart"
})
public class InCart extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {

        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session = request.getSession(false);
            if (session.getAttribute("uname") == null)
            {
                out.println("<html><body><script>alert('Please Login First!!');</script></body></html>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

            }
            else
            {
                RequestDispatcher rd = request.getRequestDispatcher("Header.jsp");
                rd.include(request, response);
                DAOOperations.initialize();
                ArrayList<CartItems> pr = DAOOperations.getCartitems(session.getAttribute("uname").toString());
                double totalOrderCost = 0;
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link rel='icon' type='image/png' href='images/icon.png'/>");
                out.println("<title>Items in Cart</title>");
                out.println("</head>");
                out.println("<body><center>");
                out.println("<a href='index.jsp'><b>Shop More</b></a>");
                out.println("<h2>Items in Cart</h2>");
                out.println("<hr/>");
                out.println("<table border='0' width='100%'");
                out.println("<tr><th></th><th>Product Name</th><th>Product Qty.</th><th>Unit Price</th><th>SubTotal</th><th>Remove Item</th></tr>");
                for (CartItems p1 : pr)
                {
                    totalOrderCost = totalOrderCost + p1.getSubTotal();
                    out.println("<tr><td></td><td>" + p1.getProductName() + "</td><td><input type='number' value='" + p1.getQuantity() + "' min='1' max='9' required></td><td>" + p1.getPrice() + "</td><td>" + p1.getSubTotal() + "</td><td><a href='RemoveItem?Id=" + p1.getPid() + "&Email=" + p1.getEmail() + "'><b>Remove</b></a></td>");
                }
                out.println("<tr><td>&nbsp;</td></tr>");
                out.println("<tr><td colspan='5' align='left'><b>&nbsp;&nbsp;&nbsp;Total Order Cost =</b></td><td align='left'><b>Rs. " + totalOrderCost + " /-</b></td></tr></table></center><br><center><a href='OrderForm.jsp'><input type='button' value='Proceed'/></a></center><br><br><br><br><br><br><br></body>");
                out.println("</html>");
                
                RequestDispatcher rd2 = request.getRequestDispatcher("Footer.jsp");
                rd2.include(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
