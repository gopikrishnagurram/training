package com.wavelabs.service;

import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.wavelabs.bean.Department;
import com.wavelabs.bean.Panidentity;
import com.wavelabs.bean.Student;
import com.wavelabs.repository.PanRepository;
import com.wavelabs.repository.StudentRepository;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired 
	DepartmentServiceImpl departmentServiceImpl;
	
	@Autowired
	PanRepository panRepository;
	
	@Transactional
	public Student storeStudent(Student student) {
		System.out.println("Inside the storeStudent()"+student.toString());
		//int result = studentRepository.saveStudent(student.getName(), student.getRollNo(),student.getStd());
		studentRepository.save(student);
		
		Department dept = new Department();
		dept.setDeptname("Comp");
		dept.setDeptno(13);
		//departmentServiceImpl.storeDepartment(dept);
		System.out.println("print1");
		System.out.println("print2");
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("HASH CODE OF tx : " + status.hashCode());
		System.out.println(status.isNewTransaction());
		
		//double d = 10/0;
		return student;
	}
	@Transactional
	public Student storeStudent1(Student student) {
		System.out.println("Inside the storeStudent()");
		//int result = studentRepository.saveStudent(student.getName(), student.getRollNo(),student.getStd());
		student.setStd("CD");
		student.setRollno(999);
		studentRepository.save(student);
		System.out.println("print3");
		System.out.println("print4");
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("HASH CODE OF tx : " + status.hashCode());
		System.out.println(status.isNewTransaction());
		//double d = 10/0;
		return student;
	}

	@Override
	public Map getStudent(int rollNo) {
		//Student student = studentRepository.findByRollNo(rollNo);
		Map studentMap = studentRepository.getStudentByRollno(rollNo);
		return studentMap;
	}
	
	@Override
	public Student getStud(int rollNo) {
		Student student = studentRepository.findByRollno(rollNo);
		return student;
	}
	@Override
	public Panidentity storePan(Panidentity panidentity) {
		// TODO Auto-generated method stub
		
		panRepository.save(panidentity);
		return panidentity;
	}
	
	@Override
	public Panidentity getPan(String panno) {
		Panidentity panidentity = panRepository.findByPanno(panno);
		return panidentity;
	}
}
