package com.anil.RestResponses.json;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.anil.beans.BookBean;
import com.anil.beans.ConnectionClass;

@Path("/ViewBookJson")
public class ViewBooksJson {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<BookBean> getAllAvailableBooks()  {
		Session session=ConnectionClass.getsession();
		session.beginTransaction();
		Query query=session.createQuery("from BookBean");
		List<BookBean> list=query.list();
		
		return list;
		}
		

}
