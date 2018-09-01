package com.techelevator.parkDao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.model.Weather;

@Component
public class WeatherJdbcDao implements WeatherDao{
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public WeatherJdbcDao(DataSource datasource)
	{
		this.jdbcTemplate = new JdbcTemplate(datasource);
	}

	@Override
	public List<Weather> getParkWeather(String parkcode) {
		List<Weather> parkWeather = new ArrayList<>();
		String weatherSql = "SELECT * FROM weather WHERE parkcode = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(weatherSql, parkcode);
		while (results.next()) {
			parkWeather.add(mapRowToWeather(results));
		}
		
		return parkWeather;
	}
	
	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		
		weather.setParkcode(results.getString("parkcode"));
		weather.setFivedayforcastvalue(results.getInt("fivedayforecastvalue"));
		weather.setForcast(results.getString("forecast"));
		weather.setHighF(results.getInt("high"));
		weather.setLowF(results.getInt("low"));
		weather.setHighC(results.getInt("high"));
		weather.setLowC(results.getInt("low"));
		weather.setTempMessage(results.getInt("high"), results.getInt("low"));
		weather.setForecastMessage(results.getString("forecast"));
		
		return weather;
	}

	
}
