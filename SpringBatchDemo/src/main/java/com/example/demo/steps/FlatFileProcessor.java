package com.example.demo.steps;

import java.util.HashMap;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.demo.bean.Playerdetails;

@Component
public class FlatFileProcessor implements ItemProcessor<Playerdetails, Playerdetails> {
	HashMap<String,String> roleMap;
	{
		roleMap = new HashMap<String,String>();
		
		roleMap.put("1","batsman");
		roleMap.put("2","bowler");
		roleMap.put("3","All-Rounder");
	}
	
	@Override
	public Playerdetails process(Playerdetails player) throws Exception {
		player.setRole(roleMap.get(player.getRole()));
		return player;
	}
}
