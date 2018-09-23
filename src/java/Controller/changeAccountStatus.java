/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAo.CustomerRegistration;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "changeAccountStatus", urlPatterns =
{
    "/changeAccountStatus"
})
public class changeAccountStatus extends HttpServlet
{

    private String Email;
    boolean isStatus;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            
            Email = request.getParameter("email");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("EliteShopPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            CustomerRegistration cr = em.find(CustomerRegistration.class, Email);
            if (cr.getStatus()==true){
            
                
         
            cr.setStatus(isStatus);
            em.persist(cr);
            em.getTransaction().commit();
            em.close();
            emf.close();

            }
            else{
             cr.setStatus(true);
            em.persist(cr);
            em.getTransaction().commit();
            em.close();
            emf.close();
            }

            RequestDispatcher rd = request.getRequestDispatcher("ViewUsers");
            rd.forward(request, response);

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
