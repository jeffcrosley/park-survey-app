package com.techelevator.npgeek.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkDAO;

@Controller
public class ParkDetailController {

	@Autowired
	ParkDAO parkDAO;
	
	@RequestMapping(value="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(
				HttpServletRequest request,
				ModelMap model
			) 
	{
		String currentParkCode = request.getParameter("parkCode");
		Park park = parkDAO.getParkByCode(currentParkCode);
		
		model.put("park", park);
		
		return "parkDetail";
	}
}