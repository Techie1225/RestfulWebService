//package com.example.runner;
//
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.dto.dto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//public class RunnerPost implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//		  String url="http://localhost:4043/api/tourist/complexData"; 
//		  RestTemplate template=new RestTemplate();
//		  
//		  dto dto=new dto(300,"Greeshma",45678.0f,'Y',1234567890l); 
//		  HttpHeaders head=new HttpHeaders(); 
//		  head.setContentType(MediaType.APPLICATION_JSON);
//		  HttpEntity<dto> entity1=new HttpEntity<dto>(dto,head);
//		  
//		  ResponseEntity<dto>response = template.postForEntity(url, entity1,
//		  dto.class);
//		  
//		  ObjectMapper mapper= new ObjectMapper(); 
//		  //mapper.readValues(response,dto.class);
//		  
//		  System.out.println();
//		 
//	}
//
//}
