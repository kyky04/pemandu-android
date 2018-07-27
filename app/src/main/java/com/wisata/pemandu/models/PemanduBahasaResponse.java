package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PemanduBahasaResponse {

    @SerializedName("data")
    private List<DataItemPemanduBahasa> data;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private String message;

    public List<DataItemPemanduBahasa> getData() {
        return data;
    }

    public PemanduBahasaResponse setData(List<DataItemPemanduBahasa> data) {
        this.data = data;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public PemanduBahasaResponse setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public PemanduBahasaResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString(){
        return
                "PemanduBahasaResponse{" +
                        "data = '" + data + '\'' +
                        ",success = '" + success + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}
