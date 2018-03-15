package com.jschotte.weather;

import com.jschotte.aircraft.Flyable;
import com.jschotte.avaj_launcher.FileLogger;
import com.jschotte.aircraft.Coordinates;
import java.util.*;

public class Tower
{
	private ArrayList<Flyable> observers = new ArrayList<>();
	private ArrayList<Flyable> hasLanded = new ArrayList<>();
	public void register(Flyable flyable)
	{
		observers.add(flyable);
		FileLogger.getFileLogger().write("Tower says: " + flyable.getDescription() + "registered to weather tower.");
	}

	public void unregister(Flyable flyable)
	{
		hasLanded.add(flyable);
		FileLogger.getFileLogger().write("Tower says: " + flyable.getDescription() + " unregistered to weather tower."
				+ " (" + flyable.getCoordinates().getLongitude() + ", " + flyable.getCoordinates().getLatitude() + ", " + flyable.getCoordinates().getHeight() + ")");
	}

	protected void conditionsChanged()
	{
		for (Flyable flyable : observers)
		{
			flyable.updateConditions();
		}

		for (Flyable flyable : hasLanded)
		{
			observers.remove(flyable);
		}

		hasLanded.clear();
	}
}
