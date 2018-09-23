

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <head>
        <title>Product Delivery Form </title>
        <!-- for-mobile-apps -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="keywords" content="Product Delivery Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
              Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
        <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
            function hideURLbar(){ window.scrollTo(0,1); } </script>
        <!-- //for-mobile-apps -->
        <!-- js -->
        <script src="js/jquery-2.1.3.min.js" type="text/javascript"></script>
        <!-- //js -->
        <link href="css/style2.css" rel="stylesheet" type="text/css" media="all" />
        <link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,500,400italic,500italic,700,700italic' rel='stylesheet' type='text/css'>
        <link rel="icon" type="image/png" href="images/icon.png"/>
    </head>
    <body>
         <%
            session = request.getSession(false);
            if (session.getAttribute("username") == null)
            {
                response.sendRedirect("index.jsp");
            }
        %>
        <div class="main">
            <h1>Product Delivery Form</h1>
            <div class="agileinfo_main">
                <form id="testform" action="OrderDetail" method="post" novalidate>



                    <fieldset style="border: 1px solid rgba(74, 235, 122, 0.822)">
                        <legend>Customer Details :</legend>

                        <p for="firstName" class="w3_field1">Full Name</p>
                        <input id="firstName" name="Rname" type="text" required data-error-msg="We need to know who you are" />

                        <p for="phoneNum">Phone number</p>
                        <input id="phoneNum" name="phoneNum" type="tel" required data-error-msg="Please enter your phone number" />

                        <p for="city2">City</p>
                        <input id="city2" name="city" type="text" required data-error-msg="We need to know which city" />

                        <p for="state">State</p>
                        <input id="state" name="state" type="text" required data-error-msg="We need to know which state" />

                        <p for="pincode2">Pincode</p>
                        <input id="pincode2" name="pincode" type="text" required data-error-msg="Please enter a valid 6 digit pincode" />
                        <p for="country1" class="w3_field1">Address Type</p>
                        <select id="country1" name="Addtype" required>
                            <option>Select</option>
                            <option value="Home Address">Home Address</option>
                            <option value="Office Address">Office Address</option>
                        </select>
                        <p for="pickaddress" class="w3_textarea">Delivery Address</p>
                        <textarea id="pickaddress" name="Addr" placeholder=" " required data-error-msg="Please enter valid address"></textarea>

                        <p for="country" class="w3_field1">Payment Option</p>
                        <select id="country" name="country" required>
                            <option value="Cash On Delivery">Cash On Delivery</option>
                        </select>
                    </fieldset>

                    <button id="expandBtn" type="button" class="expand-trigger" aria-expanded="false" aria-controls="collapsedSection">Ask any question?</button>
                    <div id="collapsedSection" aria-hidden="true">
                        <p for="hiddenInput">This field may or may not be visible</p>
                        <input id="hiddenInput" name="hiddenInput" type="text" required data-error-msg="You wanted an extra question"></input>
                    </div>

                    <input type="submit" value="Submit">
                    <input type="reset" value="Reset" />

                </form>
            </div>
            <!-- Calendar -->
            <link rel="stylesheet" href="css/jquery-ui2.css" />
            <script src="js/jquery-ui2.js"></script>
            <script>
$(function () {
    $("#datepicker").datepicker();
});
            </script>
            <!-- //Calendar -->
            <script src="js/attrvalidate.jquery.js" type="text/javascript"></script>
            <script type="text/javascript">
$(document).ready(function () {
    $('#testform').attrvalidate();
    $('#resetBtn').click(function () {
        $('#testform').attrvalidate('reset');
    });
    $('#expandBtn').click(function () {
        var collapsible = $('#' + $(this).attr('aria-controls'));
        $(collapsible).attr('aria-hidden', ($(collapsible).attr('aria-hidden') === 'false'));
        $(this).attr('aria-expanded', ($(this).attr('aria-expanded') === 'false'));
    });
});
            </script>
            <div class="agileits_copyright">
                <p>© 2016 Product Delivery Form. All rights reserved | Design by <a href="">Mlite Shop</a></p>
            </div>
        </div>
    </body>
</html>