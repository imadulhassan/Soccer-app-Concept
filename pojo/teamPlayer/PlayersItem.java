package com.soccer.pojo.teamPlayer;


import com.google.gson.annotations.SerializedName;


public class PlayersItem{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("birth_date")
	private String birthDate;

	@SerializedName("birth_place")
	private String birthPlace;

	@SerializedName("weight")
	private String weight;

	@SerializedName("birth_country")
	private String birthCountry;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("number")
	private Object number;

	@SerializedName("player_id")
	private int playerId;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("player_name")
	private String playerName;

	@SerializedName("position")
	private String position;

	@SerializedName("age")
	private int age;

	@SerializedName("height")
	private String height;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setBirthDate(String birthDate){
		this.birthDate = birthDate;
	}

	public String getBirthDate(){
		return birthDate;
	}

	public void setBirthPlace(String birthPlace){
		this.birthPlace = birthPlace;
	}

	public String getBirthPlace(){
		return birthPlace;
	}

	public void setWeight(String weight){
		this.weight = weight;
	}

	public String getWeight(){
		return weight;
	}

	public void setBirthCountry(String birthCountry){
		this.birthCountry = birthCountry;
	}

	public String getBirthCountry(){
		return birthCountry;
	}

	public void setLastname(String lastname){
		this.lastname = lastname;
	}

	public String getLastname(){
		return lastname;
	}

	public void setNumber(Object number){
		this.number = number;
	}

	public Object getNumber(){
		return number;
	}

	public void setPlayerId(int playerId){
		this.playerId = playerId;
	}

	public int getPlayerId(){
		return playerId;
	}

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
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

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setHeight(String height){
		this.height = height;
	}

	public String getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"PlayersItem{" + 
			"firstname = '" + firstname + '\'' + 
			",birth_date = '" + birthDate + '\'' + 
			",birth_place = '" + birthPlace + '\'' + 
			",weight = '" + weight + '\'' + 
			",birth_country = '" + birthCountry + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",number = '" + number + '\'' + 
			",player_id = '" + playerId + '\'' + 
			",nationality = '" + nationality + '\'' + 
			",player_name = '" + playerName + '\'' + 
			",position = '" + position + '\'' + 
			",age = '" + age + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}