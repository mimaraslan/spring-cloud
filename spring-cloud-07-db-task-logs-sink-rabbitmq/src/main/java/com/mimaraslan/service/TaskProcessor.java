package com.mimaraslan.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.cloud.task.launcher.TaskLaunchRequest;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import com.mimaraslan.controller.TaskController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
@EnableBinding(Source.class)
public class TaskProcessor {

	private static final Logger log = LogManager.getLogger(TaskController.class);

	@Autowired
	private Source source;

    public void publishRequest(String payload) {
		//			  maven://	[groupid]	:	 	[artifactid]		 :jar:	[version]
    	String url = "maven://com.mimaraslan:spring-cloud-06-db-task-logs:jar:0.0.1-SNAPSHOT";
 
    	
       //  List<String> input = Arrays.asList(payload.split(","));
        List<String> input = new ArrayList<String>(Arrays.asList(payload.split(",")));
        
        TaskLaunchRequest request = new TaskLaunchRequest(url, input, null, null, null);
        log.info("Created task request.");

        GenericMessage<TaskLaunchRequest> message = new GenericMessage<>(request);
        boolean isSent = source.output().send(message);
        log.info("Message published? {}", isSent);	
    }
}