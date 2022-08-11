package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class FishLaw{

	@SerializedName("away")
	private String away;

	@SerializedName("home")
	private String home;

	public void setAway(String away){
		this.away = away;
	}

	public String getAway(){
		return away;
	}

	public void setHome(String home){
		this.home = home;
	}

	public String getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return 
			"FishLaw{" + 
			"away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}