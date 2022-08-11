package com.soccer.pojo.coaches;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class CoachsItem{

	@SerializedName("firstname")
	private String firstname;

	@SerializedName("career")
	private List<CareerItem> career;

	@SerializedName("birth_date")
	private String birthDate;

	@SerializedName("birth_place")
	private String birthPlace;

	@SerializedName("weight")
	private Object weight;

	@SerializedName("team")
	private Team team;

	@SerializedName("birth_country")
	private String birthCountry;

	@SerializedName("lastname")
	private String lastname;

	@SerializedName("nationality")
	private String nationality;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	@SerializedName("age")
	private int age;

	@SerializedName("height")
	private Object height;

	public void setFirstname(String firstname){
		this.firstname = firstname;
	}

	public String getFirstname(){
		return firstname;
	}

	public void setCareer(List<CareerItem> career){
		this.career = career;
	}

	public List<CareerItem> getCareer(){
		return career;
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

	public void setWeight(Object weight){
		this.weight = weight;
	}

	public Object getWeight(){
		return weight;
	}

	public void setTeam(Team team){
		this.team = team;
	}

	public Team getTeam(){
		return team;
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

	public void setNationality(String nationality){
		this.nationality = nationality;
	}

	public String getNationality(){
		return nationality;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setHeight(Object height){
		this.height = height;
	}

	public Object getHeight(){
		return height;
	}

	@Override
 	public String toString(){
		return 
			"CoachsItem{" + 
			"firstname = '" + firstname + '\'' + 
			",career = '" + career + '\'' + 
			",birth_date = '" + birthDate + '\'' + 
			",birth_place = '" + birthPlace + '\'' + 
			",weight = '" + weight + '\'' + 
			",team = '" + team + '\'' + 
			",birth_country = '" + birthCountry + '\'' + 
			",lastname = '" + lastname + '\'' + 
			",nationality = '" + nationality + '\'' + 
			",name = '" + name + '\'' + 
			",id = '" + id + '\'' + 
			",age = '" + age + '\'' + 
			",height = '" + height + '\'' + 
			"}";
		}
}