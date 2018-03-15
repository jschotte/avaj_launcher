package com.jschotte.avaj_launcher;

import com.jschotte.weather.Tower;
import com.jschotte.aircraft.Coordinates;
import com.jschotte.weather.WeatherProvider;

public class WeatherTower extends Tower
{
	public String getWeather(Coordinates coordinates)
	{
		return WeatherProvider.getProvider().getCurrentWeather(coordinates);
	}

	void changeWeather()
	{
		super.conditionsChanged();
	}
}
