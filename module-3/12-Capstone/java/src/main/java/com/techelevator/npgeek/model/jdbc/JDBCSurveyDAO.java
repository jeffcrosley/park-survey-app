package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Survey;
import com.techelevator.npgeek.model.dao.SurveyDAO;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	static final String QUERY_ADD_SURVEY = "INSERT INTO survey (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";
	@Override
	public void addSurvey(Survey survey) {
		jdbcTemplate.update(QUERY_ADD_SURVEY, survey.getParkCode(), survey.getEmailAddress(), survey.getState(), survey.getActivityLevel());
	}

	
	static final String QUERY_GET_ALL_SURVEYS = "SELECT * FROM survey";
	@Override
	public List<Survey> getAllSurveys() {
		String sqlFindAllSurveyResults = "select * from survey_result order by parkcode";
			List<Survey> surveys = new ArrayList<Survey>();
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllSurveyResults);
			while(results.next()) {
				surveys.add(mapRowToSurvey(results));
			}
		return surveys;
	}
	
	private Survey mapRowToSurvey(SqlRowSet results) {
		Survey theSurvey;
		theSurvey = new Survey();
		theSurvey.setSurveyId(results.getInt("surveyid"));
		theSurvey.setParkCode(results.getString("parkcode"));
		theSurvey.setEmailAddress(results.getString("emailaddress"));
		theSurvey.setState(results.getString("state"));
		theSurvey.setActivityLevel(results.getString("activitylevel"));
		return theSurvey;
	}
	
}
