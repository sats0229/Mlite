<%-- 
    Document   : getProducts
    Created on : Aug 16, 2018, 1:01:56 PM
    Author     : HEROS
--%>

<%@page import="DAo.CustomerRegistration"%>
<%@page import="java.util.List"%>
<%@page import="DAo.Products"%>
<%@page import="DAo.DAOOperations"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            try
            {
            String catName = request.getParameter("category");
            DAOOperations.initialize();
            List<Products> productList = DAOOperations.getProductList(catName);
            String result="";
            for (Products product : productList)
           {
              
               result=result.concat("<div class='col-md-3 product-men'><div class='men-pro-item simpleCart_shelfItem'><div class='men-thumb-item'><img src='"+product.getProductimage()+"' alt='' class='pro-image-front'><img src='"+product.getProductimage()+"' alt='' class='pro-image-back'><div class='men-cart-pro'><div class='inner-men-cart-pro'><a href='view.jsp?pid="+product.getProductId()+"' class='link-product-add-cart' target='_blank'>Quick View</a></div></div><span class='product-new-top'>New</span></div><div class='item-info-product '><h4><a href='view.jsp?pid="+product.getProductId()+"'>"+product.getProName()+"</a></h4><div class='info-product-price'><span class='item_price'>Rs."+product.getProPrice()+"</span></div><div class='snipcart-details top_brand_home_details item_add single-item hvr-outline-out button2'><form action='CustomerCart' method='post'><fieldset><input type='hidden' name='PID' value='"+product.getProductId()+"' /><input type='submit' name='submit' value='Add to cart' class='button' /></fieldset></form></div></div></div></div>");
                       
}
out.println(result);
    }
            catch(Exception ex)
    {
        out.println(ex);
}
%>
 
</body>
</html>
