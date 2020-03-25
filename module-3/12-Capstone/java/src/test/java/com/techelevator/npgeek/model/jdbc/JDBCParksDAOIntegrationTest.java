package com.techelevator.npgeek.model.jdbc;

import org.junit.Before;
import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCParksDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCParksDAO dao;

	private static final String TEST_PARK_1_PARKCODE = "park1Code";
	private static final String TEST_PARK_1_PARKNAME = "park1Name";
	private static final String TEST_PARK_1_STATE = "park1State";
	private static final long TEST_PARK_1_ACREAGE = 100000;
	private static final long TEST_PARK_1_ELEVATION = 110000;
	private static final float TEST_PARK_1_MILESOFTRAIL = 101000;
	private static final long TEST_PARK_1_CAMPSITES = 100100;
	private static final String TEST_PARK_1_CLIMATE = "park1Climate";
	private static final long TEST_PARK_1_YEARFOUNDED = 100010;
	private static final long TEST_PARK_1_ANNUALVISITORS = 100001;
	private static final String TEST_PARK_1_QUOTE = "park1Quote";
	private static final String TEST_PARK_1_QUOTESOURCE = "park1QuoteSource";
	private static final String TEST_PARK_1_DESCRIPTION = "park1Description";
	private static final long TEST_PARK_1_FEE = 110000;
	private static final long TEST_PARK_1_ANIMALS = 111000;
	
	@Before
	public void setup() {
		String sqlInsertPark = "INSERT INTO park "
				+ "(parkcode, parkname, state, "
				+ "acreage, elevationinfeet, milesoftrail, "
				+ "numberofcampsites, climate, yearfounded, "
				+ "annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, "
				+ "entryfee, numberofanimalspecies) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_1_PARKCODE, TEST_PARK_1_PARKNAME, 
							TEST_PARK_1_STATE, TEST_PARK_1_ACREAGE, TEST_PARK_1_ELEVATION,
							TEST_PARK_1_MILESOFTRAIL, TEST_PARK_1_CAMPSITES, 
							TEST_PARK_1_CLIMATE, TEST_PARK_1_YEARFOUNDED,
							TEST_PARK_1_ANNUALVISITORS, TEST_PARK_1_QUOTE,
							TEST_PARK_1_QUOTESOURCE, TEST_PARK_1_DESCRIPTION,
							TEST_PARK_1_FEE, TEST_PARK_1_ANIMALS);
		dao = new JDBCParksDAO(getDataSource());
	}
}
