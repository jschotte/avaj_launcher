package com.jschotte.aircraft;

import com.jschotte.aircraft.Coordinates;
import com.jschotte.avaj_launcher.customException;

public class Coordinates
{
	private int longitude;
	private int latitude;
	private int height;

	Coordinates(int longitude, int latitude, int height)
	{
		if (height <= 0 || height > 100 || longitude < 0 || latitude < 0)
			throw new customException("Coordinate are invalid !");	
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
	}

	public int getLongitude()
	{
		return this.longitude;
	}

	public int getLatitude()
	{
		return this.latitude;
	}

	public int getHeight()
	{
		return this.height;
	}

	public void addLongitude(int longitude)
	{
		this.longitude += longitude;
		if (this.longitude < 0)
			this.longitude = 0;	
	}

	public void addLatitude(int latitude)
	{
		this.latitude += latitude;
		if (this.latitude < 0)
			this.latitude = 0;	
	}

	public void addHeight(int height)
	{
		this.height += height;
		if (this.height > 100)
			this.height = 100;
		else if (this.height < 0)
			this.height = 0;
	}
}	
