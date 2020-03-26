package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.dao.ParkDAO;

@Controller
public class HomeController {

	@Autowired
	ParkDAO parkDAO;
	
	@RequestMapping(value= {"/", "/home"}, method=RequestMethod.GET)
	public String displayHomepage(
				ModelMap model
			) 
	{
		List<Park> parks = parkDAO.getAllParks();
		
		model.put("parks", parks);
		
		return "home";
	}
}