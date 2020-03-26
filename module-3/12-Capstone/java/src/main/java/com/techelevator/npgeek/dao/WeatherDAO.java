package com.techelevator.npgeek.dao;

import com.techelevator.npgeek.model.Weather;

import java.util.List;


public interface WeatherDAO{
	
	public List<Weather> getFiveDayForecastByParkCode(String parkCode); 
	
}
