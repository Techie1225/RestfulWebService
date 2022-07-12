//package com.example.runner;
//
//import java.util.List;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.dto.dto;
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//public class FindAll implements CommandLineRunner {
//
//	@Override
//	public void run(String... args) throws Exception {
//		
//
//		  String url="http://localhost:4043/api/tourist/findall"; 
//		  RestTemplate template=new RestTemplate();
//		
//		  
//		  ResponseEntity<String> response=template.exchange(url, HttpMethod.GET, null, String.class);
//		  
//		 
//		  
//		  ObjectMapper mapper = new ObjectMapper();
//		  List<dto> output = mapper.readValue(response.getBody(), new TypeReference<List<dto>>() {});
//		  mapper.writeValue( System.out,output);
//		  System.out.println(output);
//		  
//		  System.out.println("response :: "+response.getBody());
//		  System.out.println("response :: "+response.getStatusCode());
//		  System.out.println("response :: "+response.getStatusCodeValue());
//		  System.out.println("====================FindAll=========================");
//
//	}
//
//}
