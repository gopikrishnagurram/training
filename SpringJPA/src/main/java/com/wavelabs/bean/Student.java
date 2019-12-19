package com.wavelabs.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "std")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollno;
	private String name;
	private String std;

	@OneToOne()
	@JsonBackReference
	Panidentity panidentity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public Panidentity getPanidentity() {
		return panidentity;
	}

	public void setPanidentity(Panidentity panidentity) {
		this.panidentity = panidentity;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollno + ", name=" + name + ", std=" + std + ", panidentity=" + panidentity + "]";
	}
}
