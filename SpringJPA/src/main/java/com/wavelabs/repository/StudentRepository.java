package com.wavelabs.repository;

import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.wavelabs.bean.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student save(Student student);
	Student findByRollno(int rollNo);

	@Query(value="select name,roll_no from student where roll_no = :roll_no",nativeQuery = true)
	Map getStudentByRollno(@Param("roll_no") int rollNo);
}
