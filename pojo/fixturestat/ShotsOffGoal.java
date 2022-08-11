package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class ShotsOffGoal{

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
			"ShotsOffGoal{" + 
			"away = '" + away + '\'' + 
			",home = '" + home + '\'' + 
			"}";
		}
}