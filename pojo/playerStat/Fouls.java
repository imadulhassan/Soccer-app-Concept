package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Fouls implements Serializable {

	@SerializedName("committed")
	private int committed;

	@SerializedName("drawn")
	private int drawn;

	public void setCommitted(int committed){
		this.committed = committed;
	}

	public int getCommitted(){
		return committed;
	}

	public void setDrawn(int drawn){
		this.drawn = drawn;
	}

	public int getDrawn(){
		return drawn;
	}

	@Override
 	public String toString(){
		return 
			"Fouls{" + 
			"committed = '" + committed + '\'' + 
			",drawn = '" + drawn + '\'' + 
			"}";
		}

}