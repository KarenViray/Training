<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<jsp:useBean id="addForm" class="com.demo.model.Product" scope="request"/>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Toy Product</title>
</head>
<body>
<form action="./add-toy" method="GET">
			<p>
			    <label>TID</label>
				<input type="text" name="id" value="<%=addForm.getId()%>">			
			</p>
			<p>
				<label>NAME</label>
				<input type="text" name="name" value="<%=addForm.getName()%>">				
			</p>
			<p>
				<label>DESCRIPTION</label>
				<input type="text" name="desc" value="<%=addForm.getDesc()%>">			
			</p>
			<p>
				<label>PRICE</label>
				<input type="text" name="price" value="<%=addForm.getPrice()%>">				
			</p>
			<p>				
				<input type="submit" value="Login">
			</p>
		</form>

</body>
</html>