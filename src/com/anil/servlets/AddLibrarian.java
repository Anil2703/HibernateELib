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

/**
 * Servlet implementation class AddLibrarian
 */
@WebServlet("/AddLibrarian")
public class AddLibrarian extends HttpServlet {
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
		session.save(librarianBean);
		session.getTransaction().commit();
		session.close();
		pw.println("<h2><i>Librarian Added Successfully!!!</i></h2>");
		request.getRequestDispatcher("AddLibrarian.html").include(request, response);
	}

}
