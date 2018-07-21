package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BeritaResponse {

	@SerializedName("data")
	private List<DataItemBerita> data;

	@SerializedName("success")
	private boolean success;

	@SerializedName("message")
	private String message;

	public void setData(List<DataItemBerita> data){
		this.data = data;
	}

	public List<DataItemBerita> getData(){
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
			"BeritaResponse{" +
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}