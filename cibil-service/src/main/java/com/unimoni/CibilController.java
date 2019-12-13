package com.unimoni;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CibilController {

	private static Map<String, String> scoresMap = new HashMap<>();

	static {
		scoresMap.put("A", "700");
		scoresMap.put("B", "800");
		scoresMap.put("C", "400");
	}

	@GetMapping("/cibil/{id}")
	public ResponseEntity<Map> getCibilScore(@PathVariable("id") String aadher) {
		Map<String, String> map = new HashMap<>();
		String score = scoresMap.get(aadher);
		if (score != null) {
			map.put("score", score);
		} else {
			map.put("score", "-1");
		}
		return ResponseEntity.status(200).body(map);
	}

	@PostMapping("/cibil")
	public ResponseEntity<Cibil> postCibil(@RequestBody Cibil cibil) {
		scoresMap.put(cibil.getId(), cibil.getScore());
		String name = null;
		name.length();
		return ResponseEntity.status(201).body(cibil);
	}
}
