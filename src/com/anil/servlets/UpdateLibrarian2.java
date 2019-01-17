package com.anil.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.anil.beans.ConnectionClass;
import com.anil.beans.LibrarianBean;
@WebServlet("/UpdateLibrarian2")
public class UpdateLibrarian2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Session session=ConnectionClass.getsession();
		PrintWriter pw=response.getWriter();
		
		String librarianName=request.getParameter("librarianName");
		String LibrarianEmail=request.getParameter("LibrarianEmail");
		String librarianPassword=request.getParameter("librarianPassword");
		String LibrarianMobile=request.getParameter("LibrarianMobile");
		
		LibrarianBean librarianBean= new LibrarianBean(librarianName, LibrarianEmail, librarianPassword, LibrarianMobile);
		session.beginTransaction();
		LibrarianBean lb=(LibrarianBean)session.get(LibrarianBean.class,(int)Integer.parseInt(request.getParameter("id")));
		lb.setLibrarianName(librarianName);
		lb.setEmail(LibrarianEmail);
		lb.setMobile(LibrarianMobile);
		lb.setPassword(librarianPassword);
		session.update(lb);
		session.getTransaction().commit();
		session.close();
		response.sendRedirect("ViewLibrarians");
		
	}

}
