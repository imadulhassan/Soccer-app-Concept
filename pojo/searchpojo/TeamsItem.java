package com.soccer.pojo.searchpojo;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TeamsItem implements Serializable {

	@SerializedName("venue_name")
	private String venueName;

	@SerializedName("country")
	private String country;

	@SerializedName("venue_capacity")
	private int venueCapacity;

	@SerializedName("code")
	private Object code;

	@SerializedName("venue_address")
	private String venueAddress;

	@SerializedName("venue_surface")
	private String venueSurface;

	@SerializedName("name")
	private String name;

	@SerializedName("founded")
	private int founded;

	@SerializedName("logo")
	private String logo;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("venue_city")
	private String venueCity;

	public void setVenueName(String venueName){
		this.venueName = venueName;
	}

	public String getVenueName(){
		return venueName;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setVenueCapacity(int venueCapacity){
		this.venueCapacity = venueCapacity;
	}

	public int getVenueCapacity(){
		return venueCapacity;
	}

	public void setCode(Object code){
		this.code = code;
	}

	public Object getCode(){
		return code;
	}

	public void setVenueAddress(String venueAddress){
		this.venueAddress = venueAddress;
	}

	public String getVenueAddress(){
		return venueAddress;
	}

	public void setVenueSurface(String venueSurface){
		this.venueSurface = venueSurface;
	}

	public String getVenueSurface(){
		return venueSurface;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setFounded(int founded){
		this.founded = founded;
	}

	public int getFounded(){
		return founded;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setVenueCity(String venueCity){
		this.venueCity = venueCity;
	}

	public String getVenueCity(){
		return venueCity;
	}

	@Override
 	public String toString(){
		return 
			"TeamsItem{" + 
			"venue_name = '" + venueName + '\'' + 
			",country = '" + country + '\'' + 
			",venue_capacity = '" + venueCapacity + '\'' + 
			",code = '" + code + '\'' + 
			",venue_address = '" + venueAddress + '\'' + 
			",venue_surface = '" + venueSurface + '\'' + 
			",name = '" + name + '\'' + 
			",founded = '" + founded + '\'' + 
			",logo = '" + logo + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",venue_city = '" + venueCity + '\'' + 
			"}";
		}
}