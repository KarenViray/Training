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
import com.demo.dao.ToyDetailsDAO;
import com.demo.util.DatabaseConfig;


@WebServlet(urlPatterns = "/product-toys", loadOnStartup = 1)
public class ToyDetailsController extends HttpServlet{
	private ToyDetailsDAO  ToyDetailsDAO;
	private DatabaseConfig databaseConfig;
	
	@Override
	public void init() throws ServletException {
		this.databaseConfig = new DatabaseConfig();
		this.ToyDetailsDAO = new ToyDetailsDAO(databaseConfig.getUrl(), 
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/toyCatalog.jsp");
		List<Product> products = ToyDetailsDAO.findToy();
		request.setAttribute("products", products);
		dispatcher.forward(request, response);
	}

}
