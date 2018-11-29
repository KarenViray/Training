<%@ page language="java" isELIgnored="false"%>
<%@page import="com.demo.model.Cart"%>
<%@page import="com.demo.model.ShoppingCart"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
	<h4>Shopping Cart</h4>
	<h4><a href="./index.jsp">Product Catalog</a></h4>
	<hr/>
	<table>
	   <tr>
	       <td>Id</td>
	       <td>Name</td>
	       <td>Description</td>	    
	       <td>Price</td>
	       <td>Qty</td>
	       <td>Total</td>
	       <td>Action</td>
	   </tr>
	   <%
	    ShoppingCart shop = (ShoppingCart)session.getAttribute("shoppingCart");
	    List<Cart> items = shop.getItems();
	    for(Cart item: items) {
	   %>
	        <tr>
	           <td><%= item.getId() %></td>
	           <td><%= item.getName() %></td>
	           <td><%= item.getDesc() %></td>
	           <td><%= item.getPrice() %></td>
	           <td><%= item.getQty() %></td>
	           <td><%= item.getTotal() %></td>
	           <td>
	           		<form action="./shopping-cart" method="GET">
	           			<input type="hidden" name="pid" value="<%= item.getId() %>">
	           			<input type="hidden" name="action" value="remove">
	           			<input type="text" name="qty">
	           			<input type="submit" value="Remove to cart">
	           		</form>
	           </td>
	       </tr>
	   <%
	    }
	   %> 
		</table>
		
  <h4>Total Item(s): <%= shop.getTotalQty() %></h4>
  <h4>Grand Total: <%= shop.getTotalPrice() %></h4>		
</body>
</html>