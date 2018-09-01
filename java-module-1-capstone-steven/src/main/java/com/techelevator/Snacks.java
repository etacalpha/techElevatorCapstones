package com.techelevator;

public class Snacks extends Inventory
{

	private String snackName = new String();
	private double cost;
	private int count = 5;
	private String type = new String();

	public Snacks()
	{

	}

	public String getSnackName()
	{
		return snackName;
	}

	public void setSnackName(String B)
	{
		this.snackName = B;
	}

	public double getCost()
	{
		return cost;
	}

	public void setCost(double A)
	{
		this.cost = A;
	}

	public int getCount()
	{
		return count;
	}

	public void setCount(int B)
	{
		this.count = B;
	}

	public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	/*
	 * All chip items will return “Crunch Crunch, Yum!” 2. All candy items will
	 * return “Munch Munch, Yum!” 3. All drink items will return “Glug Glug, Yum!”
	 * 4. All gum items will return “Chew Chew, Yum!”
	 */
	public void ummSoGood()
	{
		switch (startingInventory.get(VendingMachineCLI.getProductKey()).getType())
		{
		case "chip":
			System.out.println("Crunch Crunch, Yum!");
			break;
		case "candy":
			System.out.println("Munch Munch, Yum!");
			break;

		case "drink":
			System.out.println("Glug Glug, Yum!");
			break;

		default:
			System.out.println("Chew Chew, Yum!");
			break;
		}
	}

}
