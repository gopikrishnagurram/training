package com.example.demo.step;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Player1;
import com.example.demo.repository.Player1Repository;

@Component
public class FlatFileWriter implements ItemWriter<Player1> {

	@Autowired
	Player1Repository playerRepository;

	@Override
	public void write(List<? extends Player1> items) throws Exception {
		playerRepository.saveAll(items);
	}
	
}
