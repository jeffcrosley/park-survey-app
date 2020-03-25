package com.techelevator.npgeek.model.jdbc;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.Park;

public class JDBCParksDAOIntegrationTest extends DAOIntegrationTest {
	
	private JDBCParksDAO dao;	
	
	@Before
	public void setup() {
		setupDatabase();
		dao = new JDBCParksDAO(getDataSource());
	}
	
	@Test
	public void return_all_parks() {
		
		Park expected1 = getPark(
				TEST_PARK_1_PARKCODE, TEST_PARK_1_PARKNAME, TEST_PARK_1_STATE, 
				TEST_PARK_1_ACREAGE, TEST_PARK_1_ELEVATION, TEST_PARK_1_MILESOFTRAIL,
				TEST_PARK_1_CAMPSITES, TEST_PARK_1_CLIMATE, TEST_PARK_1_YEARFOUNDED,
				TEST_PARK_1_ANNUALVISITORS, TEST_PARK_1_QUOTE, TEST_PARK_1_QUOTESOURCE,
				TEST_PARK_1_DESCRIPTION, TEST_PARK_1_FEE, TEST_PARK_1_ANIMALS
				);
		
		Park expected2 = getPark(
				TEST_PARK_2_PARKCODE, TEST_PARK_2_PARKNAME, TEST_PARK_2_STATE, 
				TEST_PARK_2_ACREAGE, TEST_PARK_2_ELEVATION, TEST_PARK_2_MILESOFTRAIL,
				TEST_PARK_2_CAMPSITES, TEST_PARK_2_CLIMATE, TEST_PARK_2_YEARFOUNDED,
				TEST_PARK_2_ANNUALVISITORS, TEST_PARK_2_QUOTE, TEST_PARK_2_QUOTESOURCE,
				TEST_PARK_2_DESCRIPTION, TEST_PARK_2_FEE, TEST_PARK_2_ANIMALS
				);
		
		int lastParkIndex = dao.getAllParks().size() - 1;
		
		Park actual1 = dao.getAllParks().get(lastParkIndex - 1);
		Park actual2 = dao.getAllParks().get(lastParkIndex);

		assertParksAreEqual(expected1, actual1);
		assertParksAreEqual(expected2, actual2);
	}
	
	  
}
