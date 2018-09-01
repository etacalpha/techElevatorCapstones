package com.techelevator.parkDao;

import java.util.List;

import com.techelevator.model.Weather;

public interface WeatherDao {
	
	public List<Weather> getParkWeather(String parkcode);
}
