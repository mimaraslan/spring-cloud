package com.mimaraslan;

import org.springframework.boot.CommandLineRunner;

public class TollProcessingTask implements CommandLineRunner {
	
	@Override
	public void run(String...args) throws Exception {
		
		// parameters: stationid, 	license plate, 		timestamp
		
		if(null != args){
			System.out.println("parameter length: " + args.length);
			
			if(args.length > 0){
				String stationId = args[1];
				String licensePlate = args[2];
				String timestamp = args[3];
				
				System.out.println("Station ID is " + stationId + ", plate is " + licensePlate + ", timestamp is " + timestamp);
			}
		}
		
		System.out.println("Task completed.");
		
	}
}