<%@ page language="java" %>
<jsp:useBean id="product" class="com.demo.model.ProductModel" scope="request"/>
<html>
	<head>
		<title>Add Toy</title>
		<style type="text/css">
			.error {
				color: red;
				font-weight: bold;
			}
		</style>
	</head>
	<body>
		<h1>Add Toy</h1>
		<form action="./add-product" method="GET">
			<p>
				<label>TID</label>
				<input type="text" name="id" value="<%=product.getId() == null ? "" : product.getId()%>">
				<label for="error" class="error"><%= product.getError("id") %></label>
			</p>
			<p>
				<label>Name</label>
				<input type="text" name="name" value="<%=product.getName() == null ? "" : product.getName()%>">
				<label for="error" class="error"><%= product.getError("name") %></label>
			</p>
			<p>
				<label>Description</label>
				<input type="text" name="desc" value="<%=product.getDesc() == null ? "" : product.getDesc()%>">
				<label for="error" class="error"><%= product.getError("desc") %></label>
			</p>
			<p>
				<label>Price</label>
				<input type="text" name="price" value="<%=product.getsPrice() == null ? "" : product.getsPrice()%>">
				<label for="error" class="error"><%= product.getError("price") %></label>
			</p>
			<p>				
				<input type="submit" value="Submit">
			</p>
		</form>
	</body>
</html>