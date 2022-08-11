package com.soccer.pojo.countries;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class CountriesItem implements Serializable {

	@SerializedName("country")
	private String country;

	@SerializedName("code")
	private String code;

	@SerializedName("flag")
	private String flag;

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setCode(String code){
		this.code = code;
	}

	public String getCode(){
		return code;
	}

	public void setFlag(String flag){
		this.flag = flag;
	}

	public String getFlag(){
		return flag;
	}

	@Override
 	public String toString(){
		return 
			"CountriesItem{" + 
			"country = '" + country + '\'' + 
			",code = '" + code + '\'' + 
			",flag = '" + flag + '\'' + 
			"}";
		}
}