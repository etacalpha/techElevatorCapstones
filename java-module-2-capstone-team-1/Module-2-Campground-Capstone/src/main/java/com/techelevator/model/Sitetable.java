package com.techelevator.model;

public class Sitetable {

	private Long    site_Id;
	private int     campground_Id;
	private int     site_Number;
	private int     max_Occupancy;
	private Boolean accessible;
	private int     max_rv_length;
	private Boolean utilities;
	
	public Sitetable()
	{
		super();
	}

	public Long getSite_Id()
	{
		return site_Id;
	}

	public void setSite_Id(Long site_Id)
	{
		this.site_Id = site_Id;
	}

	public int getCampground_Id()
	{
		return campground_Id;
	}

	public void setCampground_Id(int campground_Id)
	{
		this.campground_Id = campground_Id;
	}

	public int getSite_Number()
	{
		return site_Number;
	}

	public void setSite_Number(int site_Number)
	{
		this.site_Number = site_Number;
	}

	public int getMax_Occupancy()
	{
		return max_Occupancy;
	}

	public void setMax_Occupancy(int max_Occupancy)
	{
		this.max_Occupancy = max_Occupancy;
	}

	public Boolean getAccessible()
	{
		return accessible;
	}

	public void setAccessible(Boolean accessible)
	{
		this.accessible = accessible;
	}

	public int getMax_rv_length()
	{
		return max_rv_length;
	}

	public void setMax_rv_length(int max_rv_length)
	{
		this.max_rv_length = max_rv_length;
	}

	public Boolean getUtilities()
	{
		return utilities;
	}

	public void setUtilities(Boolean utilities)
	{
		this.utilities = utilities;
	}
	
}
