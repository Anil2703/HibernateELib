package com.anil.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.anil.beans.BookBean;
import com.anil.beans.ConnectionClass;

/**
 * Servlet implementation class DeleteBook
 */
@WebServlet("/DeleteBook")
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    		Session session=ConnectionClass.getsession();
    		session.beginTransaction();
    		int id=Integer.parseInt(request.getParameter("id"));
    		BookBean bean = new BookBean();
    		bean.setBookno(id);
    		session.delete(bean);
    		session.getTransaction().commit();
    		session.close();
    		response.sendRedirect("ViewBook");
    	}

}
