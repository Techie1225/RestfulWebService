package com.example.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.dto.dto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
public class Restcontroller {
	
	@GetMapping("/")
	public String homePage() {
		System.out.println("-----------");
		return "home";
	}
	
	@GetMapping("/Student_records")
	public String getTheRecords(Map<String,Object> map) throws Exception{
		String url="http://localhost:4043/api/tourist/findall"; 
		  RestTemplate template=new RestTemplate();  
		  ResponseEntity<String> response=template.exchange(url, HttpMethod.GET, null, String.class);
		  
		  ObjectMapper mapper = new ObjectMapper();
		  List<dto> StudentList = mapper.readValue(response.getBody(), new TypeReference<List<dto>>() {});
		  System.out.println(StudentList);
		  System.out.println();
		  map.put("StudentList",StudentList);
		  return "StudentTable";
	}
	
	@GetMapping("/Student_Enrollment")
	public String AddStudent(@ModelAttribute("StudentEntity")dto dto) {
		return "Registration";
	}
	
	@PostMapping("/Student_Enrollment")
	public String SubmitStudent(RedirectAttributes attrs, @ModelAttribute("StudentEntity")dto dto, Map<String,Integer> map) {
		System.out.println("Restcontroller.SubmitStudent()");
		System.out.println(dto);
		String url="http://localhost:4043/api/tourist/complexData"; 
		  RestTemplate template=new RestTemplate();
		  HttpHeaders head=new HttpHeaders(); 
		  head.setContentType(MediaType.APPLICATION_JSON);
		  HttpEntity<dto> entity1=new HttpEntity<dto>(dto,head);
		  
		 // ResponseEntity<dto>response = template.postForEntity(url, entity1, dto.class);
		  
		  ResponseEntity<dto>response = template.exchange(url, HttpMethod.POST, entity1, dto.class);
		 
		  //ObjectMapper mapper= new ObjectMapper(); 
		  attrs.addFlashAttribute("id", response.getBody().getId());
		 
		return "redirect:Student_records";
	}
	
	@GetMapping("/delete")
	public String DeleteStudent(@RequestParam("id") Integer UniqueID) {
		System.out.println("Restcontroller.DeleteStudent()");
		
		String url="http://localhost:4043/api/tourist/deletereq/{UniqueID}"; 
		  RestTemplate template=new RestTemplate();
			/*
			 * HttpHeaders head=new HttpHeaders();
			 * head.setContentType(MediaType.TEXT_PLAIN); HttpEntity<String> entity1=new
			 * HttpEntity<String>(UniqueID,head);
			 */
		  
		 // ResponseEntity<dto>response = template.postForEntity(url, entity1, dto.class);
		  
		  ResponseEntity<String>response = template.exchange(url, HttpMethod.DELETE, null, String.class,UniqueID);
		 
		  System.out.println("response :: "+response.getBody());
		 // ObjectMapper mapper= new ObjectMapper(); 
		 
		 
		return "redirect:Student_records";
	}
	
	@GetMapping("/edit")
	public String getElementById(RedirectAttributes attribute, @RequestParam Integer id) throws Exception{
		System.out.println(id);
	
		String url="http://localhost:4043/api/tourist/getdata?id="+id; 
		  RestTemplate template=new RestTemplate();  
		  System.out.println(url);
		  ResponseEntity<dto> response=template.exchange(url, HttpMethod.GET, null, dto.class);
		  attribute.addFlashAttribute("StudentEntity",response.getBody() );
		  System.out.println("res  "+response.getBody());
		  return "redirect:Student_Enrollment";
	}

}
