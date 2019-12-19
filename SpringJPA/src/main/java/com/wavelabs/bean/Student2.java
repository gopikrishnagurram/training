package com.wavelabs.bean;

import com.fasterxml.jackson.annotation.JsonAlias;

public class Student2{
	
	@JsonAlias({"roll_no","rollNo"})
	private int rollNo;
	private String name;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + ", rollNo=" + rollNo + "]";
	}
}
