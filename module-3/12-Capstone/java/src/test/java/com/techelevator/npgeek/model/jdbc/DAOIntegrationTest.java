package com.techelevator.npgeek.model.jdbc;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

import com.techelevator.npgeek.model.Park;

public abstract class DAOIntegrationTest {

	/* JEFF: THIS SPECIFIES A DUMMY DATA FOR TESTING */
	protected static final String TEST_PARK_1_PARKCODE = "park1Code";
	protected static final String TEST_PARK_1_PARKNAME = "park1Name";
	protected static final String TEST_PARK_1_STATE = "park1State";
	protected static final long TEST_PARK_1_ACREAGE = 100000;
	protected static final long TEST_PARK_1_ELEVATION = 110000;
	protected static final BigDecimal TEST_PARK_1_MILESOFTRAIL = new BigDecimal("101000.0");
	protected static final long TEST_PARK_1_CAMPSITES = 100100;
	protected static final String TEST_PARK_1_CLIMATE = "park1Climate";
	protected static final long TEST_PARK_1_YEARFOUNDED = 100010;
	protected static final long TEST_PARK_1_ANNUALVISITORS = 100001;
	protected static final String TEST_PARK_1_QUOTE = "park1Quote";
	protected static final String TEST_PARK_1_QUOTESOURCE = "park1QuoteSource";
	protected static final String TEST_PARK_1_DESCRIPTION = "park1Description";
	protected static final long TEST_PARK_1_FEE = 110000;
	protected static final long TEST_PARK_1_ANIMALS = 111000;
	
	protected static final String TEST_PARK_2_PARKCODE = "park2Code";
	protected static final String TEST_PARK_2_PARKNAME = "park2Name";
	protected static final String TEST_PARK_2_STATE = "park2State";
	protected static final long TEST_PARK_2_ACREAGE = 200000;
	protected static final long TEST_PARK_2_ELEVATION = 220000;
	protected static final BigDecimal TEST_PARK_2_MILESOFTRAIL = new BigDecimal("202000.0");
	protected static final long TEST_PARK_2_CAMPSITES = 200200;
	protected static final String TEST_PARK_2_CLIMATE = "park2Climate";
	protected static final long TEST_PARK_2_YEARFOUNDED = 200020;
	protected static final long TEST_PARK_2_ANNUALVISITORS = 200002;
	protected static final String TEST_PARK_2_QUOTE = "park2Quote";
	protected static final String TEST_PARK_2_QUOTESOURCE = "park2QuoteSource";
	protected static final String TEST_PARK_2_DESCRIPTION = "park2Description";
	protected static final long TEST_PARK_2_FEE = 220000;
	protected static final long TEST_PARK_2_ANIMALS = 222000;
	
	
	protected static final String TEST_PARK_3_PARKCODE = "park3Code";
	protected static final String TEST_PARK_3_PARKNAME = "park3Name";
	protected static final String TEST_PARK_3_STATE = "park3State";
	protected static final long TEST_PARK_3_ACREAGE = 300000;
	protected static final long TEST_PARK_3_ELEVATION = 330000;
	protected static final BigDecimal TEST_PARK_3_MILESOFTRAIL = new BigDecimal("303000.0");
	protected static final long TEST_PARK_3_CAMPSITES = 300300;
	protected static final String TEST_PARK_3_CLIMATE = "park3Climate";
	protected static final long TEST_PARK_3_YEARFOUNDED = 300030;
	protected static final long TEST_PARK_3_ANNUALVISITORS = 300003;
	protected static final String TEST_PARK_3_QUOTE = "park3Quote";
	protected static final String TEST_PARK_3_QUOTESOURCE = "park3QuoteSource";
	protected static final String TEST_PARK_3_DESCRIPTION = "park3Description";
	protected static final long TEST_PARK_3_FEE = 330000;
	protected static final long TEST_PARK_3_ANIMALS = 333000;
	
	protected static final String TEST_SURVEY_1_ID = "1000000";
	protected static final String TEST_SURVEY_1_CODE = "1100000";
	protected static final String TEST_SURVEY_1_EMAIL = "1@1.com";
	protected static final String TEST_SURVEY_1_STATE = "11";
	protected static final String TEST_SURVEY_1_ACTIVITY_LEVEL = "1";
	
	protected static final String TEST_SURVEY_2_ID = "2000000";
	protected static final String TEST_SURVEY_2_CODE = "2200000";
	protected static final String TEST_SURVEY_2_EMAIL = "2@2.com";
	protected static final String TEST_SURVEY_2_STATE = "22";
	protected static final String TEST_SURVEY_2_ACTIVITY_LEVEL = "2";
	
