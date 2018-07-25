package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

public class DataItemBerita {
    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("deleted_at")
    private String deletedAt;

    @SerializedName("judul")
    private String judul;

    @SerializedName("isi")
    private String isi;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @SerializedName("id")
    private String id;

    public String getUpdatedAt() {
        return updatedAt;
    }



    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(String deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    @Override
    public String toString(){
        return
                "DataItemPemandu{" +
                        "judul = '" + judul + '\'' +
                        ",isi = '" + isi + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",deleted_at = '" + deletedAt + '\'' +
                        "}";
    }
}
