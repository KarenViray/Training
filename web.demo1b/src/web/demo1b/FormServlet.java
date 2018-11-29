package web.demo1b;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/form-processor")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String fullName = request.getParameter("fullName");
		final String country = request.getParameter("country");
		final String gender = request.getParameter("gender");
		final String[] programmingLanguages = request.getParameterValues("language");
		final String comment = request.getParameter("comment");

		final PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		out.print("<html>");
		out.print("<body>");
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>Full Name</td>");
		out.print("<td>" + fullName + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Country</td>");
		out.print("<td>" + country + "</td>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Programming Language(s)</td>");
		out.print("<td>");
		for (String programmingLanguage : programmingLanguages) {
			out.print(programmingLanguage + "&nbsp;");
		}
		out.print("</td>");
		out.print("<tr>");
		out.print("<td>Gender</td>");
		out.print("<td>" + gender + "</td>");
		out.print("</tr>");
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>Comment</td>");
		out.print("<td>" + comment + "</td>");
		out.print("</tr>");
		out.print("</tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");

		out.flush();
		out.close();
	}

}
