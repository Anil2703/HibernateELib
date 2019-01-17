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
@WebServlet("/UpdateLibrarian")
public class UpdateLibrarian extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		LibrarianBean bean=(LibrarianBean)session.get(LibrarianBean.class, id);
		PrintWriter pw=response.getWriter();
		pw.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta charset=\"ISO-8859-1\">\r\n" + 
				"<title>Insert title here</title>\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<h1>Update Librarian</h1>\r\n" + 
				"\r\n" + 
				"<br>\r\n" + 
				"<br>\r\n" + 
				"<br>\r\n" + 
				"<form action=\"UpdateLibrarian2\" method=\"post\">\r\n" + 

				 
				"<input type=\"hidden\" value="+id+" name=\"id\" /><br><br>\r\n"+
				"<label for=\"librarianName\">Librarian Name</label>\r\n" + 
				"<input type=\"text\" value="+bean.getLibrarianName()+" name=\"librarianName\" id=\"librarianName\"/><br><br>\r\n" + 
				"\r\n" + 
				"<label for=\"librarianEmail\">Librarian Email</label>\r\n" + 
				"<input type=\"text\" value="+bean.getEmail()+" name=\"LibrarianEmail\" id=\"LibrarianEmail\"/><br><br>\r\n" + 
				"\r\n" + 
				"<label for=\"librarianPassword\">Librarian Password</label>\r\n" + 
				"<input type=\"password\" value="+bean.getPassword()+" name=\"librarianPassword\" id=\"librarianPassword\"/><br><br>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"<label for=\"mobile\">Librarian mobile</label>\r\n" + 
				"<input type=\"text\" value="+bean.getMobile()+" name=\"LibrarianMobile\" id=\"LibrarianMobile\"/><br><br>\r\n" + 
				"<input type=\"submit\" value=\"Update Librarian\"/>\r\n" + 
				"</form>\r\n" + 
				"<br>\r\n" + 
				"<br>\r\n" + 
				"<br>\r\n" + 
				"<a href=\"ViewLibrarians\">ViewLibrarians</a>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>");
		
		
		
	}
}
