package com.techelevator.npgeek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.dao.ParkDAO;
import com.techelevator.npgeek.model.dao.SurveyDAO;

@Controller
public class SurveyController {

	@Autowired
	ParkDAO parkDAO;
	
	@Autowired
	SurveyDAO surveyDAO;
	
	@RequestMapping(value="/survey", method=RequestMethod.GET)
	public String displaySurveyPage(
			ModelMap model
			) 
	{
		if (!model.containsAttribute("survey")) {
			model.addAttribute("survey", new Survey());
		}
		
		List<Park> parks = parkDAO.getAllParks();
		List<String> states = Survey.getStates();
		List<String> buttons = Survey.getButtons();
		
		model.put("parks", parks);
		model.put("states", states);
		model.put("buttons", buttons);
		
		return "survey";
	}
	
	
	@RequestMapping(value="/survey", method=RequestMethod.POST)
	public String submitReviewToFavorites(
			@Valid @ModelAttribute("survey") Survey surveyFormValues,
			BindingResult result,
			RedirectAttributes flash
			)
	{
		if (result.hasErrors()) {
			flash.addFlashAttribute("survey", surveyFormValues);
			flash.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "survey", result);
			return "redirect:/survey";
		}
		
		flash.addFlashAttribute("message", "You have successfully posted your survey.");
		
		surveyDAO.addSurvey(surveyFormValues);
		
		return "redirect:/favorites";
	}
	
	@RequestMapping(value="/favorites", method=RequestMethod.GET)
	public String displayFavoritesPage(
			ModelMap model
			)
	{
		List<Park> parks = parkDAO.getParksBySurveys();
		
		model.put("parks", parks);
		
		return "favorites";
	}
}