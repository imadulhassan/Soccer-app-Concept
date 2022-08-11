package com.soccer.pojo.prediction;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Api{

	@SerializedName("results")
	private int results;

	@SerializedName("predictions")
	private List<PredictionsItem> predictions;

	public void setResults(int results){
		this.results = results;
	}

	public int getResults(){
		return results;
	}

	public void setPredictions(List<PredictionsItem> predictions){
		this.predictions = predictions;
	}

	public List<PredictionsItem> getPredictions(){
		return predictions;
	}

	@Override
 	public String toString(){
		return 
			"Api{" + 
			"results = '" + results + '\'' + 
			",predictions = '" + predictions + '\'' + 
			"}";
		}
}