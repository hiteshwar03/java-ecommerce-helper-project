<!DOCTYPE html>
<%@page import="java.util.List" %>
<%@page import="eKart.entities.Product" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
</head>
<body>
<%@ include file="/components/navbar.jsp" %>
    <h1>Your Cart</h1>
    <div class="cart-body">
    	
    	
    	
    	
    	<button class="checkout-btn">Checkout</button>
    </div>
    
    <script src="${pageContext.request.contextPath}/js/script.js" type="text/javascript"></script>
</body>
</html>
