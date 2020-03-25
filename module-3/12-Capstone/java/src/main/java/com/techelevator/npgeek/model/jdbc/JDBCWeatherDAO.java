package com.techelevator.npgeek.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.dao.WeatherDAO;
import com.techelevator.npgeek.model.Weather;

public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	static final String QUERY_FIVE_DAY_FORECAST = "SELECT * FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue";
	@Override
	public List<Weather> getFiveDayForecastByParkCode(String parkCode) {

		List<Weather> fiveDayWeather = new ArrayList<Weather>();
		SqlRowSet results = jdbcTemplate.queryForRowSet(QUERY_FIVE_DAY_FORECAST, parkCode);
		while(results.next()) {
			fiveDayWeather.add(mapRowToWeather(results));
		}
		return fiveDayWeather;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather theWeather;
		theWeather = new Weather();
		theWeather.setParkCode(results.getString("parkcode"));
		theWeather.setFiveDayForecastValue(results.getInt("fivedayforecastvalue"));
		theWeather.setFarenheitLow(results.getDouble("low"));
		theWeather.setFahrenheitHigh(results.getDouble("high"));
		theWeather.setCelsiusLow((results.getDouble("low")-32)*5/9);
		theWeather.setCelsiusHigh((results.getDouble("high")-32)*5/9);
		theWeather.setForecast(results.getString("forecast"));
		return theWeather;
	}

}
