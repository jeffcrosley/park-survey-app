package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class SurveyController {

	@Autowired
	ParkDAO parkDAO;
	
	@RequestMapping(value="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(
				ModelMap model
			) 
	{
		List<Park> parks = parkDAO.getAllParks();
		
		model.put("parks", parks);
		
		return "survey";
	}
	
	
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String submitReviewToFavorites(
				ModelMap model
			)
	{
		return "redirect:/favorites";
	}
	
	@RequestMapping(value="/favorites", method=RequestMethod.GET)
	public String displayFavoritesPage(
				ModelMap model
			)
	{
		return "favorites";
	}
}