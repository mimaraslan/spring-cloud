package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class MyRestResource {
	
	// http://localhost:8888
	@GetMapping
	public String SayHello(){
		return "Hi, from Spring Cloud!";
	}

}