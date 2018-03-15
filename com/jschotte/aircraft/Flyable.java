package com.jschotte.aircraft;

import com.jschotte.avaj_launcher.WeatherTower;

public interface Flyable
{
	public void updateConditions();
	public void registerTower(WeatherTower weatherTower);
	public long getId();
	public String getName();
	public Coordinates getCoordinates();
	public String getDescription();
}
