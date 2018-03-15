package com.jschotte.aircraft;

import com.jschotte.avaj_launcher.customException;

public class AircraftFactory
{
	static public Flyable newAircraft(String type, String name, int longitude, int latitude, int height)
	{
		Flyable flyable;

		switch (type)
		{
			case "Baloon":
				flyable = new Baloon(name, new Coordinates(longitude, latitude, height));
				break;
			case "JetPlane":
				flyable = new JetPlane(name, new Coordinates(longitude, latitude, height));
				break;
			case "Helicopter":
				flyable = new Helicopter(name, new Coordinates(longitude, latitude, height));
				break;
			default:
				throw new customException("aircraft type unknown");
		}
		return flyable;
	}
}
