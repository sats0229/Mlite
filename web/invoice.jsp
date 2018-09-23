<%-- 
    Document   : invoice
    Created on : Sep 7, 2018, 12:33:54 PM
    Author     : HEROS
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Random"%>
<%@page import="DAo.Orders"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.CartItems"%>
<%@page import="DAo.DAOOperations"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="Error.jsp"%>
<!doctype html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Shoping Invoice</title>
        <link rel="icon" type="image/png" href="images/icon.png"/>
        <style>
            .invoice-box {
                max-width: 800px;
                margin: auto;
                padding: 30px;
                border: 1px solid #eee;
                box-shadow: 0 0 10px rgba(0, 0, 0, .15);
                font-size: 16px;
                line-height: 24px;
                font-family: 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
                color: #555;
            }

            .invoice-box table {
                width: 100%;
                line-height: inherit;
                text-align: left;
            }

            .invoice-box table td {
                padding: 5px;
                vertical-align: top;
            }

            .invoice-box table tr td:nth-child(2) {
                text-align: right;
            }

            .invoice-box table tr.top table td {
                padding-bottom: 20px;
            }

            .invoice-box table tr.top table td.title {
                font-size: 45px;
                line-height: 45px;
                color: #333;
            }

            .invoice-box table tr.information table td {
                padding-bottom: 40px;
            }

            .invoice-box table tr.heading td {
                background: #eee;
                border-bottom: 1px solid #ddd;
                font-weight: bold;
            }

            .invoice-box table tr.details td {
                padding-bottom: 20px;
            }

            .invoice-box table tr.item td{
                border-bottom: 1px solid #eee;
            }

            .invoice-box table tr.item.last td {
                border-bottom: none;
            }

            .invoice-box table tr.total td:nth-child(2) {
                border-top: 2px solid #eee;
                font-weight: bold;
            }

            @media only screen and (max-width: 600px) {
                .invoice-box table tr.top table td {
                    width: 100%;
                    display: block;
                    text-align: center;
                }

                .invoice-box table tr.information table td {
                    width: 100%;
                    display: block;
                    text-align: center;
                }
            }

            /** RTL **/
            .rtl {
                direction: rtl;
                font-family: Tahoma, 'Helvetica Neue', 'Helvetica', Helvetica, Arial, sans-serif;
            }

            .rtl table {
                text-align: right;
            }

            .rtl table tr td:nth-child(2) {
                text-align: left;
            }
        </style>
    </head>

    <body>

        <%
            session = request.getSession(false);
            String email = session.getAttribute("uname").toString();
            
            if (session.getAttribute("username") == null && DAOOperations.inCart(email) == true)
            {
               out.println("<html><body><script>alert('First add items to the cart!!');</script></body></html>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request, response);
            }
            else{
            DAOOperations.initialize();
            ArrayList<CartItems> pr = DAOOperations.getCartitems(session.getAttribute("uname").toString());
            double totalOrderCost = 0;
            

            Orders od = DAOOperations.getOrderDetails(email);
            String []add =  od.getUseraddress().split(",");
            Date d =new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yyyy");
            
            
        %>
    <center>INVOICE</center><a href="index.jsp">Home</a> | <a href="#" onclick="window.print();">Print Invoice</a>
    <div class="invoice-box">
        <table cellpadding="0" cellspacing="0">
            <tr class="top">
                <td colspan="2">
                    <table>
                        <tr>
                            <td class="title">
                                <img src="images/logo.png" style="width:100%; max-width:300px;">
                            </td>

                            <td>
                                Invoice #: <%=new Random().hashCode()%><br>
                                Created: <%=sdf.format(d)%><br>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="information">
                <td colspan="2">
                    <table>
                        <tr>
                            <td><b>From:</b><br>
                                Sparksuite, Inc.<br>
                                12345 Sunny Road<br>
                                Sunnyville, CA 12345
                            </td>

                            <td><b>Recipient Details:</b><br>
                                <b><%=od.getRecipientname()%></b><br>
                                <%=od.getUseraddress()%><br>
                                <%=od.getCity()%>-<%=od.getPincode()%>,<%=od.getState()%><br>
                                <%=od.getPhonenumber()%><br>
                                <%=email%>
                            </td>
                        </tr>
                    </table>
                </td>
            </tr>

            <tr class="heading">
                <td>
                    Payment Method
                </td>

                <td>

                </td>
            </tr>

            <tr class="details">
                <td>
                    Cash On Delivery
                </td>
            </tr>

            <tr class="heading">
                <td>
                    Items
                </td>

                <td>
                    Price
                </td>
            </tr>
            <% for (CartItems p1 : pr)
                {
                    totalOrderCost = totalOrderCost + p1.getSubTotal();%>
            <tr class="item">
                <td>
                    <%=p1.getProductName() + "(" + p1.getQuantity() + ")"%>
                </td>

                <td>
                    <%=p1.getSubTotal()%>
                </td><%}%>

            <tr class="total">
                <td></td>

                <td>
                    <%=totalOrderCost%>
                </td>
            </tr>
        </table>
    </div>
    <%}%>
</body>
</html>

