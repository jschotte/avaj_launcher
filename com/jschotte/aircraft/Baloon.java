package com.jschotte.aircraft;

import com.jschotte.avaj_launcher.WeatherTower;
import com.jschotte.avaj_launcher.customException;
import com.jschotte.avaj_launcher.Main;
import com.jschotte.avaj_launcher.FileLogger;

public class Baloon extends Aircraft implements Flyable
{
	private WeatherTower weatherTower;

	Baloon(String name, Coordinates coordinates)
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
				this.coordinates.addLongitude(2);
				this.coordinates.addHeight(4);
				FileLogger.getFileLogger().write(this.getDescription() + ": Let's enjoy the good weather and take some pics.");
				break;
			case "RAIN":
				this.coordinates.addHeight(-5);
				FileLogger.getFileLogger().write(this.getDescription() + ": Damn you rain! You messed up my baloon.");
				break;
			case "FOG":
				this.coordinates.addHeight(-3);
				FileLogger.getFileLogger().write(this.getDescription() + ": I don't see anything because of the fog.");
				break;
			case "SNOW":
				this.coordinates.addHeight(-15);
				FileLogger.getFileLogger().write(this.getDescription() + ": It's snowing. We're gonna crash.");
				break;
			default:
				throw new customException("Weather type " + this.weatherTower.getWeather(this.coordinates)  + " invalid");
		}
		if (this.coordinates.getHeight() <= 0)
		{
			FileLogger.getFileLogger().write(this.getDescription() + "landing.");
			weatherTower.unregister(this);
		}
	}
}
