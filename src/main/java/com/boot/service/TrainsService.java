package com.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.model.Trains;
import com.boot.repository.TrainRepository;

@Service
public class TrainsService implements ITrainsService {
	
	@Autowired
	private TrainRepository repo;

	@Override
	public List<Trains> getAllTrainsInformation() {
		
		List<Trains> list=repo.findAll();
		
		return list;
	}

	@Override
	public String addTrainDetails(Trains trains) {
		
		repo.save(trains);
		
		
		return "Train details have been added with trainn no "+trains.getTrainNo();
	}

	@Override
	public Trains getTrainByNo(Integer no) {
		
	 Trains trains=repo.findById(no).get();
	 
		
		
		return trains;
	}

	@Override
	public String updateTrainsDetails(Trains train) {

     repo.save(train);
		
		return train.getTrainNo()+" Train has been updated";
	}

	@Override
	public String deleteTrain(Integer trainNo) {
		
		Trains trains=repo.findById(trainNo).get();
		
		System.out.println(trains.toString());
		
		if(trains!=null) {
			
			repo.deleteById(trainNo);
			
			System.out.println("Train found");
			
			return trainNo+" Train has been deleted ";
		}
		
		
		else {
			return "Train  not found with train no "+trainNo;
			
		}
		
		
	}

}
