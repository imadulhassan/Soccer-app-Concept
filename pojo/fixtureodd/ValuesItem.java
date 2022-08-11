package com.soccer.pojo.fixtureodd;


import com.google.gson.annotations.SerializedName;


public class ValuesItem{

	@SerializedName("value")
	private String value;

	@SerializedName("odd")
	private String odd;

	public void setValue(String value){
		this.value = value;
	}

	public String getValue(){
		return value;
	}

	public void setOdd(String odd){
		this.odd = odd;
	}

	public String getOdd(){
		return odd;
	}

	@Override
 	public String toString(){
		return 
			"ValuesItem{" + 
			"value = '" + value + '\'' + 
			",odd = '" + odd + '\'' + 
			"}";
		}
}