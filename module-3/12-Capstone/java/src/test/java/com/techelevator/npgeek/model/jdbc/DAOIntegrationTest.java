package com.techelevator.npgeek.model.jdbc;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public abstract class DAOIntegrationTest {

	/* JEFF: THIS SPECIFIES A DUMMY DATA FOR TESTING */
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
	
	
	/* Using this particular implementation of DataSource so that
	 * every database interaction is part of the same database
	 * session and hence the same database transaction */
	private static SingleConnectionDataSource dataSource;

	/* Before any tests are run, this method initializes the datasource for testing. */
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/historygeek");
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

	/* JEFF: THIS SETS UP THE DUMMY DATA */
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
	}
	
	/* After each test, we rollback any changes that were made to the database so that
	 * everything is clean for the next test */
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}

	/* This method provides access to the DataSource for subclasses so that
	 * they can instantiate a DAO for testing */
	public DataSource getDataSource() {
		return dataSource;
	}
}
