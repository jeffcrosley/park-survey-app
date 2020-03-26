package com.techelevator.npgeek.model.dao;

import java.util.List;

import com.techelevator.npgeek.model.Weather;


public interface WeatherDAO{
	
	public List<Weather> getFiveDayForecastByParkCode(String parkCode); 
	
}
