package com.unimoni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AadherController {

	@Autowired
	CibilService service;

	@RequestMapping("/aadher/cibil/{id}")
	public ResponseEntity getCibilScore(@PathVariable("id") String id) {
		String score = service.getCibilScore(id);
		if (score.equals("-1")) {
			return ResponseEntity.status(404).body("No data found in system");
		}
		return ResponseEntity.status(200).body("Socre of " + id + "is " + score);
	}

}
