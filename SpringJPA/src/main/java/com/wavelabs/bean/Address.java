/*
 * package com.wavelabs.bean;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.OneToOne;
 * 
 * @Entity public class Address {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int id;
 * 
 * private String address;
 * 
 * @OneToOne(mappedBy = "panidentity.address") Student student;
 * 
 * public int getId() { return id; }
 * 
 * public void setId(int id) { this.id = id; }
 * 
 * public Student getStudent() { return student; }
 * 
 * public void setStudent(Student student) { this.student = student; }
 * 
 * public String getAddress() { return address; }
 * 
 * public void setAddress(String address) { this.address = address; }
 * 
 * @Override public String toString() { return "Address [id=" + id +
 * ", address=" + address + ", student=" + student + "]"; } }
 */