package com.techelevator.npgeek.model.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

	static final String QUERY_ADD_SURVEY = "INSERT INTO survey_result (parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?)";

	@Override
	public void addSurvey(Survey survey) {
		jdbcTemplate.update(QUERY_ADD_SURVEY, survey.getParkCode(), survey.getEmailAddress(), survey.getState(),
				survey.getActivityLevel());
	}
}
