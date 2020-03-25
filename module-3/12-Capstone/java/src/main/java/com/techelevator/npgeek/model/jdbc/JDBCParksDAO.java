package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.Park;
import com.techelevator.npgeek.model.ParksDAO;

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
		
		park.setParkId(result.getLong("park_id"));
		park.setName(result.getString("name"));
		park.setLocation(result.getString("location"));
		park.setEstablishDate(result.getDate("establish_date").toLocalDate());
		park.setArea(result.getInt("area"));
		park.setAnnualVisitorCount(result.getInt("annualVisitorCount"));
		park.setDescription(result.getString("description"));
		park.setQuote(result.getString("quote"));
		return park;
	}

}
