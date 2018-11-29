package com.demo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.model.Product;
import com.demo.dao.BookDetailsDAO;
import com.demo.util.DatabaseConfig;


@WebServlet(urlPatterns = "/product-book", loadOnStartup = 1)
public class BookDetailsController extends HttpServlet{
	private BookDetailsDAO  BookDetailsDAO;
	private DatabaseConfig databaseConfig;
	
	@Override
	public void init() throws ServletException {
		this.databaseConfig = new DatabaseConfig();
		this.BookDetailsDAO = new BookDetailsDAO(databaseConfig.getUrl(), 
													 databaseConfig.getUsername(), 
													 databaseConfig.getPassword());
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/bookCatalog.jsp");
		List<Product> products = BookDetailsDAO.findBook();
		request.setAttribute("products", products);
		dispatcher.forward(request, response);
	}

}
