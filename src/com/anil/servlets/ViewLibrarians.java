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

import com.anil.beans.ConnectionClass;
import com.anil.beans.LibrarianBean;


@WebServlet("/ViewLibrarians")
public class ViewLibrarians extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		Query query=session.createQuery("from LibrarianBean");
		List<LibrarianBean> list=query.list();
		pw.println("<html><body><h1>List of Librarians</h1><table border=1><tr><th>id</th><th>LibrarianName</th>"
				+ "<th>email</th><th>password</th><th>mobile</th></tr>");
		for(LibrarianBean lb:list)
		{
		pw.println("<tr><td>"+lb.getId()+"</td><td>"+lb.getLibrarianName()+"</td><td>"+lb.getEmail()+"</td><td>"
					+lb.getPassword()+"</td><td>"+lb.getMobile()+"</td><td><a href='UpdateLibrarian?id="+lb.getId()+"'>UpdateLibrarian</a></td><td><a href='DeleteLibrarian?id="+lb.getId()+"'>Remove Librarian</a></td></tr>");	
		}
		pw.println("</table></body></html>");
		pw.println("<a href='AddLibrarian.html'>Add More Librarians</a>");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
