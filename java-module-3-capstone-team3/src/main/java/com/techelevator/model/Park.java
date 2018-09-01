package com.techelevator.model;

public class Park
{
	
	private String parkcode;
	private String parkname;
	private String state;
	private int acreage;
	private int elevationinfeet;
	private float milesoftrail;
	private int numberofcampsites;
	private String climate;
	private int yearfounded;
	private int annualvisitorcount;
	private String inspirationalquote;
	private String inspirationalquotesource;
	private String parkdescription;
	private int entryfee;
	private int numberofanimalspecies;
	

	public Park(String parkcode, String parkname, String state, int acreage, int elevationinfeet, float milesoftrail,
			int numberofcampsites, String climate, int yearfounded, int annualvisitorcount, String inspirationalquote,
			String inspirationalquotesource, String parkdescription, int entryfee, int numberofanimalspecies)
	{
		super();
		this.parkcode = parkcode;
		this.parkname = parkname;
		this.state = state;
		this.acreage = acreage;
		this.elevationinfeet = elevationinfeet;
		this.milesoftrail = milesoftrail;
		this.numberofcampsites = numberofcampsites;
		this.climate = climate;
		this.yearfounded = yearfounded;
		this.annualvisitorcount = annualvisitorcount;
		this.inspirationalquote = inspirationalquote;
		this.inspirationalquotesource = inspirationalquotesource;
		this.parkdescription = parkdescription;
		this.entryfee = entryfee;
		this.numberofanimalspecies = numberofanimalspecies;
	}


	public Park()
	{
	}


	public String getParkcode()
	{
		return parkcode;
	}


	public void setParkcode(String parkcode)
	{
		this.parkcode = parkcode;
	}


	public String getParkname()
	{
		return parkname;
	}


	public void setParkname(String parkname)
	{
		this.parkname = parkname;
	}


	public String getState()
	{
		return state;
	}


	public void setState(String state)
	{
		this.state = state;
	}


	public int getAcreage()
	{
		return acreage;
	}


	public void setAcreage(int acreage)
	{
		this.acreage = acreage;
	}


	public int getElevationinfeet()
	{
		return elevationinfeet;
	}


	public void setElevationinfeet(int elevationinfeet)
	{
		this.elevationinfeet = elevationinfeet;
	}


	public float getMilesoftrail()
	{
		return milesoftrail;
	}


	public void setMilesoftrail(float milesoftrail)
	{
		this.milesoftrail = milesoftrail;
	}


	public int getNumberofcampsites()
	{
		return numberofcampsites;
	}


	public void setNumberofcampsites(int numberofcampsites)
	{
		this.numberofcampsites = numberofcampsites;
	}


	public String getClimate()
	{
		return climate;
	}


	public void setClimate(String climate)
	{
		this.climate = climate;
	}


	public int getYearfounded()
	{
		return yearfounded;
	}


	public void setYearfounded(int yearfounded)
	{
		this.yearfounded = yearfounded;
	}


	public int getAnnualvisitorcount()
	{
		return annualvisitorcount;
	}


	public void setAnnualvisitorcount(int annualvisitorcount)
	{
		this.annualvisitorcount = annualvisitorcount;
	}


	public String getInspirationalquote()
	{
		return inspirationalquote;
	}


	public void setInspirationalquote(String inspirationalquote)
	{
		this.inspirationalquote = inspirationalquote;
	}


	public String getInspirationalquotesource()
	{
		return inspirationalquotesource;
	}


	public void setInspirationquotesource(String inspirationalquotesource)
	{
		this.inspirationalquotesource = inspirationalquotesource;
	}


	public String getParkdescription()
	{
		return parkdescription;
	}


	public void setParkdescription(String parkdescription)
	{
		this.parkdescription = parkdescription;
	}


	public int getEntryfee()
	{
		return entryfee;
	}


	public void setEntryfee(int entryfee)
	{
		this.entryfee = entryfee;
	}


	public int getNumberofanimalspecies()
	{
		return numberofanimalspecies;
	}


	public void setNumberofanimalspecies(int numberofanimalspecies)
	{
		this.numberofanimalspecies = numberofanimalspecies;
	}
	
	
	
}
