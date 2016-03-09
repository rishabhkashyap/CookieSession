package com.servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(description = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("user");
		String password = request.getParameter("pwd");
		if ((username.equals("abc")) && (password.equals("abc"))) {
			Cookie cookie = new Cookie("user", username);

			// Cookie will expire in 30 mins
			cookie.setMaxAge(30 * 60);
			response.addCookie(cookie);
			response.sendRedirect("LoginSuccess.jsp");

		} else {
			RequestDispatcher disp = request.getRequestDispatcher("index.jsp");
			PrintWriter out = response.getWriter();
			out.println("<h1>username or password is wrong...Pleae try again!!<h1>");
			disp.include(request, response);
		}

	}

}
