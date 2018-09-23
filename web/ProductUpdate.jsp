<%-- 
    Document   : ProductUpdate
    Created on : Aug 12, 2018, 7:45:41 PM
    Author     : HEROS
--%>

<%@page import="java.util.List"%>
<%@page import="DAo.Products"%>
<%@page import="DAo.DAOOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" type="image/png" href="images/icon.png"/>
        <title>Update Product</title>
    </head>
    <body>

        <%
            session = request.getSession();
            if (session.getAttribute("user") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
            
            %>
        <%
            DAOOperations.initialize();
           List<Products> pr = DAOOperations.getALLProducts();
        %>
    <center> <a href='AdminHome.jsp'><b>GO BACK TO PANEL</b></a></center>
    <form action="ChangeProduct" method="POST">
        <fieldset>
            <table border="0">


                <tbody>
                <legend><b><u>Update Products:</u></b></legend>

                <tr>
                    <td>Product Name:</td>
                    <td><select name='pid'>
                            <%
                                
                                for(Products p:pr)
                                {%>
                                <option value='<%=p.getProductId()%>'><%=p.getProName()%></option>
                                    
                                <%}
                            %>
                            
                        </select></td>
                </tr>
                <tr>
                    <td>New Product Name:</td>
                    <td><input type="text" name="Pname" required></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><input type="number" name="Pqty" min="1" ></td>
                </tr>
                <tr>
                    <td>Product price:</td>
                    <td><input type="number" name="Pprice" min="1" ></td>
                </tr>

                <tr>
                    <td>Product Description:</td>
                    <td><input type="text" name="Pdesc" ></td>
                </tr>

                <tr>
                    <td>
                        <input  type="submit"  value="Update" > 
                    </td>
                    <td>
                        <input type="reset" value="Reset">
                    </td>
                </tr>

                </tbody>
        </fieldset>
    </table>

</form>
</body>
</html>
