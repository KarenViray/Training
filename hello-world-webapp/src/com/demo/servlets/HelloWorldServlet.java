package com.demo.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet  extends HttpServlet{
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	 PrintWriter out = resp.getWriter();
    	 
    	 out.print("<html>");
    	 out.print("<head>");
    	 out.print("<title>Hello World from Server</title>");
    	 out.print("</head>");
    	 out.print("<body>");
    	 out.print("<h1>Hello world from Server</h1></hr>");
    	 out.print("</body>");
    	 out.print("</html>");
    	 
    	 out.flush();
    	 out.close();
    }
}