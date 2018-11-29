package com.demo.earnestbank.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.earnestbank.dao.AccountHolderDAO;
import com.demo.earnestbank.models.AccountHolder;

/**
 * Servlet implementation class AccountHolderSearchServlet
 */
@WebServlet("/account-holder-search")
public class AccountHolderSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AccountHolderDAO accountHolderDAO;

	@Override
	public void init() throws ServletException {
		this.accountHolderDAO = new AccountHolderDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String balanceParam = request.getParameter("balance");
		final float balance = Float.parseFloat(balanceParam);
		
		final PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		
		final List<AccountHolder> accountHolders = accountHolderDAO.findByBalance(balance);
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>").append("<table>");
		builder.append("<tr>");
		builder.append("<td>Account ID</td>");
		builder.append("<td>Registration ID</td>");
		builder.append("<td>Balance</td>");
		builder.append("</tr>");
		for(AccountHolder accountHolder: accountHolders) {
			builder.append("<tr>");
			builder.append("<td>").append(accountHolder.getId()).append("</td>");
			builder.append("<td>").append(accountHolder.getRegistrationId()).append("</td>");
			builder.append("<td>").append(accountHolder.getBalance()).append("</td>");			
			builder.append("</tr>");
		}
		builder.append("</table>").append("</html>");
		out.println(builder.toString());
		out.flush();
		out.close();
	}

}
