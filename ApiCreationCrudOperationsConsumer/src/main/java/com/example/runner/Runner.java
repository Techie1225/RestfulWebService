//package com.example.runner;
//
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.web.client.RestTemplate;
//
//import com.example.dto.dto;
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//
//public class Runner implements CommandLineRunner{
//
//	@Override
//	public void run(String... args) throws Exception {
//		RestTemplate template= new RestTemplate();
//		//String url="http://localhost:4043/api/tourist/getdata?id=62";
//		
//		/*
//		 * String url="http://localhost:4043/api/tourist/getdataByPathVariables/{id}";
//		 * ResponseEntity<String> response=template.getForEntity(url,String.class,101);
//		 */
//		
//		String url="http://localhost:4043/api/tourist/getdataByPathVariables/{id}";
//		ResponseEntity<String> response=template.exchange(url,HttpMethod.GET,null,String.class,81);
//		
//		
//		
//		ObjectMapper mapper=new ObjectMapper();
//		dto dto1=mapper.readValue(response.getBody(), dto.class);
//		
//		System.out.println(dto1);
//		System.out.println("&&&&&&&&&&");
//		//mapper.writeValue(System.out,dto1);
//		
//		System.out.println("response :: "+response.getBody());
//		System.out.println("response statusCode ::"+response.getStatusCodeValue());
//		System.out.println("response ::"+response.getStatusCode().name());
//		
//		Thread.sleep(5000);
//		System.out.println("====================Runner=========================");
//		
//	}
//
//}
