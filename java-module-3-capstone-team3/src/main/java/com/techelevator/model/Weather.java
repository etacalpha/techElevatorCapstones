package com.techelevator.model;

public class Weather
{
	private String parkcode;
	private int fivedayforcastvalue;
	private int lowF;
	private int highF;
	private int lowC;
	private int highC;
	private String forcast;
	private String tempMessage = "";
	private String forecastMessage = "";
	
	
	public String getTempMessage() {
		return tempMessage;
	}


	public void setTempMessage(int high, int low) {
		if (high >= 75 || low >= 75) {
			this.tempMessage += "Heat Advisory: Bring an extra gallon of water!";
		} 
		
		if (high <= 20 || low <= 20) {
			this.tempMessage += "Caution: Prolonged exposure to freezing temperatures can be fatal.";
		}
		
		if ((high-low) >= 20) {
			this.tempMessage += "Large temperature fluctuations. Wear breathable layers!";
		}
		
	}


	public String getForecastMessage() {
		return forecastMessage;
	}


	public void setForecastMessage(String forecast) {
		if (forecast.equals("snow")) {
			this.forecastMessage = "Pack snowshoes!";
		}
		if (forecast.equals("rain")) {
			this.forecastMessage = "Pack rain gear!";
		}
		if (forecast.equals("thunderstorms")) {
			this.forecastMessage = "Seek shelter. Avoid hiking on exposed ridges!";
		}
		if (forecast.equals("sunny")) {
			this.forecastMessage = "Pack sunblock!";
		}
	}


	public int getLowF() {
		return lowF;
	}


	public void setLowF(int lowF) {
		this.lowF = lowF;
	}


	public int getHighF() {
		return highF;
	}


	public void setHighF(int highF) {
		this.highF = highF;
	}


	public int getLowC() {
		return lowC;
	}


	public void setLowC(int lowC) {
		this.lowC = (int) ((getLowF()-32) / 1.8);
	}


	public int getHighC() {
		return highC;
	}


	public void setHighC(int highC) {
		this.highC = (int) ((getHighF()-32) / 1.8);
	}


	
	
	
	


	public Weather()
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


	public int getFivedayforcastvalue()
	{
		return fivedayforcastvalue;
	}


	public void setFivedayforcastvalue(int fivedayforcastvalue)
	{
		this.fivedayforcastvalue = fivedayforcastvalue;
	}


	public String getForcast()
	{
		return forcast;
	}


	public void setForcast(String forcast)
	{
		this.forcast = forcast;
	}
	
	//convertedTemp = ( - 32) / 1.8);    
	//
	
}
