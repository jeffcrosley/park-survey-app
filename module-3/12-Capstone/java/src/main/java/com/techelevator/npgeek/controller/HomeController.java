package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String displayHomepage(
				ModelMap model
			) 
	{
		List<Park> parks = parkDAO.getAllParks();
		
		model.put("parks", parks);
		
		return "home";
	}
	
	@RequestMapping(value="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetails(
				HttpServletRequest request,
				ModelMap model
			)
	{
		String parkCode = request.getParameter("parkCode");
		
		Park park = parkDAO.getParkByCode(parkCode);
		
		model.put("park", park);
		
		return "parkDetail";
	}
}