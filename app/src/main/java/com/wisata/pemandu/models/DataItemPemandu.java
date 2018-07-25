package com.wisata.pemandu.models;

import com.google.gson.annotations.SerializedName;

public class DataItemPemandu {

    @SerializedName("password")
    private String password;

    @SerializedName("negara")
    private String negara;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("nomor_tlp")
    private String nomorTlp;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("jenis_kelamin")
    private String jenisKelamin;

    @SerializedName("deleted_at")
    private Object deletedAt;

    @SerializedName("email")
    private String email;

    @SerializedName("tanggal_lahir")
    private String tanggalLahir;

    @SerializedName("longitude")
    private double longitude;

    @SerializedName("latitude")
    private double latitude;

    private double distance;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setNegara(String negara) {
        this.negara = negara;
    }

    public String getNegara() {
        return negara;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setNomorTlp(String nomorTlp) {
        this.nomorTlp = nomorTlp;
    }

    public String getNomorTlp() {
        return nomorTlp;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTanggalLahir(String tanggalLahir) {
        this.tanggalLahir = tanggalLahir;
    }

    public String getTanggalLahir() {
        return tanggalLahir;
    }

    @Override
    public String toString() {
        return
                "DataItemPemandu{" +
                        "password = '" + password + '\'' +
                        ",negara = '" + negara + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",nomor_tlp = '" + nomorTlp + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",id = '" + id + '\'' +
                        ",fullname = '" + fullname + '\'' +
                        ",jenis_kelamin = '" + jenisKelamin + '\'' +
                        ",deleted_at = '" + deletedAt + '\'' +
                        ",email = '" + email + '\'' +
                        ",tanggal_lahir = '" + tanggalLahir + '\'' +
                        "}";
    }
}