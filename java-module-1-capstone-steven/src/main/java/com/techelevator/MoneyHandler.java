package com.techelevator;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Scanner;

public class MoneyHandler
{
	static BigDecimal moneyProvided = new BigDecimal("0");
	static double totalMoney = 0;
	static String purchaseSelection = "";

	static int purchaseMenu(BigDecimal moneyProvided)
	{
		System.out.printf("Current Money Provided: $%.2f", moneyProvided);
		System.out.println("\n");
		System.out.printf("(1) Feed Money\n");
		System.out.printf("(2) Select Product\n");
		System.out.printf("(3) Finish Transaction\n");

		int choice = Commo.input.nextInt();

		return choice;
	}

	static BigDecimal takeMoney(BigDecimal moneyProvided)
	{
		String moreMoney = "";
		BigDecimal money = moneyProvided;
		System.out.printf("You currently have depositied %.2f\n", moneyProvided);
		try
		{
			System.out.printf("Please enter amount to deposit!\n");
			MoneyHandler.moneyProvided = moneyProvided.add(Commo.input.nextBigDecimal());
		} catch (Exception e)
		{
			e.toString();
			System.out.println("Incorrect value entered please try again.\n");
		}
		System.out.printf("\nWould you like to enter more money? (y or n\n");
		moreMoney = Commo.input.next();
		if (moreMoney.equals("n"))
		{
			return money;
		}
		return takeMoney(money);
	}

	static String makePurchase()
	{
		//Scanner sc = new Scanner(System.in);
		Commo.input.nextLine();
		
		while (purchaseSelection.equals(""))
		{
			try
			{
				System.out.println("\nWhat product would you like?");
				
				purchaseSelection = Commo.input.nextLine();
				for (String a : Inventory.startingInventory.keySet())
				{
					if (purchaseSelection != a)
					{
						throw new Exception("Um what!!??!!");
					}
				}
				
			} catch (Exception e)
			{
				e.toString();
				System.out.println("\nIncorrect value entered please try again.\n");
				makePurchase();
			}
		}
		if (moneyProvided.compareTo(new BigDecimal(Inventory.startingInventory.get(purchaseSelection).getCost())) != 0)
			;
		{
			totalMoney += Inventory.startingInventory.get(purchaseSelection).getCost();
			Inventory.startingInventory.get(purchaseSelection)
					.setCount(Inventory.startingInventory.get(purchaseSelection).getCount() - 1);
		}

		// purchaseMenu(moneyProvided);
		return purchaseSelection;
	}

	static int makeChange()
	{
		BigDecimal change = moneyProvided
				.subtract(new BigDecimal(Inventory.startingInventory.get(purchaseSelection).getCost()));
		int toReturn = (int) (change.doubleValue() * 100);
		int quarters = toReturn / 25;
		toReturn = toReturn - quarters * 25;

		int dimes = toReturn / 10;
		toReturn = toReturn - dimes * 10;

		int nickels = toReturn / 5;

		System.out.printf("Your change is %d quarters, %d dimes, %d nickles for a total of $%.4s\n", quarters, dimes,
				nickels, change);
		moneyProvided = new BigDecimal("0.00");
		purchaseSelection = "";
		return 0;
	}
}
