package com.soccer.pojo.event;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("events")
	private List<EventsItem> events;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setEvents(List<EventsItem> events){
		this.events = events;
	}

	public List<EventsItem> getEvents(){
		return events;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",events = '" + events + '\'' + 
			"}";
		}
}