package com.techelevator.npgeek.model.jdbc;

import org.junit.Before;
import org.junit.Test;

public class JDBCSurveysDAOIntegrationTest extends DAOIntegrationTest {

	private JDBCSurveyDAO dao;
	
	@Before
	public void setup() {
		setupDatabase();
		dao = new JDBCSurveyDAO(getDataSource());
	}
	
	@Test
	public void get_all_surveys() {
		
	}
	
	@Test
	public void add_survey() {
		
	}
}
