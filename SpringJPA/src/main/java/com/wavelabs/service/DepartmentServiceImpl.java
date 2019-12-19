package com.wavelabs.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import com.wavelabs.bean.Department;
import com.wavelabs.repository.DepartmentRepository;

@Service("departmentServiceImpl")
public class DepartmentServiceImpl implements DeptService{
	@Autowired
	DepartmentRepository departmentRepository;
	
	public Department storeDepartment(Department dept) {
		System.out.println("Inside the storeStudent()"+dept.toString());
		departmentRepository.save(dept);
		System.out.println("print1");
		System.out.println("print2");
		
		TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
		System.out.println("HASH CODE OF tx : " + status.hashCode());
		System.out.println(status.isNewTransaction());
		
		//double d = 10/0;
		return dept;
	}

	@Override
	public List<Map> getDepartment(){
		List<Map> departmentList = departmentRepository.get();
		/*
		 * for(int i = 0;i<departmentList.length;i++) {
		 * System.out.println(departmentList[i]); }
		 */
		return departmentList;
	}
}
