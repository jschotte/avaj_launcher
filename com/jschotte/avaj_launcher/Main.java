package com.jschotte.avaj_launcher;

import com.jschotte.avaj_launcher.FileLogger;
import java.io.PrintWriter;
import com.jschotte.aircraft.AircraftFactory;
import com.jschotte.aircraft.Flyable;
import com.jschotte.weather.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;

public class Main
{
	public static void main(String [] args) throws InterruptedException
	{
		List<Flyable> flyables = new ArrayList<>();
		WeatherTower weatherTower = new WeatherTower();
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(args[0]));
			String line = reader.readLine();
			if (line != null)
			{
				int simul = Integer.parseInt(line);
				if (simul < 0)
				{
					System.out.println("simulation count should be positive !");
					System.exit(0);
				}
				while ((line = reader.readLine()) != null)
				{
					String split[] = line.split(" ");
					if (split.length != 5)
						throw new customException("Input bad formatted");
					Flyable flyable = AircraftFactory.newAircraft(split[0], split[1], Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]));
					flyables.add(flyable);
				}
				
				for (Flyable flyable: flyables)
				{
					flyable.registerTower(weatherTower);
				}

				for (int i = 0; i < simul; i++)
				{
					weatherTower.changeWeather();
				}
			}
			else
			{
				System.out.println("File empty");
			}
			reader.close();
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Scenario file missing");
		}
		catch (FileNotFoundException e)
		{
			 System.out.println("File \"" + args[0] + "\" not found");
		}
		catch (IOException e)
		{
			 System.out.println("Error while reading");
		}
		catch (NumberFormatException e)
		{
			System.out.println("Error in file");
		}
		catch (Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
