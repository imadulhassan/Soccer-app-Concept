package com.soccer.pojo.playerStat;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Passes implements Serializable {

	@SerializedName("total")
	private int total;

	@SerializedName("accuracy")
	private int accuracy;

	@SerializedName("key")
	private int key;

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setAccuracy(int accuracy){
		this.accuracy = accuracy;
	}

	public int getAccuracy(){
		return accuracy;
	}

	public void setKey(int key){
		this.key = key;
	}

	public int getKey(){
		return key;
	}

	@Override
 	public String toString(){
		return 
			"Passes{" + 
			"total = '" + total + '\'' + 
			",accuracy = '" + accuracy + '\'' + 
			",key = '" + key + '\'' + 
			"}";
		}
}