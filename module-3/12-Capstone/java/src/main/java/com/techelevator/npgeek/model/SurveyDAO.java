package com.techelevator.npgeek.model;

import java.util.List;


public interface SurveyDAO{

	public void addSurvey(Survey theSurvey);
	public List<Survey> getAllSurveys();
		
}
