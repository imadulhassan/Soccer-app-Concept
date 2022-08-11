package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Goals implements Serializable {

	@SerializedName("conceded")
	private int conceded;

	@SerializedName("total")
	private int total;

	@SerializedName("assists")
	private int assists;


	public void setConceded(int conceded){
		this.conceded = conceded;
	}

	public int getConceded(){
		return conceded;
	}

	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setAssists(int assists){
		this.assists = assists;
	}

	public int getAssists(){
		return assists;
	}

	@Override
 	public String toString(){
		return 
			"Goals{" + 
			"conceded = '" + conceded + '\'' + 
			",total = '" + total + '\'' + 
			",assists = '" + assists + '\'' + 
			"}";
		}

}