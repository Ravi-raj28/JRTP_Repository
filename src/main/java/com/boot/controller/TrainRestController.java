package com.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Trains;
import com.boot.service.TrainsService;

@RestController
@RequestMapping("/train")
public class TrainRestController {
	
	@Autowired
	private TrainsService trainsService;
	
	//Get all trains records
	@GetMapping("/findAll")
	public ResponseEntity<List<Trains>> fetchAllTrains() {
		
		List<Trains> trainsList=trainsService.getAllTrainsInformation();
		
		  	return new ResponseEntity<List<Trains>>(trainsList,HttpStatus.FOUND);
		  	 
	} 	
				
			
	//Add train details
	@PostMapping("/insert/newtrain") 
	public ResponseEntity<String> addTrainDetails(@RequestBody Trains trains){
		
		String response=trainsService.addTrainDetails(trains);
		
		return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}	  	
	
	
	//Get a single Train
	@GetMapping("/singletrain/{trainNo}")
	public Trains fetchSingleTrains(@PathVariable Integer trainNo) {
		
		Trains trains=trainsService.getTrainByNo(trainNo);
		
		return trains;
	}
	//Update train
	
	@PutMapping("/update")
	public ResponseEntity<String> modifyTrainDetails(@RequestBody Trains trains){
		
		String response=trainsService.updateTrainsDetails(trains);
		
		return new ResponseEntity<String>(response,HttpStatus.ACCEPTED);
		
	}
	
	
	
	//Delete train
	@DeleteMapping("/delete/{trainNo}")
	public ResponseEntity<String> deleteTrain(@PathVariable Integer trainNo){
		
		
		
		System.out.println("Enetered in Producer deleteTrain()");
		
		System.out.println("Train No "+trainNo);
		
		String deleteTrainResponse=trainsService.deleteTrain(trainNo);
		
		System.out.println("Returning to Controller");
		
		return new ResponseEntity<String>(deleteTrainResponse,HttpStatus.OK);
	}
		
		
		
		
		
	

}
