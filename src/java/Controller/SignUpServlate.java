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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "SignUpServlate", urlPatterns =
{
    "/SignUp"
})
public class SignUpServlate extends HttpServlet
{

    private String Name, Email, Password, Confirm_Password;

    boolean isStored, isStatus = true;

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Name = request.getParameter("Name");
        Password = request.getParameter("password");
        Confirm_Password = request.getParameter("Confirm_Password");
        Email = request.getParameter("Email");

        if (Password.equals(Confirm_Password))

        {

            try
            {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("EliteShopPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin();
                CustomerRegistration cr = new CustomerRegistration();
                cr.setName(Name);
                cr.setEmail(Email);
                cr.setPassword(Password);
                cr.setStatus(isStatus);
                em.persist(cr);
                em.getTransaction().commit();
                em.close();
                emf.close();

                isStored = true;

            }
            catch (Exception ex)
            {
                out.println(ex);
                //ex.printStackTrace();
            }
        }
        if (isStored == true)
        {
            try
            {
                
                out.println("<html><body><script>alert('Account Created Successfully :)');</script></body></html>");
                HttpSession session = request.getSession(true);
                
                session.setAttribute("username", Name);
                session.setMaxInactiveInterval(30 * 60);
                Cookie userCookie = new Cookie("username", Name);
                userCookie.setMaxAge(30 * 60);
                response.addCookie(userCookie);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
            finally
            {

                out.close();

            }

        }
        //response.sendRedirect("welcome.html");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

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
