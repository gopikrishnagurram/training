package com.example.demo.steps;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Playerdetails;
import com.example.demo.repository.Player1Repository;

@Component
public class FlatFileWriter implements ItemWriter<Playerdetails> {

	@Autowired
	Player1Repository playerRepository;

	@Override
	public void write(List<? extends Playerdetails> items) throws Exception {
		
		playerRepository.saveAll(items);
		
	}
	
}
