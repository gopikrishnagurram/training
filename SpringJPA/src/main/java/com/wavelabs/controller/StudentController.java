package com.wavelabs.controller;

import java.util.List;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wavelabs.bean.Panidentity;
import com.wavelabs.bean.Student;
import com.wavelabs.bean.Student2;
import com.wavelabs.service.DeptService;
import com.wavelabs.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	@Qualifier("studentServiceImpl")
	StudentService studentServiceImpl;

	@Autowired
	@Qualifier("departmentServiceImpl")
	DeptService departmentServiceImpl;

	//FOR ONE TO ONE RELATIONSHIP
	@PostMapping("/student")

	public ResponseEntity<Student> student(@RequestBody Student student) {
		Student student1 = studentServiceImpl.storeStudent(student);
		return ResponseEntity.status(200).body(student1);
	}

	//FOR ONE TO ONE RELATIONSHIP
	@PostMapping("/pan")
	public ResponseEntity<Panidentity> pan(@RequestBody Panidentity pan) {
		Panidentity panidentity = studentServiceImpl.storePan(pan);
		return ResponseEntity.status(200).body(panidentity);
	}

	@GetMapping("/students/{rollNo}")

	public ResponseEntity<Student2> student(@PathVariable int rollNo) {
		Map studentMap = studentServiceImpl.getStudent(rollNo);

		Student2 student = new ObjectMapper().convertValue(studentMap, Student2.class);

		return ResponseEntity.status(200).body(student);
	}

	@GetMapping("/dept")
	public ResponseEntity<List<Map>> getDept() {
		List<Map> department = departmentServiceImpl.getDepartment();
		return ResponseEntity.status(200).body(department);
	}

	//FOR ONE TO ONE RELATIONSHIP
	@GetMapping("/std/{id}")
	public ResponseEntity<Student> getStd(@PathVariable int id) {
		Student stud = studentServiceImpl.getStud(id);
		// System.out.println();
		return ResponseEntity.status(200).body(stud);

	}
	
	//FOR ONE TO ONE RELATIONSHIP
	@GetMapping("/pan/{panno}")
	public ResponseEntity<Panidentity> getPan(@PathVariable String panno) {
		Panidentity pandetails = studentServiceImpl.getPan(panno);
		// System.out.println();
		return ResponseEntity.status(200).body(pandetails);

	}
}
