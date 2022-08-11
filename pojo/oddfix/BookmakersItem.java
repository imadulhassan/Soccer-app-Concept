package com.soccer.pojo.oddfix;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class BookmakersItem{

	@SerializedName("bookmaker_id")
	private int bookmakerId;

	@SerializedName("bets")
	private ArrayList<BetsItem> bets;

	@SerializedName("bookmaker_name")
	private String bookmakerName;

	public void setBookmakerId(int bookmakerId){
		this.bookmakerId = bookmakerId;
	}

	public int getBookmakerId(){
		return bookmakerId;
	}

	public void setBets(ArrayList<BetsItem> bets){
		this.bets = bets;
	}

	public ArrayList<BetsItem> getBets(){
		return bets;
	}

	public void setBookmakerName(String bookmakerName){
		this.bookmakerName = bookmakerName;
	}

	public String getBookmakerName(){
		return bookmakerName;
	}

	@Override
 	public String toString(){
		return 
			"BookmakersItem{" + 
			"bookmaker_id = '" + bookmakerId + '\'' + 
			",bets = '" + bets + '\'' + 
			",bookmaker_name = '" + bookmakerName + '\'' + 
			"}";
		}
}