package com.luv2code.springdemo.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String showPage() {
		return "main-menu";
	}
	
	@GetMapping("/consuming")
	//public Map<String, Object> Cliente(){
	//public Result Cliente(@RequestBody Student) {
	public Result Cliente() {
		
		Result result = new Result();
		Student student = new Student();
		
		RestTemplate restTemplate=new RestTemplate();
		
		HttpHeaders header=new HttpHeaders();
		
		header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		header.setContentType(MediaType.APPLICATION_JSON);
		
		//HttpEntity<Result> entity = new HttpEntity<Student>(result);//El result al final es cuando viene un parametro
		HttpEntity<Student> entity = new HttpEntity<Student>(student, header);
		
		String endpoint= "http://localhost:8081/students/1";
		
		
		ResponseEntity<Result> response = restTemplate.exchange(endpoint,HttpMethod.GET, entity, Result.class);
		//ResponseEntity<Result> response = restTemplate.getForEntity(endpoint, Result.class);
		
		result=response.getBody();
		
		return result; //(Map<String, Object>) result;
	}

	
	
}
