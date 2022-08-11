package com.soccer.pojo.playerStat;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Tackles implements Serializable {

	@SerializedName("total")
	private int total;

	@SerializedName("blocks")
	private int blocks;

	@SerializedName("interceptions")
	private int interceptions;


	public void setTotal(int total){
		this.total = total;
	}

	public int getTotal(){
		return total;
	}

	public void setBlocks(int blocks){
		this.blocks = blocks;
	}

	public int getBlocks(){
		return blocks;
	}

	public void setInterceptions(int interceptions){
		this.interceptions = interceptions;
	}

	public int getInterceptions(){
		return interceptions;
	}

	@Override
 	public String toString(){
		return 
			"Tackles{" + 
			"total = '" + total + '\'' + 
			",blocks = '" + blocks + '\'' + 
			",interceptions = '" + interceptions + '\'' + 
			"}";
		}
}