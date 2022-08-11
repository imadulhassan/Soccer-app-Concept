package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Dribbles implements Serializable {

	@SerializedName("success")
	private int success;

	@SerializedName("past")
	private int past;

	@SerializedName("attempts")
	private int attempts;

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setPast(int past){
		this.past = past;
	}

	public int getPast(){
		return past;
	}

	public void setAttempts(int attempts){
		this.attempts = attempts;
	}

	public int getAttempts(){
		return attempts;
	}

	@Override
 	public String toString(){
		return 
			"Dribbles{" + 
			"success = '" + success + '\'' + 
			",past = '" + past + '\'' + 
			",attempts = '" + attempts + '\'' + 
			"}";
		}
}