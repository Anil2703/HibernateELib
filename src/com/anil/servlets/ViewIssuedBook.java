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

import com.anil.beans.ConnectionClass;
import com.anil.beans.IssueBookBean;
@WebServlet("/ViewIssuedBook")
public class ViewIssuedBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter pw=response.getWriter();
		
  
	
	Session session=ConnectionClass.getsession();
	session.beginTransaction();
	Query query=session.createQuery("from IssueBookBean");
	List<IssueBookBean> list = query.list();
	request.getRequestDispatcher("navlibrarian.html").include(request, response);
	pw.println("<br>");
	pw.println("<h1>Issued Books</h1>");
	pw.println("<html><head><title>View Issued Books</title></head><body><table border='1'><tr>"
			+"<th>BookNo</th>"+"<th>Student_ID</th>"+"<th>Student_Name</th>"+"<th>studentmobile</th>"+"<th>issueddate</th>"+"<th>returnstatus</th></tr>");
	for(IssueBookBean l1:list)
	{
		pw.println("<tr><td>"+l1.getBookNo()+"</td><td>"+l1.getStudent_ID()+"</td><td>"+l1.getStudent_Name()+"</td><td>"+
				l1.getStudentmobile()+"</td><td>"+l1.getIssueddate()+"</td><td>"+
				l1.getReturnstatus()+"</td><tr>");
	}
	pw.println("</table></body></html>");
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
