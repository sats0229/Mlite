/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import DAo.CustomerRegistration;
import DAo.DAOOperations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "ViewUsers", urlPatterns =
{
    "/ViewUsers"
})
public class ViewUsers extends HttpServlet
{

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            
            DAOOperations.initialize();
            List<CustomerRegistration> usrs = DAOOperations.getAllUsers();
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>View Users</title>");
                out.println("</head>");
                out.println("<body><center>");
                out.println("<a href='AdminHome.jsp'><b>GO BACK TO PANEL</b></a>");
                out.println("<h2>Users List</h2>");
                out.println("<hr/>");
                out.println("<table border='1' width='100%'");
                out.println("<tr><th>User Name</th><th>Email ID</th><th>Status</th></tr>");
                for (CustomerRegistration c : usrs)
                {
                  out.println("<tr><td>"+c.getName()+"</td><td>"+c.getEmail()+"</td>");
                  
                           if(c.getStatus()==true)
                           {out.println("<td><b>Active</b><a href='changeAccountStatus?email="+c.getEmail()+"'>Change</a></td>");}
                           else
                           {
                            out.println("<td><b>Not Active</b><a href='changeAccountStatus?email="+c.getEmail()+"'>Change</a></td>");   
                           }
                out.println("</tr>");
                
            }
            
            out.println("</table></center></body>");
                out.println("</html>");
            }
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
