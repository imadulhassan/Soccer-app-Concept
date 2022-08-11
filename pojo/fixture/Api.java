package com.soccer.pojo.fixture;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api {

	@SerializedName("results")
	private int results;

	@SerializedName("fixtures")
	private ArrayList<FixturesItem> fixtures;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setFixtures(ArrayList<FixturesItem> fixtures){
		this.fixtures = fixtures;
	}

	public ArrayList<FixturesItem> getFixtures(){
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