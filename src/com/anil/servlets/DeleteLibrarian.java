package com.anil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.anil.beans.ConnectionClass;
import com.anil.beans.LibrarianBean;


@WebServlet("/DeleteLibrarian")
public class DeleteLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		String id=request.getParameter("id");
		int sid=Integer.parseInt(id);
		LibrarianBean lb = new LibrarianBean();
		lb.setId(sid);
		session.delete(lb);
		session.getTransaction().commit();
		session.close();
		response.sendRedirect("ViewLibrarians");
	}

}
