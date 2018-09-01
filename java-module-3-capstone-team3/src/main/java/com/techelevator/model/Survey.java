package com.techelevator.model;

public class Survey
{
		
	private int surveyid;
	private String parkcode;
	private String emailaddress;
	private String state;
	private String activitylevel;
	
	
	public Survey(int surveyid, String parkcode, String emailaddress, String state, String activitylevel)
	{
		super();
		this.surveyid = surveyid;
		this.parkcode = parkcode;
		this.emailaddress = emailaddress;
		this.state = state;
		this.activitylevel = activitylevel;
	}


	public Survey()
	{
		
	}


	public int getSurveyid()
	{
		return surveyid;
	}


	public void setSurveyid(int surveyid)
	{
		this.surveyid = surveyid;
	}


	public String getParkcode()
	{
		return parkcode;
	}


	public void setParkcode(String parkcode)
	{
		this.parkcode = parkcode;
	}


	public String getEmailaddress()
	{
		return emailaddress;
	}


	public void setEmailaddress(String emailaddress)
	{
		this.emailaddress = emailaddress;
	}


	public String getState()
	{
		return state;
	}


	public void setState(String state)
	{
		this.state = state;
	}


	public String getActivitylevel()
	{
		return activitylevel;
	}


	public void setActivitylevel(String activitylevel)
	{
		this.activitylevel = activitylevel;
	}
	
	
	
	
	
}

