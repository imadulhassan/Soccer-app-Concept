package com.soccer.pojo.round;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("fixtures")
	private List<String> fixtures;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setFixtures(List<String> fixtures){
		this.fixtures = fixtures;
	}

	public List<String> getFixtures(){
		return fixtures;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",fixtures = '" + fixtures + '\'' + 
			"}";
		}
}