package com.soccer.pojo.fixturestat;
import com.google.gson.annotations.SerializedName;
public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("statistics")
	private Statistics statistics;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setStatistics(Statistics statistics){
		this.statistics = statistics;
	}

	public Statistics getStatistics(){
		return statistics;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",statistics = '" + statistics + '\'' + 
			"}";
		}
}