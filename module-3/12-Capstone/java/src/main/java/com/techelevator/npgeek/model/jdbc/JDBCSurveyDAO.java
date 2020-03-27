package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParkSurveys;
import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.dao.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	private List<Survey> parkSurveys = new ArrayList<Survey>();

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	static final String QUERY_ADD_SURVEY = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";

	@Override
	public void addSurvey(Survey survey) {
		jdbcTemplate.update(QUERY_ADD_SURVEY, survey.getParkCode(), survey.getEmailAddress(), survey.getState(),
				survey.getActivityLevel());
	}

	
//	static final String QUERY_GET_ALL_PARKS =
//			"SELECT *, COUNT (survey_result.parkcode) AS surveys " + 
//			"FROM survey_result " + 
//			"LEFT JOIN park ON park.parkcode = survey_result.parkcode " + 
//			"GROUP BY park.parkcode " + 
//			"ORDER BY surveys DESC;";
	
//	@Override
//	public List<Park> getAllParks() {
//		
//		List<Park> parks = new ArrayList<Park>();
//		
//			SqlRowSet results = jdbcTemplate.queryForRowSet(QUERY_GET_ALL_PARKS);
//			while(results.next()) {
//				Park getPark = new Park();
//			}
//			
//		return parks;
//	}


	private ParkSurveys mapRowToSurvey(SqlRowSet results) {
		ParkSurveys parkSurvey = new ParkSurveys();
		parkSurvey.setParkCode(results.getString("parkcode"));
		parkSurvey.setParkName(results.getString("parkname"));
		parkSurvey.setSurveyCount(results.getInt("count"));
		return parkSurvey;
	}

}
