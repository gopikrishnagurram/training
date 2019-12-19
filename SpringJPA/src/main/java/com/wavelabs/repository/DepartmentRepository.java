package com.wavelabs.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wavelabs.bean.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	Department save(Department department);
	
	@Query(value = "call test()",nativeQuery = true)
	List<Map> get();
}
