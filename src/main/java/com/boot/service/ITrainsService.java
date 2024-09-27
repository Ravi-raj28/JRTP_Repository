package com.boot.service;

import java.util.List;

import com.boot.model.Trains;

public interface ITrainsService {
	
	public List<Trains> getAllTrainsInformation();
	
	public String addTrainDetails(Trains trains);
	
	public Trains getTrainByNo(Integer no);
	
	public String updateTrainsDetails(Trains train);
	
	public String deleteTrain(Integer trainNo);

}
