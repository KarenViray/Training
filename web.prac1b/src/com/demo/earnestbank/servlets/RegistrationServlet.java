package com.demo.earnestbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.demo.earnestbank.dao.RegistrationDAO;
import com.demo.earnestbank.models.Registration.Registration;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private RegistrationDAO RegistrationDAO; 
	
	@Override
	public void init() throws ServletException {
		this.RegistrationDAO = new RegistrationDAO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		final PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		final List<Registration> registration = RegistrationDAO.findType();
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>").append("<table>");
		builder.append("<tr>");
		builder.append("<td>Registration ID</td>");
		builder.append("<td>Registration ID</td>");
		builder.append("<td>Balance</td>");
		builder.append("</tr>");
		for(Registration Registration: registration) {
			builder.append("<tr>");
			builder.append("<td>").append(Registration.getRegistrationId()).append("</td>");
			builder.append("<td>").append(Registration.getFirstName()).append("</td>");					
			builder.append("</tr>");
		}
		builder.append("</table>").append("</html>");
		out.println(builder.toString());
		out.flush();
		out.close();
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
