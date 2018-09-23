<%-- 
    Document   : AdminHome
    Created on : Aug 10, 2018, 12:53:55 PM
    Author     : HEROS
--%>
<%@page contentType="text/html" pageEncoding="UTF-8" import = "javax.servlet.http.HttpSession,javax.servlet.http.Cookie" buffer="16kb"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


        <title>Admin Panel</title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="images/icon.png"/>
        <!-- Custom styles for this template -->
        <link href="css/simple-sidebar.css" rel="stylesheet">

    </head>

    <body>
        <%!
           
            String user;
           
        %>
        <%
            session = request.getSession(false);
            if (session.getAttribute("user") == null)
            {
                response.sendRedirect("index.jsp");
            }
            else
            {
                user = (String) session.getAttribute("user");
            }
            

        %>
        <div id="wrapper">

            <!-- Sidebar -->
            <div id="sidebar-wrapper">
                <ul class="sidebar-nav">
                    <li class="sidebar-brand">
                        <a href="index.jsp">
                            Go To Home
                        </a>
                    </li>
                    <li>
                        <a href="#">Admin ID: <%=user%></a>
                    </li>
                    <li>
                        <a href="AddProduct.jsp" target="_top">Add Products</a>
                    </li>

                    <li>
                        <a href="ProductUpdate.jsp">Update Products</a>
                    </li>
                    <li>
                        <a href="ViewProducts">View/Remove Products</a>
                    </li>
                    <li>
                        <a href="ViewUsers">View Users</a>
                    </li>
                    <li>
                        <a href="AdminLogout">Logout</a>
                    </li>
                </ul>
            </div>
            <!-- /#sidebar-wrapper -->

            <!-- Page Content -->
            <div id="page-content-wrapper">
                <div class="container-fluid">
                    <h1>Welcome to Mlite Shop Administrator Panel.</h1>
                    <h2></h2>
                    <p></p>
                    <p></p>
                    <a href="#menu-toggle" class="btn btn-secondary" id="menu-toggle">Start Transactions</a>
                </div>
            </div>
            <!-- /#page-content-wrapper -->

        </div>
        <!-- /#wrapper -->

        <!-- Bootstrap core JavaScript -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Menu Toggle Script -->
        <script>
            $("#menu-toggle").click(function (e) {
                e.preventDefault();
                $("#wrapper").toggleClass("toggled");
            });
        </script>

    </body>

</html>

