package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.Weather;
import com.techelevator.npgeek.model.dao.ParkDAO;
import com.techelevator.npgeek.model.dao.WeatherDAO;

@Controller
public class ParkDetailController {

	@Autowired
	ParkDAO parkDAO;
	
	@Autowired
	WeatherDAO weatherDAO;
	
	
	@RequestMapping(value="/parkDetail", method=RequestMethod.GET)
	public String displayParkDetail(
				HttpServletRequest request,
				HttpSession session,
				ModelMap model
			) 
	{
		String currentParkCode = request.getParameter("parkCode");
		Park park = parkDAO.getParkByCode(currentParkCode);
		model.put("park", park);
		
		List<Weather> fiveDayForecast =  weatherDAO.getFiveDayForecastByParkCode(currentParkCode);
		model.put("fiveDayForecast", fiveDayForecast);
		
		return "parkDetail";
	}
}