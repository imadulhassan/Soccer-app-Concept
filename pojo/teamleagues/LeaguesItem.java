package com.soccer.pojo.teamleagues;


import com.google.gson.annotations.SerializedName;
public class LeaguesItem{

	@SerializedName("coverage")
	private Coverage coverage;

	@SerializedName("country")
	private String country;

	@SerializedName("flag")
	private String flag;

	@SerializedName("type")
	private String type;

	@SerializedName("standings")
	private int standings;

	@SerializedName("country_code")
	private String countryCode;

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

	@SerializedName("league_id")
	private int leagueId;

	@SerializedName("season_end")
	private String seasonEnd;

	public void setCoverage(Coverage coverage){
		this.coverage = coverage;
	}

	public Coverage getCoverage(){
		return coverage;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setFlag(String flag){
		this.flag = flag;
	}

	public String getFlag(){
		return flag;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setStandings(int standings){
		this.standings = standings;
	}

	public int getStandings(){
		return standings;
	}

	public void setCountryCode(String countryCode){
		this.countryCode = countryCode;
	}

	public String getCountryCode(){
		return countryCode;
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
			"coverage = '" + coverage + '\'' + 
			",country = '" + country + '\'' + 
			",flag = '" + flag + '\'' + 
			",type = '" + type + '\'' + 
			",standings = '" + standings + '\'' + 
			",country_code = '" + countryCode + '\'' + 
			",season_start = '" + seasonStart + '\'' + 
			",name = '" + name + '\'' + 
			",season = '" + season + '\'' + 
			",logo = '" + logo + '\'' + 
			",is_current = '" + isCurrent + '\'' + 
			",league_id = '" + leagueId + '\'' + 
			",season_end = '" + seasonEnd + '\'' + 
			"}";
		}
}