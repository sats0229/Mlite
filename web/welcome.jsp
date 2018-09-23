<%-- 
    Document   : welcome
    Created on : Aug 8, 2018, 2:33:33 PM
    Author     : HEROS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" buffer="16kb" %>

 <%!
            
            String user;
           
        %>
        <%
            session = request.getSession(false);
            if (session.getAttribute("username")==null)
            {
                
                response.sendRedirect("index.jsp");
            }
            else
            {
                user = (String) session.getAttribute("username");
            }
            

        %>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">

        <title>Mlite Shop Homepage </title>

        <!-- Bootstrap core CSS -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link rel="icon" type="image/png" href="images/icon.png"/>
        <!-- Custom styles for this template -->
        <link href="css/shop-homepage.css" rel="stylesheet">

    </head>

    <body>

       

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
            <div class="container">
                <a class="navbar-brand" href="#">Hi,&nbsp;<%=user%></a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="index.jsp">Home
                                <span class="sr-only">(current)</span>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#"></a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Page Content -->
        <div class="container">

            <div class="row">

                <div class="col-lg-3">

                    <h1 class="my-4">My Account</h1>
                    <div class="list-group">
                        <a href="#" class="list-group-item">My Profile</a>
                        <a href="#" class="list-group-item">My Orders</a>
                        <a href="InCart" class="list-group-item">Items In Cart</a>
                        <a href="#" class="list-group-item">Payment Detail</a>
                        <a href="invoice.jsp" class="list-group-item">Invoice Detail</a>
                        <a href="Logout?type=u" class="list-group-item">Sign Out</a>

                    </div>

                </div>
                <!-- /.col-lg-3 -->

                <div class="col-lg-9">

                    <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active">
                                <img class="d-block img-fluid" src="images/sa1.jpg" alt="First slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="images/sa2.jpg" alt="Second slide">
                            </div>
                            <div class="carousel-item">
                                <img class="d-block img-fluid" src="images/sa3.jpg" alt="Third slide">
                            </div>
                        </div>
                        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                            <span class="carousel-control-next-icon" aria-hidden="true"></span>
                            <span class="sr-only">Next</span>
                        </a>
                    </div>

                    <div class="row">

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item1.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Casual Shirts</a>
                                    </h4>
                                    <h5>Rs.2400/-</h5>
                                    <p class="card-text">An amalgam of comfort and style, casual shirts are a necessity for every man. Shop for Casual Shirts, Formal Shirts from leading brands and many more</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item2.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Formal Trousers</a>
                                    </h4>
                                    <h5>Rs.5000/-</h5>
                                    <p class="card-text">Buy Mens Cotton Trousers, Khaki Trousers, Formal Pants for Men Online in India. Shop Latest Collection of Formal Trousers for Men</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item3.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Jeans For Men</a>
                                    </h4>
                                    <h5>Rs.2499/-</h5>
                                    <p class="card-text">Create a smart casual look with slim-fit men's jeans. Choose a pair of slim jeans in brown and wear it with a striped green T-shirt</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item4.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Track Suits</a>
                                    </h4>
                                    <h5>Rs.1500/-</h5>
                                    <p class="card-text">Buy designer tracksuits for men featuring track tops, tracksuit bottoms and complete tracksuit sets from top brands like adidas, Nike, Puma and more..</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item5.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Leather Shoes</a>
                                    </h4>
                                    <h5>Rs.2099/-</h5>
                                    <p class="card-text">Buy Formal Shoes for men online at low prices.Check latest trending from lace up, slip on and leather shoes online.Wide range of black/brown formal shoes</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                        <div class="col-lg-4 col-md-6 mb-4">
                            <div class="card h-100">
                                <a href="#"><img class="card-img-top" src="images/item6.jpg" alt=""></a>
                                <div class="card-body">
                                    <h4 class="card-title">
                                        <a href="#">Wallets</a>
                                    </h4>
                                    <h5>Rs.1200/-</h5>
                                    <p class="card-text">Wallet for Men - Choose from wide collection of leather, canvas, PU mens wallets from top brands</p>
                                </div>
                                <div class="card-footer">
                                    <small class="text-muted">&#9733; &#9733; &#9733; &#9733; &#9734;</small>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.row -->

                </div>
                <!-- /.col-lg-9 -->

            </div>
            <!-- /.row -->

        </div>
        <!-- /.container -->

        <!-- Footer -->
        <!--<footer class="py-5 bg-dark">-->
        <footer
            <jsp:include page="Footer.jsp"></jsp:include>
<!--            <div class="container">
                <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
            </div>-->
            <!-- /.container -->
        </footer>

        <!-- Bootstrap core JavaScript -->

        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    </body>

</html>
