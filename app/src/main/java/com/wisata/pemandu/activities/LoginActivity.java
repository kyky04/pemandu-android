package com.wisata.pemandu.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.wisata.pemandu.MainActivity;
import com.wisata.pemandu.R;
import com.wisata.pemandu.models.WisatawanResponse;
import com.wisata.pemandu.utils.CommonUtil;
import com.wisata.pemandu.utils.Session;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wisata.pemandu.data.Constans.WISATAWAN;

public class LoginActivity extends AppCompatActivity {

    @BindView( R.id.tv_Username )
    TextView email;
    @BindView( R.id.tv_Password )
    TextView password;
    @BindView( R.id.btn_Login )
    Button btnLogin;
    @BindView( R.id.btn_Register )
    Button btnRegister;
    private ProgressDialog progressDialog;
    
    Session session;

//    List<DataItemWisatawan> itemBahasaList = new ArrayList<>();

//    private FastAdapter<DataItemWisatawan> fastItemAdapter;

//    WisatawanAdapter bahasaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_login );

//        AndroidNetworking.initialize( getApplicationContext());
        ButterKnife.bind( this );
        session = new Session( this );
        
        if (session.isLoggedIn()){
            goToMain();
        }

//        btnLogin.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String semail = email.getText().toString().trim();
//                String spassword = password.getText().toString().trim();
////                loging( semail, spassword );
//            }
//        } );

//        btnLogin.setOnClickListener( new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {

//                String semail = tvUsername.getText().toString().trim();
//                String spassword = tvPassword.getText().toString().trim();
//
//                Toast.makeText( LoginActivity.this, "email :" + semail, Toast.LENGTH_SHORT ).show();
//                Toast.makeText( LoginActivity.this, "password :" + spassword, Toast.LENGTH_SHORT ).show();

//                JSONObject jsonObject = new JSONObject();
//                try {
//                    jsonObject.put("email", semail);
//                    jsonObject.put("password", spassword);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//                AndroidNetworking.post( WISATAWAN )
//                        .addBodyParameter( "email", semail )
//                        .addBodyParameter( "password", spassword )
////                        .addJSONObjectBody( jsonObject )
//                        .setTag( "login" )
//                        .setPriority( Priority.HIGH )
//                        .build()
//                        .getAsJSONObject( new JSONObjectRequestListener() {
//                            @Override
//                            public void onResponse(JSONObject response) {
//                                Toast.makeText( LoginActivity.this, "berhasil login", Toast.LENGTH_SHORT ).show();
////                                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
//                                Intent gomain = new Intent( LoginActivity.this, MainActivity.class ).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
//                                startActivity( gomain );
//                                finish();
//                            }
//
//                            @Override
//                            public void onError(ANError anError) {
//                                Toast.makeText( LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT ).show();
//                            }
//                        } );
//            }
//        } );
//
//
//
    }

    private void goToMain() {
        // user is not logged in redirect him to Login Aktifitas
        Intent i = new Intent(this, MainActivity.class);
        // Closing all the Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Add new Flag to start new Aktifitas
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Staring Login Aktifitas
        startActivity(i);
        finish();

    }

    @OnClick({R.id.btn_Login, R.id.btn_Register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Login:
                if(!email.getText().toString().equals("") || !password.getText().toString().equals("")){
                    loging(email.getText().toString(), password.getText().toString());
                }
                break;
            case R.id.btn_Register:
//                Toast.makeText( this, "register mang", Toast.LENGTH_SHORT ).show();
                startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
                break;
        }
//    }

//    void loging(String email, String password) {
//
//        }


    }

    void loging(String email, String password) {
        openDialog();
        AndroidNetworking.post( WISATAWAN )
                .addBodyParameter( "email", email )
//                .addBodyParameter( "email", email )
                .addBodyParameter( "password", password )
//                .addBodyParameter( "password", password )
                .build()
                .getAsObject(WisatawanResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        closeDialog();
                        if (response instanceof WisatawanResponse) {
                            if (((WisatawanResponse) response).getStatus()) {
                                CommonUtil.showToast( LoginActivity.this, "Login Berhasil" );
                                session.setId( ((WisatawanResponse)response).getDataItemWisatawan().getId() );
                                session.setFullname( ((WisatawanResponse)response).getDataItemWisatawan().getFullname());
                                session.setEmail( ((WisatawanResponse)response).getDataItemWisatawan().getEmail() );
                                session.setJenisKelamin( ((WisatawanResponse)response).getDataItemWisatawan().getJenisKelamin());
                                session.setNegara( ((WisatawanResponse)response).getDataItemWisatawan().getNegara());
                                session.setNomorTlp( ((WisatawanResponse)response).getDataItemWisatawan().getNomorTlp() );
                                session.setIsLogin( true );
                                goToMain();
//                                Toast.makeText( LoginActivity.this, "LOGIN BERHASIL", Toast.LENGTH_SHORT ).show();
//                                Intent gomain = new Intent( LoginActivity.this, MainActivity.class ).addFlags( Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK );
//                                startActivity( gomain );
                            } else {
                                Toast.makeText( LoginActivity.this, "LOGIN GAGAL", Toast.LENGTH_SHORT ).show();
//                                        CommonUtil.showToast( LoginActivity.this, ((WisatawanResponse) response).getStatus() );
                            }
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        closeDialog();
                        Toast.makeText( LoginActivity.this, "Gagal mang"+anError.getErrorDetail(), Toast.LENGTH_SHORT ).show();
                    }
                } );
    }
    public void openDialog() {
        progressDialog = ProgressDialog.show(this, "Loading .. ", "");
        progressDialog.setCancelable(false);
    }

    public void closeDialog() {
        progressDialog.dismiss();
    }

}


