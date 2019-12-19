package com.wavelabs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "pan")
public class Panidentity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String panno;
	
	@OneToOne(mappedBy = "panidentity")
	@JsonManagedReference
	Student student;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPanno() {
		return panno;
	}

	public void setPanno(String panno) {
		this.panno = panno;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Panidentity [id=" + id + ", panno=" + panno +"]";
	}
}
