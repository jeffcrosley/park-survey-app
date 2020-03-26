package com.techelevator.npgeek.model.dao;

import java.util.List;

import com.techelevator.npgeek.model.Park;


public interface ParkDAO{

	public List<Park> getAllParks();
	public Park getParkByCode(String parkCode); 
	
	
}
