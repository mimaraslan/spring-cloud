package com.mimaraslan;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TaskController {

	@Autowired
	private TaskProcessor taskProcessor;

	private static final org.apache.logging.log4j.Logger log = 
		    org.apache.logging.log4j.LogManager.getLogger(TaskController.class);
	
    @ResponseBody
    @PostMapping("/tasks")
    public String launchTask(@RequestBody String s) {
        taskProcessor.publishRequest(s);
        log.info("Request made.");
        return "success";
    }
}