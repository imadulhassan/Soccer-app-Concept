package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class League{

	@SerializedName("country")
	private String country;

	@SerializedName("flag")
	private String flag;

	@SerializedName("name")
	private String name;

	@SerializedName("logo")
	private String logo;

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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLogo(String logo){
		this.logo = logo;
	}

	public String getLogo(){
		return logo;
	}

	@Override
 	public String toString(){
		return 
			"League{" + 
			"country = '" + country + '\'' + 
			",flag = '" + flag + '\'' + 
			",name = '" + name + '\'' + 
			",logo = '" + logo + '\'' + 
			"}";
		}
}