package com.techelevator;

import java.util.Set;

import org.junit.runner.notification.StoppedByUserException;

import com.techelevator.view.Menu;

public class VendingMachineCLI extends Snacks
{
	private static String productKey = "";

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";

	private static final String MAIN_MENU_OPTION_EXIT = "Exit vending machine";
	private static final String[] MAIN_MENU_OPTIONS =
	{ MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_OPTION_EXIT };

	private static final String[] MAIN_MENU_OPTIONS1 =
	{ MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, };

	private Menu menu;

	public VendingMachineCLI(Menu menu)
	{
		this.menu = menu;
	}

	public static String getProductKey()
	{
		return productKey;
	}

	public void displayProducts()
	{
		final Set<String> keys = Inventory.startingInventory.keySet();
		System.out.println(
				"\t****************************************************************************************************************************");
		System.out.println("\t*\t\t\t\t\t       Please enter product Key  (A1 - D4)\t\t\t\t\t   *");
		for (int i = 1; i <= 4; i++)
		{
			System.out.println(
					"\t****************************************************************************************************************************");
			System.out.printf(
					"\t*\t A%d (%s)%-22s B%d (%s)%-22s C%d (%s)%-22s D%d (%s)%-21s*\n"
							+ "\t*\t     %-29s %-28s %-28s %-22s*\n",
					i, Inventory.startingInventory.get("A" + Integer.toString(i)).getCount(),
					Inventory.startingInventory.get("A" + Integer.toString(i)).getSnackName(), i,
					Inventory.startingInventory.get("B" + Integer.toString(i)).getCount(),
					Inventory.startingInventory.get("B" + Integer.toString(i)).getSnackName(), i,
					Inventory.startingInventory.get("C" + Integer.toString(i)).getCount(),
					Inventory.startingInventory.get("C" + Integer.toString(i)).getSnackName(), i,
					Inventory.startingInventory.get("D" + Integer.toString(i)).getCount(),
					Inventory.startingInventory.get("D" + Integer.toString(i)).getSnackName(),
					Inventory.startingInventory.get("A" + Integer.toString(i)).getCost(),
					Inventory.startingInventory.get("B" + Integer.toString(i)).getCost(),
					Inventory.startingInventory.get("C" + Integer.toString(i)).getCost(),
					Inventory.startingInventory.get("D" + Integer.toString(i)).getCost());
		}
		System.out.println(
				"\t****************************************************************************************************************************");
	}

	public void run()
	{
		int purchaseMenuChoice = 0;
		while (true)
		{

			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS))
			{
				displayProducts();
			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE))
			{

				purchaseMenuChoice = MoneyHandler.purchaseMenu(MoneyHandler.moneyProvided);
				if (purchaseMenuChoice != 0)
				{
					switch (purchaseMenuChoice)
					{
					case 1:
						// take money return to purchase menu increase moneyProvided value
						MoneyHandler.moneyProvided.add(MoneyHandler.takeMoney(MoneyHandler.moneyProvided));
						break;
					case 2:

						productKey = MoneyHandler.makePurchase();
						// than cost) return purchase menu
						break;
					case 3:

						purchaseMenuChoice = MoneyHandler.makeChange();
						super.ummSoGood();
						run();
						break;
					// give change and provide eating string return top menu

					}
				}

			} else if (choice.equals(MAIN_MENU_OPTION_EXIT))
			{
				System.exit(0);
				
			}
			choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS);
		}
	}

	public static void main(String[] args)
	{
		Menu menu = new Menu(System.in, System.out); // instantiate menu object (input-source, output source)
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		Inventory.buildInventory();
		cli.run();
		System.out.println("Thank you for your purchase");
		System.exit(0);

	}
}
