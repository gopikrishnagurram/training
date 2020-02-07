package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SampleController {

	@RequestMapping("/hello")
	@PreAuthorize("hasAuthority('write')")
	public ResponseEntity<String> hello() {
		return ResponseEntity.status(200).body("Hello");
	}

}
