package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Shots implements Serializable {

	@SerializedName("total")
	private int total;

	@SerializedName("on")
	private int on;



	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setOn(int on){
		this.on = on;
	}

	public int getOn(){
		return on;
	}

	@Override
 	public String toString(){
		return 
			"Shots{" + 
			"total = '" + total + '\'' + 
			",on = '" + on + '\'' + 
			"}";
		}

}