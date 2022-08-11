package com.soccer.pojo.lineup;

import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Arsenal{

	@SerializedName("coach_id")
	private int coachId;

	@SerializedName("substitutes")
	private List<SubstitutesItem> substitutes;

	@SerializedName("startXI")
	private List<StartXIItem> startXI;

	@SerializedName("formation")
	private String formation;

	@SerializedName("coach")
	private String coach;

	public void setCoachId(int coachId){
		this.coachId = coachId;
	}

	public int getCoachId(){
		return coachId;
	}

	public void setSubstitutes(List<SubstitutesItem> substitutes){
		this.substitutes = substitutes;
	}

	public List<SubstitutesItem> getSubstitutes(){
		return substitutes;
	}

	public void setStartXI(List<StartXIItem> startXI){
		this.startXI = startXI;
	}

	public List<StartXIItem> getStartXI(){
		return startXI;
	}

	public void setFormation(String formation){
		this.formation = formation;
	}

	public String getFormation(){
		return formation;
	}

	public void setCoach(String coach){
		this.coach = coach;
	}

	public String getCoach(){
		return coach;
	}

	@Override
 	public String toString(){
		return 
			"Arsenal{" + 
			"coach_id = '" + coachId + '\'' + 
			",substitutes = '" + substitutes + '\'' + 
			",startXI = '" + startXI + '\'' + 
			",formation = '" + formation + '\'' + 
			",coach = '" + coach + '\'' + 
			"}";
		}
}