package com.soccer.pojo.oddfix;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
public class BetsItem implements Serializable {

	@SerializedName("values")
	private ArrayList<ValuesItem> values;

	@SerializedName("label_name")
	private String labelName;

	@SerializedName("label_id")
	private int labelId;

	public void setValues(ArrayList<ValuesItem> values){
		this.values = values;
	}

	public ArrayList<ValuesItem> getValues(){
		return values;
	}

	public void setLabelName(String labelName){
		this.labelName = labelName;
	}

	public String getLabelName(){
		return labelName;
	}

	public void setLabelId(int labelId){
		this.labelId = labelId;
	}

	public int getLabelId(){
		return labelId;
	}

	@Override
 	public String toString(){
		return 
			"BetsItem{" + 
			"values = '" + values + '\'' + 
			",label_name = '" + labelName + '\'' + 
			",label_id = '" + labelId + '\'' + 
			"}";
		}
}