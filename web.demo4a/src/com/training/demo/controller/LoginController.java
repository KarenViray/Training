package com.training.demo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.training.demo.bean.LoginForm;

public class LoginController extends AbstractController {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		LoginForm loginForm = toBean(request);
		loginForm.validate();
		
		RequestDispatcher dispatcher = null;
		String viewPage = "/success.jsp";		
		if(!loginForm.isFormValid()) {
			// login.jsp
			viewPage = "/login.jsp";			
			request.setAttribute("loginForm", loginForm);		
		} 
		
		dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}
	
	private LoginForm toBean(HttpServletRequest request) {
		LoginForm loginForm = new LoginForm();
		
		loginForm.setUsername(request.getParameter("username"));
		loginForm.setPassword(request.getParameter("password"));
		
		return loginForm;
	}
	
}
