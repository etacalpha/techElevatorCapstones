package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory
{
	protected static TreeMap<String, Snacks> startingInventory = new TreeMap<String, Snacks>();
	static File inv = new File("vendingmachine.csv");

	static void buildInventory()
	{
		Scanner getInventory;
		try
		{
			getInventory = new Scanner(inv);
			while (getInventory.hasNextLine())
			{
				String line = getInventory.nextLine();
				Snacks holder = new Snacks();
				holder.setSnackName(line.split("\\|")[1]);
				holder.setCost(Double.parseDouble(line.split("\\|")[2]));
				holder.setType(line.split("\\|")[3]);
				startingInventory.put(line.substring(0, 2), holder);
			}
		} catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
	}

}
