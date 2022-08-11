package com.soccer.pojo.fixtureodd;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class BookmakersItem{

	@SerializedName("bookmaker_id")
	private int bookmakerId;

	@SerializedName("bets")
	private List<BetsItem> bets;

	@SerializedName("bookmaker_name")
	private String bookmakerName;

	public void setBookmakerId(int bookmakerId){
		this.bookmakerId = bookmakerId;
	}

	public int getBookmakerId(){
		return bookmakerId;
	}

	public void setBets(List<BetsItem> bets){
		this.bets = bets;
	}

	public List<BetsItem> getBets(){
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