package com.soccer.pojo.coaches;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("coachs")
	private List<CoachsItem> coachs;

	@SerializedName("results")
	private int results;

	public void setCoachs(List<CoachsItem> coachs){
		this.coachs = coachs;
	}

	public List<CoachsItem> getCoachs(){
		return coachs;
	}

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"coachs = '" + coachs + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}