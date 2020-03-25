package com.techelevator.npgeek.model;

import java.time.LocalDate;

public class Weather {
	
	private int parkId;
	private LocalDate dateToday;
	private int lowTemp;
	private int highTemp;
	private String forecast;
	
	public int getParkId() {
		return parkId;
	}
	public void setParkId(int parkId) {
		this.parkId = parkId;
	}
	public LocalDate getDateToday() {
		return dateToday;
	}
	public void setDateToday(LocalDate dateToday) {
		this.dateToday = dateToday;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
}
