package com.wisata.pemandu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.wisata.pemandu.activities.BeritaActivity;
import com.wisata.pemandu.activities.DestinasiActivity;
import com.wisata.pemandu.activities.InfoDestinasiActivity;
import com.wisata.pemandu.activities.LocationServiceActivity;
import com.wisata.pemandu.activities.PencarianBahasaActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_pencarian)
    LinearLayout btnPencarian;
    @BindView(R.id.btn_destinasi)
    LinearLayout btnDestinasi;
    @BindView(R.id.btn_pemandu)
    LinearLayout btnPemandu;
    @BindView(R.id.btn_berita)
    LinearLayout btnBerita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_pencarian, R.id.btn_destinasi, R.id.btn_pemandu, R.id.btn_berita})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pencarian:
                startActivity(new Intent(this, PencarianBahasaActivity.class));
                break;
            case R.id.btn_destinasi:
                startActivity(new Intent(this, InfoDestinasiActivity.class));
                break;
            case R.id.btn_pemandu:
                startActivity(new Intent(this, DestinasiActivity.class));
                break;
            case R.id.btn_berita:
                startActivity(new Intent(this, LocationServiceActivity.class));
                break;
        }
    }
}
