package com.soccer.pojo.teamleagues;


import com.google.gson.annotations.SerializedName;
public class Coverage{

	@SerializedName("topScorers")
	private boolean topScorers;

	@SerializedName("players")
	private boolean players;

	@SerializedName("odds")
	private boolean odds;

	@SerializedName("standings")
	private boolean standings;

	@SerializedName("predictions")
	private boolean predictions;

	@SerializedName("fixtures")
	private Fixtures fixtures;

	public void setTopScorers(boolean topScorers){
		this.topScorers = topScorers;
	}

	public boolean isTopScorers(){
		return topScorers;
	}

	public void setPlayers(boolean players){
		this.players = players;
	}

	public boolean isPlayers(){
		return players;
	}

	public void setOdds(boolean odds){
		this.odds = odds;
	}

	public boolean isOdds(){
		return odds;
	}

	public void setStandings(boolean standings){
		this.standings = standings;
	}

	public boolean isStandings(){
		return standings;
	}

	public void setPredictions(boolean predictions){
		this.predictions = predictions;
	}

	public boolean isPredictions(){
		return predictions;
	}

	public void setFixtures(Fixtures fixtures){
		this.fixtures = fixtures;
	}

	public Fixtures getFixtures(){
		return fixtures;
	}

	@Override
 	public String toString(){
		return 
			"Coverage{" + 
			"topScorers = '" + topScorers + '\'' + 
			",players = '" + players + '\'' + 
			",odds = '" + odds + '\'' + 
			",standings = '" + standings + '\'' + 
			",predictions = '" + predictions + '\'' + 
			",fixtures = '" + fixtures + '\'' + 
			"}";
		}
}