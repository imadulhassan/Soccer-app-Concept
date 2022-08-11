package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Penalty implements Serializable {

	@SerializedName("saved")
	private int saved;

	@SerializedName("success")
	private int success;

	@SerializedName("missed")
	private int missed;

	@SerializedName("won")
	private int won;

	@SerializedName("commited")
	private int commited;


	public void setSaved(int saved){
		this.saved = saved;
	}

	public int getSaved(){
		return saved;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMissed(int missed){
		this.missed = missed;
	}

	public int getMissed(){
		return missed;
	}

	public void setWon(int won){
		this.won = won;
	}

	public int getWon(){
		return won;
	}

	public void setCommited(int commited){
		this.commited = commited;
	}

	public int getCommited(){
		return commited;
	}

	@Override
 	public String toString(){
		return 
			"Penalty{" + 
			"saved = '" + saved + '\'' + 
			",success = '" + success + '\'' + 
			",missed = '" + missed + '\'' + 
			",won = '" + won + '\'' + 
			",commited = '" + commited + '\'' + 
			"}";
		}
}