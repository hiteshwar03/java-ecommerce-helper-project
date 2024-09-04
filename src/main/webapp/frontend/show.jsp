<!DOCTYPE html>
<%@page import="eKart.entities.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Signup Confirmation</title>
</head>
<body>
	<h2>Display data</h2>
	 <h2>${user.userName}</h2>
	 <h2>${user.userEmail}</h2>
	 
	
		<c:if test="${not empty user.imageData}">>
				 <img src="${pageContext.request.contextPath}/image?id=${user.userid}" alt="User Image" width="200px" />
        </c:if>

</body>
</html>
