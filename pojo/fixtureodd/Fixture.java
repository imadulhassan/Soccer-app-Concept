package com.soccer.pojo.fixtureodd;


import com.google.gson.annotations.SerializedName;


public class Fixture{

	@SerializedName("fixture_id")
	private int fixtureId;

	@SerializedName("updateAt")
	private int updateAt;

	@SerializedName("league_id")
	private int leagueId;

	public void setFixtureId(int fixtureId){
		this.fixtureId = fixtureId;
	}

	public int getFixtureId(){
		return fixtureId;
	}

	public void setUpdateAt(int updateAt){
		this.updateAt = updateAt;
	}

	public int getUpdateAt(){
		return updateAt;
	}

	public void setLeagueId(int leagueId){
		this.leagueId = leagueId;
	}

	public int getLeagueId(){
		return leagueId;
	}

	@Override
 	public String toString(){
		return 
			"Fixture{" + 
			"fixture_id = '" + fixtureId + '\'' + 
			",updateAt = '" + updateAt + '\'' + 
			",league_id = '" + leagueId + '\'' + 
			"}";
		}
}