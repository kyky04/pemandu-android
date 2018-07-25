package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WisatawanResponse {

	@SerializedName("wisatawan")
	private DataItemWisatawan dataItemWisatawan;

	@SerializedName("status")
	private boolean status;

	public DataItemWisatawan getDataItemWisatawan() {
		return dataItemWisatawan;
	}

	public void setDataItemWisatawan(DataItemWisatawan dataItemWisatawan) {
		this.dataItemWisatawan = dataItemWisatawan;
	}

	public boolean getStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}


//
//	public void setData(List<DataItemWisatawan> data){
//		this.data = data;
//	}
//
//	public List<DataItemWisatawan> getData(){
//		return data;
//	}
//
//	public void setSuccess(boolean success){
//		this.success = success;
//	}
//
//	public boolean isSuccess(){
//		return success;
//	}
//
//	public void setMessage(String message){
//		this.message = message;
//	}
//
//	public String getMessage(){
//		return message;
//	}

//	@Override
// 	public String toString(){
//		return
//			"WisatawanResponse{" +
//			"data = '" + data + '\'' +
//			",success = '" + success + '\'' +
//			",message = '" + message + '\'' +
//			"}";
//		}

	@Override
	public String toString(){
		return
				"WisatawanResponse{" +
						"siswa = '" + dataItemWisatawan + '\'' +
						",status = '" + status + '\'' +
						"}";
	}
}