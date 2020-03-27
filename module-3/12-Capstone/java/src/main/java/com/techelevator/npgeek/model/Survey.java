package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private String surveyId;

	@NotBlank(message="Favorite Park is Required")
	private String parkCode;
	
	@NotBlank(message="Email is Required")
	@Email(message="Email must be a valid email address")
	private String emailAddress;
	
	@NotBlank(message="State is Required")
	private String state;
	
	@NotBlank(message="Activity Level is Required")
	private String activityLevel;
	
	public String getSurveyId() {
		return surveyId;
	}

	public void setSurveyId(String surveyId) {
		this.surveyId = surveyId;
	}
	
	public String getParkCode() {
		return parkCode;
	}
	
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getActivityLevel() {
		return activityLevel;
	}
	
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
	public static List<String> getStates() {
		List<String> states = new ArrayList<String>();
		
		states.add("AL");
		states.add("AK");
		states.add("AZ");
		states.add("AR");
		states.add("CA");
		states.add("CO");
		states.add("CT");
		states.add("DE");
		states.add("FL");
		states.add("GA");
		states.add("HI");
		states.add("ID");
		states.add("IL");
		states.add("IN");
		states.add("IA");
		states.add("KS");
		states.add("KY");
		states.add("LA");
		states.add("ME");
		states.add("MD");
		states.add("MA");
		states.add("MI");
		states.add("MN");
		states.add("MS");
		states.add("MO");
		states.add("MT");
		states.add("NE");
		states.add("NV");
		states.add("NH");
		states.add("NJ");
		states.add("NM");
		states.add("NY");
		states.add("NC");
		states.add("ND");
		states.add("OH");
		states.add("OK");
		states.add("OR");
		states.add("PA");
		states.add("RI");
		states.add("SC");
		states.add("SD");
		states.add("TN");
		states.add("TX");
		states.add("UT");
		states.add("VT");
		states.add("VA");
		states.add("WA");
		states.add("WV");
		states.add("WI");
		states.add("WY");
		
		return states;
	}
	
	public static List<String> getButtons() {
		List<String> buttons = new ArrayList<String>();
				
		buttons.add("1");
		buttons.add("2");
		buttons.add("3");
		buttons.add("4");
		buttons.add("5");
		
		return buttons;
	}
}
