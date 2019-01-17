package com.anil.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@Entity
public class BookBean {

	@Id
	private int bookno;
	private String bookName;
	private String author;
	private String publishers;
	private int quantity;
	private int issued;
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublishers() {
		return publishers;
	}
	public void setPublishers(String publishers) {
		this.publishers = publishers;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getIssued() {
		return issued;
	}
	public void setIssued(int issued) {
		this.issued = issued;
	}
	public BookBean(int bookno, String bookName, String author, String publishers, int quantity) {
		super();
		this.bookno = bookno;
		this.bookName = bookName;
		this.author = author;
		this.publishers = publishers;
		this.quantity = quantity;
		
	}
	public BookBean() {
		super();
	}
	
	
}
