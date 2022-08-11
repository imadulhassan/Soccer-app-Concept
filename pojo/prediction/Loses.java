package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Loses{

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
			"Loses{" + 
			"total = '" + total + '\'' + 
			",away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}