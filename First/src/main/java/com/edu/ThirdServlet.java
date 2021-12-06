package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ThirdServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter out = response.getWriter();
//		out.print("<h3> param1 : "+ request.getAttribute("userId")+"</h3>");
//		out.print("<h3> param2 : "+ request.getAttribute("password")+"</h3>");
		
		HttpSession session = request.getSession();

		out.print("<h3> param1 : " + session.getAttribute("userId") + "</h3>");
		out.print("<h3> param2 : " + session.getAttribute("password") + "</h3>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		doGet(request, response);
	}

}
