<%-- 
    Document   : AddProduct
    Created on : Aug 7, 2018, 2:48:48 PM
    Author     : HEROS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="icon" type="image/png" href="images/icon.png"/>
        <title>Add Product</title>
    </head>
    <body>
        <%
            session = request.getSession(false);
            if (session.getAttribute("user") == null)
            {
                response.sendRedirect("AdminLogin.jsp");
            }
        %>

    <center> <a href='AdminHome.jsp'><b>GO BACK TO PANEL</b></a></center>
    <form action="UpdateProducts" method="POST" enctype="multipart/form-data">
        <fieldset>
            <table border="0">


                <tbody>
                <legend><b><u>Add Products:</u></b></legend>

                <tr>
                    <td>Product Name:</td>
                    <td><input type="text" name="Pname" required></td>
                </tr>
                <tr>
                    <td>Product Quantity:</td>
                    <td><input type="number" name="Pqty" min="1" required></td>
                </tr>
                <tr>
                    <td>Product price:</td>
                    <td><input type="number" name="Pprice" min="1" required></td>
                </tr>
                <tr>
                    <td>Product category:</td>
                    <td><input type="text" name="Pcategory" required></td>
                </tr>
                <tr>
                    <td>Product Description:</td>
                    <td><input type="text" name="Pdesc" required></td>
                </tr>
                <tr>
                    <td>Product Image:</td>
                    <td><input type="file" name="Pimage" required></td>


                </tr>
                <tr>
                    <td>
                        <input  type="submit"  value="Add" > 
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