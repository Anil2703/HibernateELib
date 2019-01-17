package com.anil.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;

import com.anil.beans.BookBean;
import com.anil.beans.ConnectionClass;


@WebServlet("/ViewBook")
public class ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		request.getRequestDispatcher("navlibrarian.html").include(request, response);
		out.println("<br><br><br><br>");
		
		
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		Query query=session.createQuery("from BookBean");
		List<BookBean> list=query.list();
		out.println("<html><head><title>View Books</title></head><body><table border='1'>");
		out.println("<tr><th>BookNo</th><th>BookName</th><th>BoookAuthor</th><th>Book publisher</th><th>Book Quantity</th><th>Books Issued</th><th>Delete Book</th></tr>");
		for(BookBean bean:list){
			out.println("<tr><td>"+bean.getBookno()+"</td><td>"+bean.getBookName()+"</td><td>"+bean.getAuthor()+"</td><td>"+bean.getPublishers()+"</td><td>"+bean.getQuantity()+"</td><td>"+bean.getIssued()+"</td><td><a href='DeleteBook?id="+bean.getBookno()+"'>Delete</a></td></tr>");
		}
		out.println("</table>");
		
		out.println("</body></html>");
		
		
		
		out.close();
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}

}
