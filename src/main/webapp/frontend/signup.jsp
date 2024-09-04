<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>
    <%@ include file="/components/common_css_js.jsp" %>
</head>
<body>
   <div class="container">
        <h1>Signup</h1>
        <form action="/eKart/signup" method="post">
            <div class="form-group">
                <label for="username">Name</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="addr">Address</label>
				<textarea name="address"></textarea>
            </div>
            <div class="form-group">
                <label for="password">UserType</label>
				<select name="usertype">
					<option value="normal">Normal</option>
					<option value="admin">Admin</option>
				</select>
            </div>
            
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Signup</button>
            </div>
            <div class="form-group">
                <a href="/login">Already have an account? Login</a>
            </div>
        </form>
    </div>
</body>
</html>
