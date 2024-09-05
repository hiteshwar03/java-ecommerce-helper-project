<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<%@ include file="/components/common_css_js.jsp" %>
  </head>
  <body>
  		<a href="/eKart/fetch-product?id=all">Home</a>&nbsp;&nbsp;
  		<a href="${pageContext.request.contextPath}/frontend/cart.jsp">Cart <span class="cart-items"></span></a>
  </body>
</html>