package com.mimaraslan;

import java.util.Arrays;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;

public class TollProcessingTask implements CommandLineRunner {

	private static final Logger log = LogManager.getLogger(TollProcessingTask.class);
		    
	@Override
	public void run(String...args) throws Exception {
		
		// parameters: stationId, 	license plate, 		timestamp
		/*
		if(null != args){
			System.out.println("parameter length: " + args.length);
			
			if(args.length > 0){
				String stationId = args[1];
				String licensePlate = args[2];
				String timestamp = args[3];
				
				System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
			}
		}
		*/
				
        Optional.ofNullable(args).ifPresent(strings -> Arrays.stream(strings).forEach(param -> log.info("Parameter is {}", param)));
		
		System.out.println("Task completed.");	
	}
}