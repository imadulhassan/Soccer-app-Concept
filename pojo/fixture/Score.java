package com.soccer.pojo.fixture;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Score implements Serializable {

	@SerializedName("halftime")
	private String halftime;

	@SerializedName("penalty")
	private Object penalty;

	@SerializedName("fulltime")
	private String fulltime;

	@SerializedName("extratime")
	private Object extratime;

	public void setHalftime(String halftime){
		this.halftime = halftime;
	}

	public String getHalftime(){
		return halftime;
	}

	public void setPenalty(Object penalty){
		this.penalty = penalty;
	}

	public Object getPenalty(){
		return penalty;
	}

	public void setFulltime(String fulltime){
		this.fulltime = fulltime;
	}

	public String getFulltime(){
		return fulltime;
	}

	public void setExtratime(Object extratime){
		this.extratime = extratime;
	}

	public Object getExtratime(){
		return extratime;
	}

	@Override
 	public String toString(){
		return 
			"Score{" + 
			"halftime = '" + halftime + '\'' + 
			",penalty = '" + penalty + '\'' + 
			",fulltime = '" + fulltime + '\'' + 
			",extratime = '" + extratime + '\'' + 
			"}";
		}
}