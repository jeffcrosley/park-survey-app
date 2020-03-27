package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.ParkSurveys;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.dao.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	private List<ParkSurveys> parkSurveys = new ArrayList<ParkSurveys>();

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	static final String QUERY_ADD_SURVEY = "INSERT INTO survey (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";

	@Override
	public void addSurvey(Survey survey) {
		jdbcTemplate.update(QUERY_ADD_SURVEY, survey.getParkCode(), survey.getEmailAddress(), survey.getState(),
				survey.getActivityLevel());
	}

	
	static final String QUERY_GET_ALL_PARK_SURVEYS = "select park.parkcode, park.parkname, COUNT (survey_result.parkcode)\r\n" + 
			"                  FROM survey_result \r\n" + 
			"                  LEFT JOIN park ON park.parkcode = survey_result.parkcode\r\n" + 
			"                  GROUP BY park.parkcode\r\n" + 
			"                  ORDER BY COUNT DESC;";
	
	@Override
	public List<ParkSurveys> getAllParkSurveys() {

			SqlRowSet results = jdbcTemplate.queryForRowSet(QUERY_GET_ALL_PARK_SURVEYS);
			while(results.next()) {
				parkSurveys.add(mapRowToSurvey(results));
			}
		return parkSurveys;
	}

	private ParkSurveys mapRowToSurvey(SqlRowSet results) {
		ParkSurveys parkSurvey = new ParkSurveys();
		parkSurvey.setParkCode(results.getString("parkcode"));
		parkSurvey.setParkName(results.getString("parkname"));
		parkSurvey.setSurveyCount(results.getInt("count"));
		return parkSurvey;
	}

}
