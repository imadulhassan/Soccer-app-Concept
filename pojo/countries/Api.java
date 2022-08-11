package com.soccer.pojo.countries;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("countries")
	private List<CountriesItem> countries;

	@SerializedName("results")
	private int results;

	public void setCountries(List<CountriesItem> countries){
		this.countries = countries;
	}

	public List<CountriesItem> getCountries(){
		return countries;
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
			"countries = '" + countries + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}