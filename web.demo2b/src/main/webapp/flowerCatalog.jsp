<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.demo.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" isELIgnored="false"%>
<html>
<head>
    <title>Products</title>
</head>
<body>
	
	<a href = "./index.jsp">Back</a>	
	
	<table>
	   <tr>
	       <td>Id</td>
	       <td>Name</td>
	       <td>Description</td>
	       <td>Price</td>
	       <td>Quantity</td>
	       <td>Action</td>
	   </tr>
	   <%
	    List<Product> products = (List<Product>) request.getAttribute("products");
	    for(Product productctr: products) {
	   %>
	        <tr>
	           <td><%= productctr.getId() %></td>
	           <td><%= productctr.getName() %></td>
	           <td><%= productctr.getDesc() %></td>	
	           <td><%= productctr.getPrice() %></td>	           
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="<%= productctr.getId() %>">
	           			<input type="hidden" name="name" value="<%= productctr.getName() %>">
	           			<input type="hidden" name="desc" value="<%= productctr.getDesc() %>">
	           			<input type="hidden" name="price" value="<%= productctr.getPrice() %>">
	           			<input type="hidden" name="action" value="add">
	           			<select name="quantity">
	           				<c:forEach begin="1" end="10" var="index">
	           				<option value="${index}"><c:out value="${index}"/>
	           				</option>	           					
	           				</c:forEach>           		
	            			</select>
	           			<input type="submit" value="Add to cart">
	           		</form>
	           </td>	   
	       </tr>
	   <%
	    }
	   %>
	</table>
</body>
</html>
