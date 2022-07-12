package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dto.dto;
import com.example.repo.StudentRepo;

@Service
public class ServiceClass {

	@Autowired
	StudentRepo studentRepo;

	
	public String insertData(dto dto) {
		System.out.println(dto.getName());
		Integer id=studentRepo.save(dto).getId();
		return "Record inderted successfully with the id::"+id.toString();		
	}


	public dto fetchById(Integer id) {
	
		return studentRepo.findById(id).get();
	}


	public String updatetheRec(Integer id, Float hike) {
		Optional<dto> opt=studentRepo.findById(id);
		dto data=opt.get();
		data.setSalary(data.getSalary()+(data.getSalary()*hike/100));
		studentRepo.save(data);
		return "Record updated successfully";
	}


	public Boolean deleteTheRecord(Integer id) {
		Optional<dto> opt=studentRepo.findById(id);
		if(opt.isPresent()) {
			studentRepo.delete(opt.get());
			return true;
		}
		else {
			return false;
		}
		
	}


	public String updatetheRecWithPut(dto dto ) {
		Optional<dto> opt = studentRepo.findById(dto.getId());
		if(opt.isPresent()) {
			studentRepo.save(dto);	
			return "Record Updated with PUT successfully";
		}
		else {
			return "Record Not Found";
		}
		
		
	}


	public List<dto> fetchAll() {
		List<dto> Allrecords=studentRepo.findAll();
		return Allrecords;
	}
}
