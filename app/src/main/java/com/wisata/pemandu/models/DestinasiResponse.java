package com.wisata.pemandu.models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DestinasiResponse{

	@SerializedName("data")
	private List<DataItemDestinasi> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemDestinasi> data){
		this.data = data;
	}

	public List<DataItemDestinasi> getData(){
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
			"DestinasiResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}