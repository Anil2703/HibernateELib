package com.anil.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import com.anil.beans.IssueBookBean;

@WebServlet("/IssueBook")
public class IssueBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");

		int BookNo = Integer.parseInt(request.getParameter("BookNo"));
		int Student_ID = Integer.parseInt(request.getParameter("Student_ID"));
		String Student_Name = request.getParameter("Student_Name");
		int studentmobile = Integer.parseInt(request.getParameter("Student_Mobile"));
		Date date = new Date(System.currentTimeMillis());
		String returnstatus = "no";
		IssueBookBean issuebookbean = new IssueBookBean(Student_ID, BookNo, Student_Name, studentmobile, date,
				returnstatus);
		Session session = ConnectionClass.getsession();
		session.beginTransaction();
		Query query = session.createQuery("from BookBean where BookNo=" + BookNo + "and Quantity >Issued");
		System.out.println("Works fine till here");
		List<BookBean> list = query.list();
		if (list.size() > 0) {

			System.out.println("came here , failed after this");
			session.save(issuebookbean);

			BookBean bookBean = (BookBean) session.get(BookBean.class, BookNo);
			bookBean.setIssued(bookBean.getIssued() + 1);
			session.getTransaction().commit();
			
			
			pw.println("Book Issued successfully");
			request.getRequestDispatcher("navlibrarian.html");
			request.getRequestDispatcher("IssueBook.html").include(request, response);
			session.close();
		}

		else {
			request.getRequestDispatcher("navlibrarian.html").include(request, response);

			pw.println("Unable to Issue Book due to Insufficient Books, please try after the stock comes!!");
		}

	}

}
