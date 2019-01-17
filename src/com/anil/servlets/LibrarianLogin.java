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
@WebServlet("/LibrarianLogin")
public class LibrarianLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String dbpassword=null;
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PrintWriter pw =response.getWriter();
		Session session=ConnectionClass.getsession();
		Query query=session.createQuery("from LibrarianBean where email='"+email+"'");
		List<LibrarianBean> list=query.list();
		if(list.isEmpty()==true) {
			pw.println("Librarian still not added, please contact Admin for Librarian Access first");
			request.getRequestDispatcher("index.html").include(request, response);
			
		}
		else
		{

			for(LibrarianBean l1:list)
			{
				 dbpassword=l1.getPassword();
			}if(password.equals(dbpassword))
			{
				response.sendRedirect("navlibrarian.html");
			}
			else
			{
				pw.println("Invalid Credentials, please login using your correct Email and password");
				request.getRequestDispatcher("index.html").include(request, response);
			}
	
		}	}

}
