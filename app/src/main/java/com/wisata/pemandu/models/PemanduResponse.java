package com.wisata.pemandu.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PemanduResponse{

	@SerializedName("data")
	private List<DataItemPemandu> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemPemandu> data){
		this.data = data;
	}

	public List<DataItemPemandu> getData(){
		return data;
	}

	public void setSuccess(boolean success){
		this.success = success;
	}

	public boolean isSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"PemanduResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}