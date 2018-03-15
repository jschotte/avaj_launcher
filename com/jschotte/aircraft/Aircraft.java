package com.jschotte.aircraft;

public class Aircraft
{
	protected long id;
	protected String name;
	protected Coordinates coordinates;
	
	private static long idCounter = 0;

	protected Aircraft(String name, Coordinates coordinates)
	{
		this.name = name;
		this.coordinates = coordinates;
		this.id = nextId();
	}

	private long nextId()
	{
		return ++idCounter;
	}

	public String getDescription()
	{
		return(this.getClass().getSimpleName() + "#" + this.getName() + "(" + this.getId() + ") ");
	}

	public long getId()
	{
		return this.id;
	}

	public String getName()
	{
		return this.name;
	}

	public Coordinates getCoordinates()
	{
		return this.coordinates;
	}
}
