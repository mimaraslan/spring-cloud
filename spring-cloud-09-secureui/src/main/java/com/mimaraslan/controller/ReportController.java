package com.mimaraslan.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mimaraslan.model.TollUsage;

@Controller
@EnableOAuth2Sso
public class ReportController extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private OAuth2ClientContext clientContext;
	
	@Autowired
    private OAuth2RestTemplate oauth2RestTemplate;
	
// http://localhost:8080
	@RequestMapping("/")
	public String loadHome(){
		return "home";
	}
	
	// http://localhost:8080/reports
	@RequestMapping("/reports")
	public String loadReports(Model model){
		
		OAuth2AccessToken t = clientContext.getAccessToken();
		System.out.println("Token: " + t.getValue());
		
		TollUsage instance1 = new TollUsage("101", "station1", "AAA", "2021-01-21T01:11:31");
		TollUsage instance2 = new TollUsage("102", "station2", "BBB", "2022-02-22T02:12:32");
		TollUsage instance3 = new TollUsage("103", "station3", "CCC", "2023-03-23T03:13:33");
		
		ArrayList<TollUsage> tolls = new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		
		model.addAttribute("tolls", tolls);	
		return "reports";
	}
	
	
	// http://localhost:8080/reports2
		@RequestMapping("/reports2")
		public String loadReports2(Model model){
			
			OAuth2AccessToken t = clientContext.getAccessToken();
			System.out.println("Token: " + t.getValue());
					
			// TODO - DO NOT WORK
			ResponseEntity<ArrayList<TollUsage>> tolls = 
					oauth2RestTemplate.exchange("http://localhost:9001/services/tolldata", 
							HttpMethod.GET, null, new ParameterizedTypeReference<ArrayList<TollUsage>>(){});
			model.addAttribute("tolls", tolls.getBody());	
			
			return "reports";
		}
		
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/", "/login**")
			.permitAll()
		.anyRequest()
			.authenticated();
	}
}