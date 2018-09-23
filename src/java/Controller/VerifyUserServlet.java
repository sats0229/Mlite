package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAo.DAOOperations;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "VerifyUserServlet", urlPatterns =
{
    "/verifyuser"
})
public class VerifyUserServlet extends HttpServlet
{

    String username, password, uName;
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try
        {
            String type = request.getParameter("type");
            DAOOperations.initialize();
            switch (type)
            {
                case "a":
                {

                    username = request.getParameter("uname").trim();
                    password = request.getParameter("pass").trim();

                    if (DAOOperations.verifyAdmin(username, password))
                    {
                        session = request.getSession();

                        session.setAttribute("user", username);
                      
                        
                        response.sendRedirect("AdminHome.jsp");

                    }
                    else
                    {

                        out.println("<center><h3 style='color:red'>Incorrect username or password!!</h1></center>");
                        RequestDispatcher dispatch = request.getRequestDispatcher("AdminLogin.jsp");
                        dispatch.include(request, response);
                    }
                    break;
                }
                case "u":
                {
                    username = request.getParameter("Email").trim();
                    password = request.getParameter("password").trim();

                    if (DAOOperations.getUserStatus(username) == false)
                    {

                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<script>alert('Your Account is not activated.Please wait for 24 hours.!!');</script>");
                        out.println("</body>");
                        out.println("</html>");

                        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                        rd.include(request, response);
                    }
                    else
                    {

                        if (DAOOperations.verifyUser(username, password))
                        {
                            uName = DAOOperations.getUserName(username);
                            session = request.getSession();
                            if (session.isNew())
                            {
                                session.setAttribute("username", uName);
                               session.setAttribute("uname",username);
                                
                                response.sendRedirect("index.jsp");
                            }
                            else
                            {    session.setAttribute("uname",username);
                                session.setAttribute("username", uName);
                                response.sendRedirect("index.jsp");
                            }


                        }
                        else
                        {

                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<script>alert('Incorrect username or password');</script>");
                            out.println("</body>");
                            out.println("</html>");

                            RequestDispatcher dispatch = request.getRequestDispatcher("index.jsp");
                            dispatch.include(request, response);
                        }
                    }
                }
                break;

                default:
                    break;
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
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
