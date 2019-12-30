package com.example.demo.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;



@Entity
public class Playerdetails {

	@Id
	int no;

	@NotNull
	String name;

	int age;

	String role;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Player1 [no=" + no + ", name=" + name + ", age=" + age + ", role=" + role + "]";
	}

}
