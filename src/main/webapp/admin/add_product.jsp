<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="eKart.entities.Category"%>
<%@page import="eKart.dao.CategoryDao"%>
<head>
    <meta charset="UTF-8">
    <title>Signup Page</title>
    <%@ include file="/components/common_css_js.jsp" %>
</head>
<body>
   <div class="container">
        <h1>Signup</h1>
        <form action="/eKart/add-product" method="post" enctype="multipart/form-data">
            <div class="form-group">
                <label for="username">name</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="addr">description</label>
				<textarea name="desc"></textarea>
            </div>
            
            <div class="form-group">
                <label for="password">price</label>
                <input type="password" id="password" name="price" required>
            </div>
            <div class="form-group">
                <label for="phone">discount</label>
                <input type="text" id="phone" name="discount" required>
            </div>
            <div class="form-group">
                <label for="phone">quantity</label>
                <input type="text" id="phone" name="qty" required>
            </div>
                        
              <%
              	CategoryDao categoryDao=new CategoryDao();
               	List<Category> list = categoryDao.getCategories();
              %>
            
            <div class="form-group">
                <label for="password">category</label>
				<select name="category_id">
				<%
					for(Category c:list){
				%>
				<option value="<%= c.getCategoryId() %>"><%= c.getCategoryTitle() %></option>
					
				<%
					}
				%>
				</select>
            </div>
            
            <div class="form-group">
                <label for="email">photo</label>
                <input type="file" id="email" name="image" required>
            </div>
            
            <div class="form-group">
                <button type="submit" class="btn btn-primary">add product</button>
            </div>
        </form>
    </div>
</body>
</html>
