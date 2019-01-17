package com.anil.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class LibrarianBean {
	
	@Id
	@GeneratedValue
	private int id;
	private String LibrarianName;
	private String email;
	private String password;
	private String mobile;


	public LibrarianBean() {
	
	}


	public LibrarianBean(int id, String librarianName, String email, String password, String mobile) {
		super();
		this.id = id;
		LibrarianName = librarianName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}


	public LibrarianBean(String librarianName, String email, String password, String mobile) {
		super();
		LibrarianName = librarianName;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getLibrarianName() {
		return LibrarianName;
	}


	public void setLibrarianName(String librarianName) {
		LibrarianName = librarianName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	

}
