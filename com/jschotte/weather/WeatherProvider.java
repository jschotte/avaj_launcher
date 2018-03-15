package com.jschotte.weather;

import com.jschotte.aircraft.Coordinates;

public class WeatherProvider
{
	private static WeatherProvider weatherProvider = new WeatherProvider();
	private String[] weather = {"SUN", "FOG", "RAIN", "SNOW"};

	private WeatherProvider()
	{

	}

	public static WeatherProvider getProvider()
	{
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates)
	{
		return weather[(coordinates.getLatitude() + coordinates.getLongitude() + coordinates.getHeight()) % 4];
	}
}
