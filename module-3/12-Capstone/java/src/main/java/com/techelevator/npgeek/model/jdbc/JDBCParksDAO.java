package com.techelevator.npgeek.model.jdbc;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class JDBCParksDAO {

	private JdbcTemplate jdbcTemplate;
	
	public JDBCParksDAO(DataSource datasource) {
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

}
