package com.techelevator.npgeek.model;


public class Weather {
	
	private String parkCode;
	private int fiveDayForecastValue;
	private double farenheitLow;
	private double fahrenheitHigh;
	private double celsiusLow;
	private double celsiusHigh;
	private String forecast;
	
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getFiveDayForecastValue() {
		return fiveDayForecastValue;
	}
	public void setFiveDayForecastValue(int fiveDayForecastValue) {
		this.fiveDayForecastValue = fiveDayForecastValue;
	}
	public double getFarenheitLow() {
		return farenheitLow;
	}
	public void setFarenheitLow(double farenheitLow) {
		this.farenheitLow = farenheitLow;
	}
	public double getFahrenheitHigh() {
		return fahrenheitHigh;
	}
	public void setFahrenheitHigh(double fahrenheitHigh) {
		this.fahrenheitHigh = fahrenheitHigh;
	}
	public double getCelsiusLow() {
		return celsiusLow;
	}
	public void setCelsiusLow(double celsiusLow) {
		this.celsiusLow = celsiusLow;
	}
	public double getCelsiusHigh() {
		return celsiusHigh;
	}
	public void setCelsiusHigh(double celsiusHigh) {
		this.celsiusHigh = celsiusHigh;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	
}
