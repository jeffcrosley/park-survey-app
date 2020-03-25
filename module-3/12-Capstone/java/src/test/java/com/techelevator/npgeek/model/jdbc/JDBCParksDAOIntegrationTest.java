package com.techelevator.npgeek.model.jdbc;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.Park;

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
		dao = new JDBCParksDAO(getDataSource());
	}
	
	@Test
	public void return_all_parks() {
		Park actual = getPark(TEST_PARK_1)
	}
	
	 private Park getPark( Long parkId, String name, String location, 
			 String description, LocalDate establishDate,
			 int area, int annualVisitorCount, String quote) {
		Park park = new Park();
		park.setParkId(parkId);
		park.setName(name);
		park.setLocation(location);
		park.setDescription(description);
		park.setEstablishDate(establishDate);
		park.setArea(area);
		park.setAnnualVisitorCount(annualVisitorCount);
		park.setQuote(quote);
		 
		return park;
	 }
	 
	 private void assertParksAreEqual(Park expected, Park actual) {
		 assertEquals(expected.getParkId(), actual.getParkId());
		 assertEquals(expected.getName(), actual.getName());
		 assertEquals(expected.getLocation(), actual.getLocation());
		 assertEquals(expected.getDescription(), actual.getDescription());
		 assertEquals(expected.getEstablishDate(), actual.getEstablishDate());
		 assertEquals(expected.getArea(), actual.getArea());
		 assertEquals(expected.getAnnualVisitorCount(), actual.getAnnualVisitorCount());
		 assertEquals(expected.getQuote(), actual.getQuote());
	 }
}
