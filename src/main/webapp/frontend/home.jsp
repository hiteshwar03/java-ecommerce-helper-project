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
    
    <a href="${pageContext.request.contextPath}/fetch-product?id=all">
           All products              
         </a> &nbsp;&nbsp;
    
      <c:forEach var="category" items="${categories}">
      	<a href="${pageContext.request.contextPath}/fetch-product?id=${category.categoryId}">
            ${category.categoryTitle}                  
         </a> &nbsp;&nbsp;
      </c:forEach>
      <br>
      <br>
    
    
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Image</th>
                <th>Action</th> <!-- Added column for action buttons -->
            </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.pName}</td>
                    <td>
                        <c:if test="${not empty product.imageData}">
                            <img src="${pageContext.request.contextPath}/image?id=${product.productId}" width="100" alt="Product Image" />
                        </c:if>
                    </td>
                    <td>
                    	 <a href="${pageContext.request.contextPath}/viewProduct?id=${product.productId}">
                            <button>View Product</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
