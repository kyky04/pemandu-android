package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

public class DataItemPemanduBahasa {
    @SerializedName( "pemandu" )
    private DataItemPemandu pemandu;
    @SerializedName( "bahasa" )
    private DataItemBahasa bahasa;
    @SerializedName( "id" )
    Integer id;
    @SerializedName( "id_pemanduB" )
    Integer idPemandu;
    @SerializedName( "id_bahasa" )
    Integer idBahasa;
    @SerializedName("updated_at")
    private String updatedAt;
    @SerializedName("created_at")
    private String createdAt;
    @SerializedName("deleted_at")
    private Object deletedAt;

    public DataItemPemandu getPemandu() {
        return pemandu;
    }

    public DataItemPemanduBahasa setPemandu(DataItemPemandu pemandu) {
        this.pemandu = pemandu;
        return this;
    }

    public DataItemBahasa getBahasa() {
        return bahasa;
    }

    public DataItemPemanduBahasa setBahasa(DataItemBahasa bahasa) {
        this.bahasa = bahasa;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public DataItemPemanduBahasa setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getIdPemandu() {
        return idPemandu;
    }

    public DataItemPemanduBahasa setIdPemandu(Integer idPemandu) {
        this.idPemandu = idPemandu;
        return this;
    }

    public Integer getIdBahasa() {
        return idBahasa;
    }

    public DataItemPemanduBahasa setIdBahasa(Integer idBahasa) {
        this.idBahasa = idBahasa;
        return this;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public DataItemPemanduBahasa setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public DataItemPemanduBahasa setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public DataItemPemanduBahasa setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
        return this;
    }

    @Override
    public String toString() {
        return "DataItemPemanduBahasa{" +
                "pemandu=" + pemandu +
                ", bahasa=" + bahasa +
                ", id=" + id +
                ", idPemandu=" + idPemandu +
                ", idBahasa=" + idBahasa +
                ", updatedAt='" + updatedAt + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", deletedAt=" + deletedAt +
                '}';
    }
}
