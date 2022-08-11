package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Home{

	@SerializedName("all_last_matches")
	private AllLastMatches allLastMatches;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("last_h2h")
	private LastH2h lastH2h;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("last_5_matches")
	private Last5Matches last5Matches;

	public void setAllLastMatches(AllLastMatches allLastMatches){
		this.allLastMatches = allLastMatches;
	}

	public AllLastMatches getAllLastMatches(){
		return allLastMatches;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setLastH2h(LastH2h lastH2h){
		this.lastH2h = lastH2h;
	}

	public LastH2h getLastH2h(){
		return lastH2h;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setLast5Matches(Last5Matches last5Matches){
		this.last5Matches = last5Matches;
	}

	public Last5Matches getLast5Matches(){
		return last5Matches;
	}

	@Override
 	public String toString(){
		return 
			"Home{" + 
			"all_last_matches = '" + allLastMatches + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",last_h2h = '" + lastH2h + '\'' + 
			",team_name = '" + teamName + '\'' + 
			",last_5_matches = '" + last5Matches + '\'' + 
			"}";
		}
}