package com.anil.soapresponses;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.bind.annotation.XmlType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.anil.beans.BookBean;
import com.anil.beans.ConnectionClass;

@WebService()
//@SOAPBinding(style=Style.RPC)
public class ViewBooksResponse {
	
	
	
	
	@WebMethod()
	@WebResult(name="status")
	public List<BookBean> getAllAvailableBooks()  {
	Session session=ConnectionClass.getsession();
	session.beginTransaction();
	Query query=session.createQuery("from BookBean");
	List<BookBean> list=query.list();
	
	return list;
	}
	
	@WebMethod
	@WebResult(name="status")
	public List<BookBean> ViewParticularBook(@WebParam(name="BookName")String BookName)  {
	Session session=ConnectionClass.getsession();
	session.beginTransaction();
	Query query=session.createQuery("from BookBean where BookName='"+BookName+"' order by bookno");
	List<BookBean> list=query.list();
	
	return list;
	}
	
	@WebResult(name="status")
	public String AddNewBook(@WebParam(name="BookNo")int bookno,@WebParam(name="BookName")String bookName,
			@WebParam(name="Author")String author,@WebParam(name="Publishers")String publishers,@WebParam(name="quantity")int Quantity)
	{
		BookBean newbook = new BookBean(bookno, bookName, author, publishers, Quantity);
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		session.save(newbook);
		session.getTransaction().commit();
		session.close();
		
		return "success";
		
		
	}
	
	
}
