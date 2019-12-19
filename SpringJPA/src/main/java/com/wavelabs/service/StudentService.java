package com.wavelabs.service;

import java.util.Map;

import com.wavelabs.bean.Panidentity;
import com.wavelabs.bean.Student;

public interface StudentService {
	public Student storeStudent(Student student);
	public Map getStudent(int rollNo);
	public Student getStud(int rollNo);
	
	public Panidentity storePan(Panidentity panidentity);
	
	public Panidentity getPan(String panno);
}
