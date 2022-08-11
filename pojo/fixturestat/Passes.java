package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class Passes{

	@SerializedName("away")
	private Object away;

	@SerializedName("home")
	private Object home;

	public void setAway(Object away){
		this.away = away;
	}

	public Object getAway(){
		return away;
	}

	public void setHome(Object home){
		this.home = home;
	}

	public Object getHome(){
		return home;
	}

	@Override
 	public String toString(){
		return 
			"Passes{" + 
			"away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}