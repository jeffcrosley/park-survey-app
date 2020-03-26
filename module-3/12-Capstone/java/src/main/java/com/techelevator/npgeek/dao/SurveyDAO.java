package com.techelevator.npgeek.dao;

import java.util.List;

import com.techelevator.npgeek.model.Survey;


public interface SurveyDAO{

	public void addSurvey(Survey theSurvey);
	public List<Survey> getAllSurveys();
		
}
