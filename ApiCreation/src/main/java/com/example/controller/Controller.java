package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Exception.CustomException;
import com.example.dto.dto;
import com.example.service.ServiceClass;


@RestController
@RequestMapping("/tourist")
public class Controller {

	@Autowired
	ServiceClass serv;

	@GetMapping("/findall")
	public ResponseEntity<List<dto>> requestHand() {
		List<dto> data = serv.fetchAll();
		
		return new ResponseEntity<List<dto>>(data, HttpStatus.OK);
	}
	
	// Using StringQuery
	@GetMapping("/getdata")
	public ResponseEntity<dto> requestHand(@RequestParam Integer id,
			@RequestParam(required = false) String name) {
		dto data = serv.fetchById(id);
		System.out.println(name);
		return new ResponseEntity<dto>(data, HttpStatus.OK);
	}

	// Using PathVariables
	@GetMapping("/getdataByPathVariables/{id}")
	public ResponseEntity<dto> requestHandler(@PathVariable Integer id,
			@RequestParam(required = false) String name) {
		dto data = serv.fetchById(id);
		System.out.println(name);
		return new ResponseEntity<dto>(data, HttpStatus.OK);
	}

	@PostMapping("/complexData")
	public ResponseEntity<dto> postRequest(@RequestBody dto data) {
		System.out.println(data.toString());
		String successMsg = serv.insertData(data);
		return new ResponseEntity<dto>(data, HttpStatus.CREATED);
	}

	@PatchMapping("/patchReq/{id}/{hike}")
	public ResponseEntity<String> patchRequest(@PathVariable(name = "id") Integer Sid, @PathVariable Float hike) {
		String successMsg = serv.updatetheRec(Sid, hike);

		return new ResponseEntity<String>(successMsg, HttpStatus.OK);
	}

	@DeleteMapping("/deletereq/{id}")
	public ResponseEntity<String> deleteRequest(@PathVariable Integer id) throws CustomException{
		try {
			Boolean successMsg = serv.deleteTheRecord(id);
			//if (successMsg) {
				return new ResponseEntity<String>("Record with id has been deleted", HttpStatus.OK);
			//s} 
			//else {
			//	return new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);
			//}

		}

		catch (Exception E) {
			throw new CustomException("Internal Issue, Please check your connection");
		}
	}

	@PutMapping("/patchReq")
	public ResponseEntity<String> putRequest(@RequestBody dto dto) {
		String successMsg = serv.updatetheRecWithPut(dto);

		return new ResponseEntity<String>(successMsg, HttpStatus.OK);
	}

}
