package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class GoalsAgainst{

	@SerializedName("total")
	private String total;

	@SerializedName("away")
	private String away;

	@SerializedName("home")
	private String home;

	public void setTotal(String total){
		this.total = total;
	}

	public String getTotal(){
		return total;
	}

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
			"GoalsAgainst{" + 
			"total = '" + total + '\'' + 
			",away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}