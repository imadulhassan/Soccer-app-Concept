package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Duels implements Serializable {

	@SerializedName("total")
	private int total;

	@SerializedName("won")
	private int won;


	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setWon(int won){
		this.won = won;
	}

	public int getWon(){
		return won;
	}

	@Override
 	public String toString(){
		return 
			"Duels{" + 
			"total = '" + total + '\'' + 
			",won = '" + won + '\'' + 
			"}";
		}
}