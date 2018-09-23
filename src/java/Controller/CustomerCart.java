package Controller;

import DAo.DAOOperations;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CustomerCart", urlPatterns =
{
    "/CustomerCart"
})
public class CustomerCart extends HttpServlet
{

    private String Cid, proID;
    private int pid;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter())
        {
            HttpSession session = request.getSession(false);
            if (session.getAttribute("uname") != null)
            {
                pid = Integer.parseInt(request.getParameter("PID"));
                session.setAttribute("proID", pid);
                Cid = (String) session.getAttribute("uname");
                DAOOperations.initialize();
                DAOOperations.addItemToCart(Cid, pid);
                response.sendRedirect("InCart");

            }
            else
            {
                out.println("<body><script>alert('Please Login or Register to add Items to cart');</script></body>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);

            }

        }
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

    @Override
    public String getServletInfo()
    {
        return "Short description";
    }

}