	protected static final String TEST_SURVEY_3_ID = "3000000";
	protected static final String TEST_SURVEY_3_CODE = "3300000";
	protected static final String TEST_SURVEY_3_EMAIL = "3@3.com";
	protected static final String TEST_SURVEY_3_STATE = "33";
	protected static final String TEST_SURVEY_3_ACTIVITY_LEVEL = "3";
	
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/npgeek");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		/* The following line disables autocommit for connections
		 * returned by this DataSource. This allows us to rollback
		 * any changes after each test */
		dataSource.setAutoCommit(false);
	}

	/* After all tests have finished running, this method will close the DataSource */
	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	protected DataSource getDataSource() {
		return dataSource;
	}
	
	/* JEFF: THIS SETS UP THE DUMMY DATA IN THE TEST SUITES*/
	protected void setupDatabase() {
		String sqlInsertPark = "INSERT INTO park "
				+ "(parkcode, parkname, state, "
				+ "acreage, elevationinfeet, milesoftrail, "
				+ "numberofcampsites, climate, yearfounded, "
				+ "annualvisitorcount, inspirationalquote, "
				+ "inspirationalquotesource, parkdescription, "
				+ "entryfee, numberofanimalspecies) VALUES "
				+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		String sqlInsertSurvey = "INSERT INTO survey_result "
				+ "(surveyId, parkCode, emailAddress, state, activityLevel)"
				+ "VALUES (?, ?, ?, ?, ?)";
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_1_PARKCODE, TEST_PARK_1_PARKNAME, 
				TEST_PARK_1_STATE, TEST_PARK_1_ACREAGE, TEST_PARK_1_ELEVATION,
				TEST_PARK_1_MILESOFTRAIL, TEST_PARK_1_CAMPSITES, 
				TEST_PARK_1_CLIMATE, TEST_PARK_1_YEARFOUNDED,
				TEST_PARK_1_ANNUALVISITORS, TEST_PARK_1_QUOTE,
				TEST_PARK_1_QUOTESOURCE, TEST_PARK_1_DESCRIPTION,
				TEST_PARK_1_FEE, TEST_PARK_1_ANIMALS);
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_2_PARKCODE, TEST_PARK_2_PARKNAME, 
				TEST_PARK_2_STATE, TEST_PARK_2_ACREAGE, TEST_PARK_2_ELEVATION,
				TEST_PARK_2_MILESOFTRAIL, TEST_PARK_2_CAMPSITES, 
				TEST_PARK_2_CLIMATE, TEST_PARK_2_YEARFOUNDED,
				TEST_PARK_2_ANNUALVISITORS, TEST_PARK_2_QUOTE,
				TEST_PARK_2_QUOTESOURCE, TEST_PARK_2_DESCRIPTION,
				TEST_PARK_2_FEE, TEST_PARK_2_ANIMALS);
		jdbcTemplate.update(sqlInsertPark, TEST_PARK_3_PARKCODE, TEST_PARK_3_PARKNAME, 
				TEST_PARK_3_STATE, TEST_PARK_3_ACREAGE, TEST_PARK_3_ELEVATION,
				TEST_PARK_3_MILESOFTRAIL, TEST_PARK_3_CAMPSITES, 
				TEST_PARK_3_CLIMATE, TEST_PARK_3_YEARFOUNDED,
				TEST_PARK_3_ANNUALVISITORS, TEST_PARK_3_QUOTE,
				TEST_PARK_3_QUOTESOURCE, TEST_PARK_3_DESCRIPTION,
				TEST_PARK_3_FEE, TEST_PARK_3_ANIMALS);
		jdbcTemplate.update(sqlInsertSurvey, TEST_SURVEY_1_ID, TEST_SURVEY_1_CODE, 
				TEST_SURVEY_1_EMAIL, TEST_SURVEY_1_STATE, TEST_SURVEY_1_ACTIVITY_LEVEL);
		jdbcTemplate.update(sqlInsertSurvey, TEST_SURVEY_2_ID, TEST_SURVEY_2_CODE, 
				TEST_SURVEY_2_EMAIL, TEST_SURVEY_2_STATE, TEST_SURVEY_2_ACTIVITY_LEVEL);
		jdbcTemplate.update(sqlInsertSurvey, TEST_SURVEY_3_ID, TEST_SURVEY_3_CODE, 
				TEST_SURVEY_3_EMAIL, TEST_SURVEY_3_STATE, TEST_SURVEY_3_ACTIVITY_LEVEL);
	}
	
	protected Park getPark(String parkCode, String parkName, String state, 
		  		long acreage, long elevationInFeet, BigDecimal milesOfTrail,
		  		long numberOfCampsites, String climate, long yearFounded,
		  		long annualVisitorCount, String inspirationalQuote,
		  		String inspirationalQuoteSource, String parkDescription,
		  		long entryFee, long numberOfAnimalSpecies) 
	{
		Park park = new Park();
		
		park.setParkCode(parkCode);
		park.setParkName(parkName);
		park.setState(state);
		park.setAcreage(acreage);
		park.setElevationInFeet(elevationInFeet);
		park.setMilesOfTrail(milesOfTrail);
		park.setNumberOfCampsites(numberOfCampsites);
		park.setClimate(climate);
		park.setYearFounded(yearFounded);
		park.setAnnualVisitorCount(annualVisitorCount);
		park.setInspirationalQuote(inspirationalQuote);
		park.setInspirationalQuoteSource(inspirationalQuoteSource);
		park.setParkDescription(parkDescription);
		park.setEntryFee(entryFee);
		park.setNumberOfAnimalSpecies(numberOfAnimalSpecies);
		 
		return park;
	}

	protected void assertParksAreEqual(Park expected, Park actual) {
		assertEquals(expected.getParkCode(), actual.getParkCode());
		assertEquals(expected.getParkName(), actual.getParkName());
		assertEquals(expected.getState(), actual.getState());
		assertEquals(expected.getAcreage(), actual.getAcreage());
		assertEquals(expected.getElevationInFeet(), actual.getElevationInFeet());
		assertEquals(expected.getMilesOfTrail(), actual.getMilesOfTrail());
		assertEquals(expected.getNumberOfCampsites(), actual.getNumberOfCampsites());
		assertEquals(expected.getClimate(), actual.getClimate());
		assertEquals(expected.getYearFounded(), actual.getYearFounded());
		assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		assertEquals(expected.getInspirationalQuote(), actual.getInspirationalQuote());
		assertEquals(expected.getInspirationalQuoteSource(), actual.getInspirationalQuoteSource());
		assertEquals(expected.getParkDescription(), actual.getParkDescription());
		assertEquals(expected.getEntryFee(), actual.getEntryFee());
		assertEquals(expected.getNumberOfAnimalSpecies(), actual.getNumberOfAnimalSpecies());
	}
	
}
