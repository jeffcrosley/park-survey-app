package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParksDAO;

@Component
public class JDBCParksDAO implements ParksDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCParksDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	static final String queryAllParksAlphabetically = "SELECT * FROM park";
	
	@Override
	public List<Park> getAllParks() {
		
		List<Park> parks = new ArrayList<Park>();
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(queryAllParksAlphabetically);
		
		while(rowSet.next()) {
			//create new park instance and set the sql data to the park object as attributes
			parks.add(mapRowToPark(rowSet));
			
		}		
		
		return parks;
	}
	
	private Park mapRowToPark(SqlRowSet result) {
		Park park = new Park();
		
		park.setParkCode(result.getString("parkcode"));
		park.setParkName(result.getString("parkname"));
		park.setState(result.getString("state"));
		park.setAcreage(result.getLong("acreage"));
		park.setElevationInFeet(result.getLong("elevationinfeet"));
		park.setMilesOfTrail(result.getBigDecimal("milesoftrail"));
		park.setNumberOfCampsites(result.getLong("numberofcampsites"));
		park.setClimate(result.getString("climate"));
		park.setYearFounded(result.getLong("yearfounded"));
		park.setAnnualVisitorCount(result.getLong("annualvisitorcount"));
		park.setInspirationalQuote(result.getString("inspirationalquote"));
		park.setInspirationalQuoteSource(result.getString("inspirationalquotesource"));
		park.setParkDescription(result.getString("parkdescription"));
		park.setEntryFee(result.getLong("entryfee"));
		park.setNumberOfAnimalSpecies(result.getLong("numberofanimalspecies"));
		
		return park;
	}

}
