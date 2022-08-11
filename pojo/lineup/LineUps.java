package com.soccer.pojo.lineup;


import com.google.gson.annotations.SerializedName;


public class LineUps{

	@SerializedName("Arsenal")
	private Arsenal arsenal;

	@SerializedName("Manchester United")
	private ManchesterUnited manchesterUnited;

	public void setArsenal(Arsenal arsenal){
		this.arsenal = arsenal;
	}

	public Arsenal getArsenal(){
		return arsenal;
	}

	public void setManchesterUnited(ManchesterUnited manchesterUnited){
		this.manchesterUnited = manchesterUnited;
	}

	public ManchesterUnited getManchesterUnited(){
		return manchesterUnited;
	}

	@Override
 	public String toString(){
		return 
			"LineUps{" + 
			"arsenal = '" + arsenal + '\'' + 
			",manchester United = '" + manchesterUnited + '\'' + 
			"}";
		}
}