package com.wisata.pemandu.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.wisata.pemandu.MainActivity;
import com.wisata.pemandu.activities.LoginActivity;

import java.util.HashMap;

public class Session {
    SharedPreferences pref;

    SharedPreferences.Editor editor;

    Context _context;

    int PRIVETE_MODE = 0;

    private static final String PREF_NAME = "wisatawan";

    private static final String IS_LOGIN = "IsLoged";

    private static final String KEY_ID = "id";

    public static final String KEY_FULLNAME = "fullname";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_NEGARA = "negara";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_JENIS_KELAMIN = "jenis_kelamin";
    public static final String KEY_TANGGAL_LAHIR = "tanggal_lahir";
    public static final String KEY_NOMOR_TLP = "nomor_tlp";

    //Constructor
    public Session(Context context){
        this._context = context;
        pref = _context.getSharedPreferences( PREF_NAME, PRIVETE_MODE );
        editor = pref.edit();
    }




    /**
     * Session Login
     */
    public void createLogginSession (Integer id, String fullname, String email, String negara, String password, String jenis_kelamin, String tanggal_lahir, String nomor_tlp){
        editor.putBoolean( IS_LOGIN, true );
        editor.putString( KEY_FULLNAME, fullname );
        editor.putString( KEY_EMAIL, email );
        editor.putString( KEY_NOMOR_TLP, nomor_tlp );
        editor.putString( KEY_JENIS_KELAMIN, jenis_kelamin );
        editor.putString( KEY_TANGGAL_LAHIR, tanggal_lahir );
        editor.putInt( KEY_ID, id );

        //commit changes;
        editor.commit();
    }

    /**
     * Check login method wil check user login status
     * If false it will redirect user to login page
     * Else won't do anything
     */
    public void checkLogin(){
        if (isLoggedIn()) {
            Intent i = new Intent( _context, MainActivity.class );

            i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );

            i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );

            _context.startActivity( i );
        }
    }

    public void logoutUser() {
        editor.clear();
        editor.commit();

        editor.putBoolean( IS_LOGIN, false );

        Intent i = new Intent( _context, LoginActivity.class );

        i.addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP );

        i.setFlags( Intent.FLAG_ACTIVITY_NEW_TASK );

        _context.startActivity( i );
    }

    public HashMap<String,String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put( KEY_ID, pref.getString( KEY_ID, null ) );
        user.put( KEY_FULLNAME, pref.getString( KEY_FULLNAME, null ) );
        user.put( KEY_EMAIL, pref.getString( KEY_EMAIL, null ) );
        return user;
    }



    public  Integer getId() {
        return pref.getInt( KEY_ID, 0 );
    }

    public int getIntID() {
        return Integer.parseInt( pref.getString (KEY_ID, "0") ) ;
    }

    public void setId(Integer v) {
        editor.putInt( KEY_ID, v );
        editor.commit();
    }

    public  String getFullname() {
        return pref.getString( KEY_FULLNAME, null );
    }

    public void setFullname(String v) {
        editor.putString( KEY_FULLNAME, v );
        editor.commit();
    }

    public String getEmail() {
        return pref.getString(KEY_EMAIL, null);
    }

    public void setEmail(String v) {
        editor.putString( KEY_EMAIL, v );
        editor.commit();
    }

    public String getKeyNegara() {
        return pref.getString( KEY_NEGARA, null );
    }

    public void setNegara(String v) {
        editor.putString( KEY_NEGARA, v );
        editor.commit();
    }

    public String getKeyPassword() {
        return pref.getString( KEY_PASSWORD, null );
    }

    public void setPassword(String v) {
        editor.putString( KEY_PASSWORD, v );
        editor.commit();
    }


    public String getKeyJenisKelamin() {
        return pref.getString( KEY_JENIS_KELAMIN, null );
    }

    public void setJenisKelamin(String v) {
        editor.putString( KEY_JENIS_KELAMIN, v );
        editor.commit();
    }

    public String getKeyTanggalLahir() {
        return pref.getString( KEY_TANGGAL_LAHIR, null );
    }

    public void setTanggalLahir(String v) {
        editor.putString( KEY_TANGGAL_LAHIR, v );
        editor.commit();
    }

    public String getKeyNomorTlp() {
        return pref.getString( KEY_NOMOR_TLP, null );
    }

    public void setNomorTlp(String v) {
        editor.putString( KEY_NOMOR_TLP, v );
        editor.commit();
    }

    /**
     * Quick check for login
     **/
    // Get Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }


    public void setIsLogin(Boolean v) {
        editor.putBoolean(IS_LOGIN, v);
        editor.commit();
    }

}
