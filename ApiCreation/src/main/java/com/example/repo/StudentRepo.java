package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dto.dto;


public interface StudentRepo extends JpaRepository<dto, Integer> {

}
