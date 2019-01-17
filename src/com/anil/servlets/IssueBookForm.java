package com.anil.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/IssueBookForm")
public class IssueBookForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		 pw.println("<h2><i>Please issue the Books here!!</i></h2>");
		 
			request.getRequestDispatcher("IssueBook.html").include(request, response);
			pw.close();
	}

}
