package com.act.earnestbank.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.act.earnestbank.dao.AccountHolderTransDAO;
import com.act.earnestbank.models.AccountHolderTrans;


/**
 * Servlet implementation class AccountHolderTxSearchServlet
 */
@WebServlet("/account-holder-trans-search")
public class AccountHolderTxSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private AccountHolderTransDAO accountHolderTransDAO;
       
	@Override
	public void init() throws ServletException {
		this.accountHolderTransDAO = new AccountHolderTransDAO();
	}
	
	  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {	
			final String idParam =   request.getParameter("id");		
			final String id = idParam;
			
			final PrintWriter out = response.getWriter();
			
			response.setContentType("text/html");
			
			final List<AccountHolderTrans> accountHoldersTrans = accountHolderTransDAO.findById(id);
			
			StringBuilder builder = new StringBuilder();
			builder.append("<html>").append("<table>");
			builder.append("<tr>");
			builder.append("<td>Account ID</td>");
			builder.append("<td>Date of Registration</td>");
			builder.append("<td>Amount</td>");
			builder.append("</tr>");
			for(AccountHolderTrans accountHolder: accountHoldersTrans) {
				builder.append("<tr>");
				builder.append("<td>").append(accountHolder.getId()).append("</td>");
				builder.append("<td>").append(accountHolder.getDateofTrans()).append("</td>");
				builder.append("<td>").append(accountHolder.getTransAmt()).append("</td>");			
				builder.append("</tr>");
			}
			builder.append("</table>").append("</html>");
			out.println(builder.toString());
			out.flush();
			out.close();
		}

}
