<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>
    <%@ include file="components/common_css_js.jsp" %>
</head>
<body>
    <h2>Signup</h2>
   
    <form action="signup" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>
        
        <input type="submit" value="Sign Up" class="btn btn-primary">
    </form>
</body>
</html>
