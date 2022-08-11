package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Teams{

	@SerializedName("away")
	private Away away;

	@SerializedName("home")
	private Home home;

	public void setAway(Away away){
		this.away = away;
	}

	public Away getAway(){
		return away;
	}

	public void setHome(Home home){
		this.home = home;
	}

	public Home getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return 
			"Teams{" + 
			"away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}