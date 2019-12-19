package com.wavelabs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wavelabs.bean.Panidentity;

public interface PanRepository extends JpaRepository<Panidentity, Integer> {
	Panidentity save(Panidentity panidentity);
	
	Panidentity findByPanno(String panno);
}
