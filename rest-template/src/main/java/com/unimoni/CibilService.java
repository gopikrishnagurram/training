package com.unimoni;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Component
public class CibilService {

	@Autowired
	RestTemplate restTemplate;

	@Value("${cibil.url}")
	private String cibilurl;

	public String getCibilScore(String adherNum) {
		String url = cibilurl + adherNum;
		ResponseEntity<CibilResponse> response = restTemplate.getForEntity(url, CibilResponse.class);
		CibilResponse cResponse = response.getBody();
		return cResponse.getScore();
	}

}
