package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.bean.Playerdetails;

@Repository
public interface Player1Repository extends JpaRepository<Playerdetails, Integer> {

}
