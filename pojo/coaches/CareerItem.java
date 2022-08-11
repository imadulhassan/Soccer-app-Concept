package com.soccer.pojo.coaches;


import com.google.gson.annotations.SerializedName;


public class CareerItem{

	@SerializedName("start")
	private String start;

	@SerializedName("end")
	private Object end;

	@SerializedName("team")
	private Team team;

	public void setStart(String start){
		this.start = start;
	}

	public String getStart(){
		return start;
	}

	public void setEnd(Object end){
		this.end = end;
	}

	public Object getEnd(){
		return end;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
	}

	@Override
 	public String toString(){
		return 
			"CareerItem{" + 
			"start = '" + start + '\'' + 
			",end = '" + end + '\'' + 
			",team = '" + team + '\'' + 
			"}";
		}
}