package com.jschotte.avaj_launcher;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;


public class FileLogger
{
	private static FileLogger fileLogger = new FileLogger();
	private final String file = "simulation.txt";
	private PrintWriter writer;

	private FileLogger()
	{
		try
		{
			FileWriter fw = new FileWriter(file);
			writer = new PrintWriter(fw, true);
		}

		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public static FileLogger getFileLogger()
	{
		return FileLogger.fileLogger;
	}

	public void write(String line)
	{
		writer.println(line);
	}
}
