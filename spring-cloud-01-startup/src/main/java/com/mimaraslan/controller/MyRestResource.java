package com.mimaraslan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyRestResource {
	
	@RequestMapping(value="/message")
	public String SayHello(){
		return "Hi, from Spring Cloud!";
	}

}