package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class PlayersItem  implements Serializable {

	@SerializedName("fouls")
	private Fouls fouls;

	@SerializedName("cards")
	private Cards cards;

	@SerializedName("dribbles")
	private Dribbles dribbles;

	@SerializedName("penalty")
	private Penalty penalty;

	@SerializedName("rating")
	private String rating;

	@SerializedName("updateAt")
	private int updateAt;

	@SerializedName("team_id")
	private int teamId;

	@SerializedName("captain")
	private String captain;

	@SerializedName("duels")
	private Duels duels;

	@SerializedName("team_name")
	private String teamName;

	@SerializedName("substitute")
	private String substitute;

	@SerializedName("number")
	private int number;

	@SerializedName("event_id")
	private int eventId;

	@SerializedName("player_id")
	private int playerId;

	@SerializedName("passes")
	private Passes passes;

	@SerializedName("minutes_played")
	private int minutesPlayed;

	@SerializedName("player_name")
	private String playerName;

	@SerializedName("position")
	private String position;

	@SerializedName("tackles")
	private Tackles tackles;

	@SerializedName("shots")
	private Shots shots;

	@SerializedName("offsides")
	private Object offsides;

	@SerializedName("goals")
	private Goals goals;

	public void setFouls(Fouls fouls){
		this.fouls = fouls;
	}

	public Fouls getFouls(){
		return fouls;
	}

	public void setCards(Cards cards){
		this.cards = cards;
	}

	public Cards getCards(){
		return cards;
	}

	public void setDribbles(Dribbles dribbles){
		this.dribbles = dribbles;
	}

	public Dribbles getDribbles(){
		return dribbles;
	}

	public void setPenalty(Penalty penalty){
		this.penalty = penalty;
	}

	public Penalty getPenalty(){
		return penalty;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setUpdateAt(int updateAt){
		this.updateAt = updateAt;
	}

	public int getUpdateAt(){
		return updateAt;
	}

	public void setTeamId(int teamId){
		this.teamId = teamId;
	}

	public int getTeamId(){
		return teamId;
	}

	public void setCaptain(String captain){
		this.captain = captain;
	}

	public String getCaptain(){
		return captain;
	}

	public void setDuels(Duels duels){
		this.duels = duels;
	}

	public Duels getDuels(){
		return duels;
	}

	public void setTeamName(String teamName){
		this.teamName = teamName;
	}

	public String getTeamName(){
		return teamName;
	}

	public void setSubstitute(String substitute){
		this.substitute = substitute;
	}

	public String getSubstitute(){
		return substitute;
	}

	public void setNumber(int number){
		this.number = number;
	}

	public int getNumber(){
		return number;
	}

	public void setEventId(int eventId){
		this.eventId = eventId;
	}

	public int getEventId(){
		return eventId;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setPasses(Passes passes){
		this.passes = passes;
	}

	public Passes getPasses(){
		return passes;
	}

	public void setMinutesPlayed(int minutesPlayed){
		this.minutesPlayed = minutesPlayed;
	}

	public int getMinutesPlayed(){
		return minutesPlayed;
	}

	public void setPlayerName(String playerName){
		this.playerName = playerName;
	}

	public String getPlayerName(){
		return playerName;
	}

	public void setPosition(String position){
		this.position = position;
	}

	public String getPosition(){
		return position;
	}

	public void setTackles(Tackles tackles){
		this.tackles = tackles;
	}

	public Tackles getTackles(){
		return tackles;
	}

	public void setShots(Shots shots){
		this.shots = shots;
	}

	public Shots getShots(){
		return shots;
	}

	public void setOffsides(Object offsides){
		this.offsides = offsides;
	}

	public Object getOffsides(){
		return offsides;
	}

	public void setGoals(Goals goals){
		this.goals = goals;
	}

	public Goals getGoals(){
		return goals;
	}

	@Override
 	public String toString(){
		return 
			"PlayersItem{" + 
			"fouls = '" + fouls + '\'' + 
			",cards = '" + cards + '\'' + 
			",dribbles = '" + dribbles + '\'' + 
			",penalty = '" + penalty + '\'' + 
			",rating = '" + rating + '\'' + 
			",updateAt = '" + updateAt + '\'' + 
			",team_id = '" + teamId + '\'' + 
			",captain = '" + captain + '\'' + 
			",duels = '" + duels + '\'' + 
			",team_name = '" + teamName + '\'' + 
			",substitute = '" + substitute + '\'' + 
			",number = '" + number + '\'' + 
			",event_id = '" + eventId + '\'' + 
			",player_id = '" + playerId + '\'' + 
			",passes = '" + passes + '\'' + 
			",minutes_played = '" + minutesPlayed + '\'' + 
			",player_name = '" + playerName + '\'' + 
			",position = '" + position + '\'' + 
			",tackles = '" + tackles + '\'' + 
			",shots = '" + shots + '\'' + 
			",offsides = '" + offsides + '\'' + 
			",goals = '" + goals + '\'' + 
			"}";
		}

}