/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAo.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "RemoveItem", urlPatterns =
{
    "/RemoveItem"
})
public class RemoveItem extends HttpServlet
{
    private int ProductID;
    private String Eid;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
          ProductID = Integer.parseInt(request.getParameter("Id"));
          Eid = request.getParameter("Email");
          
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EliteShopPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            Query q = em.createQuery("SELECT c.id FROM Cart c WHERE c.productcode = :id AND c.emailid=:email ");
            q.setParameter("id", ProductID);
            q.setParameter("email", Eid);
            int id =(int) q.getSingleResult();
            Cart pr = em.find(Cart.class, id);
            em.remove(pr);
            em.getTransaction().commit();
            em.close();
            emf.close();
            
            
            response.sendRedirect("InCart");
            
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
