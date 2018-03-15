package com.jschotte.aircraft;

import com.jschotte.avaj_launcher.WeatherTower;
import com.jschotte.avaj_launcher.customException;
import com.jschotte.avaj_launcher.FileLogger;

public class JetPlane extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	JetPlane(String name, Coordinates coordinates)
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
				this.coordinates.addLatitude(10);
				this.coordinates.addHeight(2);
				FileLogger.getFileLogger().write(this.getDescription() + ": This is a good weather to go to the beach.");
				break;
			case "RAIN":
				this.coordinates.addLatitude(5);
				FileLogger.getFileLogger().write(this.getDescription() + ": It's raining. Better watch out for lightings.");
				break;
			case "FOG":
				this.coordinates.addLatitude(1);
				FileLogger.getFileLogger().write(this.getDescription() + ": The fog is so thick i can't see my hands.");
				break;
			case "SNOW":
				this.coordinates.addHeight(-7);
				FileLogger.getFileLogger().write(this.getDescription() + ": OMG! Winter is coming!");
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
