package com.jschotte.aircraft;

import com.jschotte.avaj_launcher.WeatherTower;
import com.jschotte.avaj_launcher.customException;
import com.jschotte.avaj_launcher.FileLogger;

public class Helicopter extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Helicopter(String name, Coordinates coordinates)
	{
		super(name, coordinates);
	}

	public void registerTower(WeatherTower weatherTower)
	{
		this.weatherTower = weatherTower;
		this.weatherTower.register(this);
	}
	
	public void updateConditions()
	{
		switch (this.weatherTower.getWeather(this.coordinates))
		{
			case "SUN":
				this.coordinates.addLongitude(10);
				this.coordinates.addHeight(2);
				FileLogger.getFileLogger().write(this.getDescription() + ": This is hot.");
				break;
			case "RAIN":
				this.coordinates.addLongitude(5);
				FileLogger.getFileLogger().write(this.getDescription() + ": Watch out for lightning.");
				break;
			case "FOG":
				this.coordinates.addLongitude(1);
				FileLogger.getFileLogger().write(this.getDescription() + ": There is fog everywhere.");
				break;
			case "SNOW":
				this.coordinates.addHeight(-12);
				FileLogger.getFileLogger().write(this.getDescription() + ": My rotor is going to freeze!");
				break;
			default:
				throw new customException("Weather type invalid");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			FileLogger.getFileLogger().write(this.getDescription() + "landing.");	
			weatherTower.unregister(this);
		}
	}
}
