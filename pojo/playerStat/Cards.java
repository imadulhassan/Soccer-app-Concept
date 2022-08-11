package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Cards implements Serializable {

	@SerializedName("red")
	private int red;

	@SerializedName("yellow")
	private int yellow;
	public void setRed(int red){
		this.red = red;
	}

	public int getRed(){
		return red;
	}

	public void setYellow(int yellow){
		this.yellow = yellow;
	}

	public int getYellow(){
		return yellow;
	}

	@Override
 	public String toString(){
		return 
			"Cards{" + 
			"red = '" + red + '\'' + 
			",yellow = '" + yellow + '\'' + 
			"}";
		}

}