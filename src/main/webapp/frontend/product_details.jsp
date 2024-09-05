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
    <h1>Product List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Discount</th>
                <th>Description</th>
                <th>Image</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.pName}</td>
                    <td>${product.pPrice}</td>
                    <td>${product.pDiscount}</td>
                    <td>${product.pDesc}</td>
                    
                    <td>
                        <c:if test="${not empty product.imageData}">
                            <img src="${pageContext.request.contextPath}/image?id=${product.productId}" width="100" alt="Product Image" />
                        </c:if>
                    </td>
                    <td>
                            <button onclick="addToProduct(${product.productId}, '${product.pName}', ${product.pPrice})">add to cart</button>
                    </td>
                </tr>
           
        </tbody>
        
        <script src="${pageContext.request.contextPath}/js/script.js" type="text/javascript"></script>
    </table>
</body>
</html>
