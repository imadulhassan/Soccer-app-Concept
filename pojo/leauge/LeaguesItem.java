package com.soccer.pojo.leauge;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LeaguesItem implements Serializable {

	@SerializedName("country")
	private String country;

	@SerializedName("countries")
	private String countries;

	@SerializedName("country_code")
	private Object countryCode;

	@SerializedName("flag")
	private Object flag;

	@SerializedName("season_start")
	private String seasonStart;

	@SerializedName("name")
	private String name;

	@SerializedName("season")
	private int season;

	@SerializedName("logo")
	private String logo;

	@SerializedName("is_current")
	private int isCurrent;

	@SerializedName("standings")
	private int standings;

	@SerializedName("league_id")
	private int leagueId;

	@SerializedName("season_end")
	private String seasonEnd;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCountries(String countries){
		this.countries = countries;
	}

	public String getCountries(){
		return countries;
	}


	public void setCountryCode(Object countryCode){
		this.countryCode = countryCode;
	}

	public Object getCountryCode(){
		return countryCode;
	}

	public void setFlag(Object flag){
		this.flag = flag;
	}

	public Object getFlag(){
		return flag;
	}

	public void setSeasonStart(String seasonStart){
		this.seasonStart = seasonStart;
	}

	public String getSeasonStart(){
		return seasonStart;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setSeason(int season){
		this.season = season;
	}

	public int getSeason(){
		return season;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	public void setIsCurrent(int isCurrent){
		this.isCurrent = isCurrent;
	}

	public int getIsCurrent(){
		return isCurrent;
	}

	public void setStandings(int standings){
		this.standings = standings;
	}

	public int getStandings(){
		return standings;
	}

	public void setLeagueId(int leagueId){
		this.leagueId = leagueId;
	}

	public int getLeagueId(){
		return leagueId;
	}

	public void setSeasonEnd(String seasonEnd){
		this.seasonEnd = seasonEnd;
	}

	public String getSeasonEnd(){
		return seasonEnd;
	}

	@Override
 	public String toString(){
		return 
			"LeaguesItem{" + 
			"country = '" + country + '\'' + 
			",country_code = '" + countryCode + '\'' + 
			",flag = '" + flag + '\'' + 
			",season_start = '" + seasonStart + '\'' + 
			",name = '" + name + '\'' + 
			",season = '" + season + '\'' + 
			",logo = '" + logo + '\'' + 
			",is_current = '" + isCurrent + '\'' + 
			",standings = '" + standings + '\'' + 
			",league_id = '" + leagueId + '\'' + 
			",season_end = '" + seasonEnd + '\'' + 
			"}";
		}
}