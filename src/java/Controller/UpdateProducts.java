package Controller;

import DAo.DAOOperations;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;

/**
 *
 * @author HEROS
 */
@WebServlet(name = "UpdateProducts", urlPatterns =
{
    "/UpdateProducts"
})
@MultipartConfig

public class UpdateProducts extends HttpServlet
{

    private String Pname, Pcategory, Pdesc, Pimage, filePath;
    private int Pqty, Pid;
    private double Pprice;
    PrintWriter out;
    OutputStream out2 = null;
    InputStream filecontent = null;
    private static final String UPLOAD_DIR = "ProductImages";
    String fileName;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        try
        {
            out = response.getWriter();

            
            // constructs path of the directory to save uploaded file
            
            if (request.getPart("Pimage") != null)
            {
                fileName = getFileName(request.getPart("Pimage"));
                String completePath = UPLOAD_DIR + File.separator + fileName;
                File file1 = new File(completePath);
                out2 = new FileOutputStream(file1);
                filecontent = request.getPart("Pimage").getInputStream();
                
                int read = 0;
                final byte[] bytes = new byte[filecontent.available()];
                filecontent.read(bytes, 0, filecontent.available());

                out2.write(bytes, 0, filecontent.available());

                out2.close();
                filecontent.close();
                
                DAOOperations.initialize();
                Pname = request.getParameter("Pname");
                Pcategory = request.getParameter("Pcategory");
                Pqty = Integer.parseInt(request.getParameter("Pqty"));
                Pdesc = request.getParameter("Pdesc");
                Pprice = Double.parseDouble(request.getParameter("Pprice"));
               
                

                DAOOperations.storeProducts(Pname, Pqty, Pprice, Pcategory, Pdesc, file1.getAbsolutePath());

                out.println("<html><body><script>alert('Product Added successfully');</script></body></html>");

                RequestDispatcher dispatchedView = request.getRequestDispatcher("AddProduct.jsp");
                dispatchedView.include(request, response);

            }
            else
            {
                out.println("<html><body><script>alert('Product could not Added');</script></body></html>");
                RequestDispatcher dispatchedView = request.getRequestDispatcher("AddProduct.jsp");
                dispatchedView.include(request, response);
            }
        }
        catch (Exception ex)

        {
            ex.printStackTrace();
            //out.println(ex);
        }

    }

    private String getFileName(final Part part)
    {

        String contentDisp = part.getHeader("content-disposition");
        System.out.println("content-disposition header= " + contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens)
        {
            if (token.trim().startsWith("filename"))
            {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
 
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, java.io.IOException
    {

        processRequest(request, response);
    }
}
