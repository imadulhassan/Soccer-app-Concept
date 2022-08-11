package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class WinningPercent{

	@SerializedName("away")
	private String away;

	@SerializedName("draws")
	private String draws;

	@SerializedName("home")
	private String home;

	public void setAway(String away){
		this.away = away;
	}

	public String getAway(){
		return away;
	}

	public void setDraws(String draws){
		this.draws = draws;
	}

	public String getDraws(){
		return draws;
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
			"WinningPercent{" + 
			"away = '" + away + '\'' + 
			",draws = '" + draws + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}