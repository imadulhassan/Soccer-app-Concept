package com.soccer.pojo.lineup;


import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("lineUps")
	private LineUps lineUps;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setLineUps(LineUps lineUps){
		this.lineUps = lineUps;
	}

	public LineUps getLineUps(){
		return lineUps;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",lineUps = '" + lineUps + '\'' + 
			"}";
		}
}