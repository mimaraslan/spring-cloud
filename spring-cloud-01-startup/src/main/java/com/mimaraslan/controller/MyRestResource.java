package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class MyRestResource {
	
	@GetMapping
	public String SayHello(){
		return "Hi, from Spring Cloud!";
	}

}