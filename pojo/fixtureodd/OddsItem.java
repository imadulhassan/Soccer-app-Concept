package com.soccer.pojo.fixtureodd;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class OddsItem{

	@SerializedName("fixture")
	private Fixture fixture;

	@SerializedName("bookmakers")
	private List<BookmakersItem> bookmakers;

	public void setFixture(Fixture fixture){
		this.fixture = fixture;
	}

	public Fixture getFixture(){
		return fixture;
	}

	public void setBookmakers(List<BookmakersItem> bookmakers){
		this.bookmakers = bookmakers;
	}

	public List<BookmakersItem> getBookmakers(){
		return bookmakers;
	}

	@Override
 	public String toString(){
		return 
			"OddsItem{" + 
			"fixture = '" + fixture + '\'' + 
			",bookmakers = '" + bookmakers + '\'' + 
			"}";
		}
}