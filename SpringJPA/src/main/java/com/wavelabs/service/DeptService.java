package com.wavelabs.service;

import java.util.List;
import java.util.Map;

import com.wavelabs.bean.Department;

public interface DeptService {
	public static Department storeDepartment(Department student) {
		return student;	
	};
	
	public List<Map> getDepartment();
	
}
