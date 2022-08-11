package com.soccer.pojo.prediction;


import com.google.gson.annotations.SerializedName;


public class Comparison{

	@SerializedName("forme")
	private Forme forme;

	@SerializedName("att")
	private Att att;

	@SerializedName("fish_law")
	private FishLaw fishLaw;

	@SerializedName("def")
	private Def def;

	@SerializedName("goals_h2h")
	private GoalsH2h goalsH2h;

	@SerializedName("h2h")
	private H2h h2h;

	public void setForme(Forme forme){
		this.forme = forme;
	}

	public Forme getForme(){
		return forme;
	}

	public void setAtt(Att att){
		this.att = att;
	}

	public Att getAtt(){
		return att;
	}

	public void setFishLaw(FishLaw fishLaw){
		this.fishLaw = fishLaw;
	}

	public FishLaw getFishLaw(){
		return fishLaw;
	}

	public void setDef(Def def){
		this.def = def;
	}

	public Def getDef(){
		return def;
	}

	public void setGoalsH2h(GoalsH2h goalsH2h){
		this.goalsH2h = goalsH2h;
	}

	public GoalsH2h getGoalsH2h(){
		return goalsH2h;
	}

	public void setH2h(H2h h2h){
		this.h2h = h2h;
	}

	public H2h getH2h(){
		return h2h;
	}

	@Override
 	public String toString(){
		return 
			"Comparison{" + 
			"forme = '" + forme + '\'' + 
			",att = '" + att + '\'' + 
			",fish_law = '" + fishLaw + '\'' + 
			",def = '" + def + '\'' + 
			",goals_h2h = '" + goalsH2h + '\'' + 
			",h2h = '" + h2h + '\'' + 
			"}";
		}
}