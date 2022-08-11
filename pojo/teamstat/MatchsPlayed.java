package com.soccer.pojo.teamstat;


import com.google.gson.annotations.SerializedName;


public class MatchsPlayed{

	@SerializedName("total")
	private int total;

	@SerializedName("away")
	private int away;

	@SerializedName("home")
	private int home;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setAway(int away){
		this.away = away;
	}

	public int getAway(){
		return away;
	}

	public void setHome(int home){
		this.home = home;
	}

	public int getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return 
			"MatchsPlayed{" + 
			"total = '" + total + '\'' + 
			",away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}