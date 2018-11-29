package web.demo1a;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		final String username = req.getParameter("username");
		final String password = req.getParameter("password");
		
		final PrintWriter out = resp.getWriter();
		
		resp.setContentType("text/html");
		
		out.print("<html>");
		out.print("<body>");
		out.print(String.format("username=%s, password=%s", username, password));
		out.print("</body>");
		out.print("</html>");
		
		out.flush();
		out.close();
		
	}
}
