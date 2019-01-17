package com.anil.beans;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IssueBookBean {
	
	
	@Id
	private int Student_ID;
	public IssueBookBean(int student_ID, int bookNo, String student_Name, int studentmobile) {
		super();
		Student_ID = student_ID;
		BookNo = bookNo;
		Student_Name = student_Name;
		this.studentmobile = studentmobile;
	}
	public IssueBookBean() {
		super();
	}
	public IssueBookBean(int student_ID, int bookNo, String student_Name, int studentmobile, Date issueddate,
			String returnstatus) {
		super();
		Student_ID = student_ID;
		BookNo = bookNo;
		Student_Name = student_Name;
		this.studentmobile = studentmobile;
		this.issueddate = issueddate;
		this.returnstatus = returnstatus;
	}
	public int getStudent_ID() {
		return Student_ID;
	}
	public void setStudent_ID(int student_ID) {
		Student_ID = student_ID;
	}
	public int getBookNo() {
		return BookNo;
	}
	public void setBookNo(int bookNo) {
		BookNo = bookNo;
	}
	public String getStudent_Name() {
		return Student_Name;
	}
	public void setStudent_Name(String student_Name) {
		Student_Name = student_Name;
	}
	public int getStudentmobile() {
		return studentmobile;
	}
	public void setStudentmobile(int studentmobile) {
		this.studentmobile = studentmobile;
	}
	public Date getIssueddate() {
		return issueddate;
	}
	public void setIssueddate(Date issueddate) {
		this.issueddate = issueddate;
	}
	public String getReturnstatus() {
		return returnstatus;
	}
	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}
	private int BookNo;
	private String Student_Name;
	private int studentmobile;
	private Date issueddate;
	private String returnstatus;
}
