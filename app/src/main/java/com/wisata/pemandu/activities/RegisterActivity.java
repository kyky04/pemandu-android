package com.wisata.pemandu.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.wisata.pemandu.R;
import com.wisata.pemandu.utils.CommonUtil;

import org.json.JSONObject;

import java.sql.Date;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wisata.pemandu.data.Constans.REGISTER_WISATAWAN;

public class RegisterActivity extends AppCompatActivity {
    @BindView( R.id.et_fullname )
    EditText fullname;
    @BindView( R.id.et_email )
    EditText email;
    @BindView( R.id.et_Negara )
    EditText negara;
    @BindView( R.id.et_password )
    EditText password;
    @BindView( R.id.et_jenis_kelamin )
    EditText jenis_kelamin;
    @BindView( R.id.et_nomor_tlp )
    EditText nmr_tlp;
    @BindView( R.id.dt_tgl_lahir )
    EditText tgl_lahir;
    @BindView( R.id.btn_Register )
    Button btnRegister;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_register );
        ButterKnife.bind( this );

    }

    @OnClick({R.id.btn_Register})
    public void onViewClicked(View view){
        switch (view.getId()){
            case R.id.btn_Register:
                register(fullname.getText().toString(),email.getText().toString(),negara.getText().toString(), jenis_kelamin.getText().toString(),nmr_tlp.getText().toString()
                        ,tgl_lahir.getText().toString(),password.getText().toString());
        }

    }

    private void register(String fullname, String email, String negara, String jenis_kelamin, String nomor_tlp, String tanggal_lahir, String password) {
        openDialog();
        AndroidNetworking.post( REGISTER_WISATAWAN )
                .addBodyParameter( "fullname", fullname )
                .addBodyParameter( "email", email )
                .addBodyParameter( "negara", negara )
                .addBodyParameter( "jenis_kelamin", jenis_kelamin )
                .addBodyParameter( "tanggal_lahir", tanggal_lahir )
                .addBodyParameter( "nomor_tlp", nomor_tlp )
                .addBodyParameter( "password", password )
                .build()
                .getAsJSONObject( new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        closeDialog();
                        CommonUtil.showToast( RegisterActivity.this, "Berhasil Daftar" );
                        Intent intent = new Intent( RegisterActivity.this, LoginActivity.class );
                        startActivity( intent );
                        finish();
                    }

                    @Override
                    public void onError(ANError anError) {
                        closeDialog();
                        CommonUtil.showToast( RegisterActivity.this, "Gagal Mang" + anError.getErrorDetail() );
                    }
                } );

    }
//
//    public String getFullname() {
//        return fullname.getText().toString();
//    }
//
//    public String getEmail() {
//        return email.getText().toString();
//    }
//
//    public String getNegara() {
//        return negara.getText().toString();
//    }
//
//    public String getPassword() {
//        return password.getText().toString();
//    }
//
//    public String getJenis_kelamin() {
//        return jenis_kelamin.getText().toString();
//    }
//
//    public String getNmr_tlp() {
//        return nmr_tlp.getText().toString();
//    }
//
//    public String getDate() {
//        return date.getText().toString();
//    }

    public void openDialog() {
        progressDialog = ProgressDialog.show(this, "Loading .. ", "");
        progressDialog.setCancelable(false);
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }

}
