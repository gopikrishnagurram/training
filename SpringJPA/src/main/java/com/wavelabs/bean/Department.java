package com.wavelabs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "dept")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Department {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptno;
	private String deptname;
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	@Override
	public String toString() {
		return "Department [deptno=" + deptno + ", deptname=" + deptname + "]";
	}
}
