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
import com.anil.beans.IssueBookBean;
@WebServlet("/ReturnBook")
public class ReturnBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
	Session session=ConnectionClass.getsession();
	session.beginTransaction();
	request.getRequestDispatcher("navlibrarian.html").include(request, response);
	int bookno=Integer.parseInt(request.getParameter("Book_No"));
	int student_id=Integer.parseInt(request.getParameter("Student_ID"));
	Query query=session.createQuery("from IssueBookBean where BookNo="+bookno+"and  student_id="+student_id);
	List<IssueBookBean> list=query.list();
	for(IssueBookBean i1:list)
	{
		i1.setReturnstatus("yes");
	}
	
	BookBean bb=(BookBean)session.get(BookBean.class,bookno);
	bb.setIssued(bb.getIssued()-1);
	session.update(bb);
	session.getTransaction().commit();
	session.close();
	pw.println("Book Returned successfully");
	response.sendRedirect("ViewBook");
	
	
		
	}

}
