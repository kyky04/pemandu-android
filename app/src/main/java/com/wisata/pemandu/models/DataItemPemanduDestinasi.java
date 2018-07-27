package com.wisata.pemandu.models;

import android.content.Intent;

import com.google.gson.annotations.SerializedName;

public class DataItemPemanduDestinasi {
    @SerializedName( "id" )
    private int id;
    @SerializedName( "id_destinasi" )
    private int idDestinasi;
    @SerializedName( "id_pemandu" )
    private int idPemandu;
    @SerializedName( "destinasi" )
    private DataItemDestinasi destinasi;
    @SerializedName( "pemandu" )
    private DataItemPemandu pemandu;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("deleted_at")
    private Object deletedAt;

    public int getId() {
        return id;
    }

    public DataItemPemanduDestinasi setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdDestinasi() {
        return idDestinasi;
    }

    public DataItemPemanduDestinasi setIdDestinasi(int idDestinasi) {
        this.idDestinasi = idDestinasi;
        return this;
    }

    public int getIdPemandu() {
        return idPemandu;
    }

    public DataItemPemanduDestinasi setIdPemandu(int idPemandu) {
        this.idPemandu = idPemandu;
        return this;
    }

    public DataItemDestinasi getDestinasi() {
        return destinasi;
    }

    public DataItemPemanduDestinasi setDestinasi(DataItemDestinasi destinasi) {
        this.destinasi = destinasi;
        return this;
    }

    public DataItemPemandu getPemandu() {
        return pemandu;
    }

    public DataItemPemanduDestinasi setPemandu(DataItemPemandu pemandu) {
        this.pemandu = pemandu;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public DataItemPemanduDestinasi setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public DataItemPemanduDestinasi setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public DataItemPemanduDestinasi setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    @Override
    public String toString() {
        return "DataItemPemanduDestinasi{" +
                "id=" + id +
                ", idDestinasi=" + idDestinasi +
                ", idPemandu=" + idPemandu +
                ", destinasi=" + destinasi +
                ", pemandu=" + pemandu +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
