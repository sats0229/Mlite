/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAo.Orders;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@WebServlet(name = "OrderDetail", urlPatterns =
{
    "/OrderDetail"
})
public class OrderDetail extends HttpServlet
{

    private String Rname, Addr, Addtype, Email, City, State;
    private long PhoneNo;
    private int Pincode;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session = request.getSession(false);
            Email = session.getAttribute("uname").toString();
            Rname = request.getParameter("Rname");
            Addr = request.getParameter("Addr");
            Addtype = request.getParameter("Addtype");
            City = request.getParameter("city");
            State = request.getParameter("state");
            PhoneNo = Long.parseLong(request.getParameter("phoneNum"));
            Pincode = Integer.parseInt(request.getParameter("pincode"));
            
            try
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EliteShopPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                Orders od = new Orders();
                od.setAddtype(Addtype);
                od.setRecipientname(Rname);
                od.setUseraddress(Addr);
                od.setUserid(Email);
                od.setCity(City);
                od.setPhonenumber(PhoneNo);
                od.setPincode(Pincode);
                od.setState(State);
                em.persist(od);
                em.getTransaction().commit();
                em.close();
                emf.close();

            }
            catch (Exception ex)
            {
                out.println(ex);

            }
            response.sendRedirect("invoice.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
