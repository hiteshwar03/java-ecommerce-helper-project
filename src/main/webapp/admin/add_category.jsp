<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
        <h1>Signup</h1>
        <form action="/eKart/add-category" method="post">
            <div class="form-group">
                <label for="username">category name</label>
                <input type="text" id="name" name="category_name" required>
            </div>
            
            <div class="form-group">
                <label for="addr">category description</label>
				<textarea name="category_desc"></textarea>
            </div>
            
            
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">Add category</button>
            </div>
            
        </form>
    </div>
</body>
</html>