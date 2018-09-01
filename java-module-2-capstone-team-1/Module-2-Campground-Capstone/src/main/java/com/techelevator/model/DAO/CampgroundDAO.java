package com.techelevator.model.DAO;


public interface CampgroundDAO
{

	public void getAllCampgrounds(String pChoice);
	public void displayCampInfo(String pChoice, String cChoice);
	public int campCount(String pChoice);

}
