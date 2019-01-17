package com.anil.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.anil.beans.BookBean;
import com.anil.beans.ConnectionClass;

@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		 
		PrintWriter pw=response.getWriter();
		 int bookno=Integer.parseInt(request.getParameter("bookno"));
		 String bookName=request.getParameter("bookName");
		 String author=request.getParameter("author");
		 String publishers=request.getParameter("publishers");
		 int quantity=Integer.parseInt(request.getParameter("quantity"));


		 BookBean  bookBean= new BookBean(bookno, bookName, author, publishers, quantity);
		 Session session= ConnectionClass.getsession();
		 session.beginTransaction();
		 session.save(bookBean);
		 session.getTransaction().commit();
		 session.close();
		 request.getRequestDispatcher("navlibrarian.html").include(request, response);
		 pw.println("<h2><i>Book Added Successfully</i></h2>");
		 request.getRequestDispatcher("LibrarianHome.html").include(request, response);
	}

}
