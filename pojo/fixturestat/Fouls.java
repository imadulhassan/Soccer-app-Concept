package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class Fouls{

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
			"Fouls{" + 
			"away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}