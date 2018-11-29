package com.demo.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.model.Cart;
import com.demo.model.ShoppingCart;


@WebServlet(urlPatterns = "/shopping-cart", loadOnStartup = 1)
public class ShoppingCartController extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	final HttpSession session = request.getSession(true);
    ShoppingCart shoppingCart = (ShoppingCart)session.getAttribute("shoppingCart");
    List<Cart> items = new ArrayList<>();
    if (shoppingCart == null) {
    	shoppingCart = new ShoppingCart(items, 0, 0);
    }
    
    String action = request.getParameter("action");
    if(action == null) {
    	action = "";
    }
    if(action.equals("add")) {
        String pid = request.getParameter("pid");
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        String price = request.getParameter("price");
        String quantity = request.getParameter("quantity");
        int iPrice = Integer.parseInt(price);
        int iqty = Integer.parseInt(quantity);
        
        Cart addedItem = new Cart(pid, name, desc, iPrice, iqty, iPrice*iqty);
        shoppingCart.addToCart(addedItem);
    }  else if(action.equals("remove")){
    	String pid = request.getParameter("pid");
    	shoppingCart.removeItem(pid);
    } 
    	
    session.setAttribute("shoppingCart", shoppingCart);
    
    final RequestDispatcher dispatcher = request.getRequestDispatcher("/shopCart.jsp");
    dispatcher.forward(request, response);
}
	
}
	


