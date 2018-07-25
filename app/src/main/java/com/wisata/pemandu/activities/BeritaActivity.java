package com.wisata.pemandu.activities;

import android.provider.ContactsContract;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.wisata.pemandu.R;
import com.wisata.pemandu.adapters.BeritaAdapter;
import com.wisata.pemandu.models.BeritaResponse;
import com.wisata.pemandu.models.DataItemBerita;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wisata.pemandu.data.Constans.BERITA;

public class BeritaActivity extends AppCompatActivity {
    private static final String TAG = "BeritaActivity";

    @BindView( R.id.recyler )
    RecyclerView recycler;
    @BindView( R.id.refresh )
    SwipeRefreshLayout refresh;

    List<DataItemBerita> itemBeritasList = new ArrayList<>();

    BeritaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_berita );

        ButterKnife.bind( this );

        adapter = new BeritaAdapter( this );
        recycler.setLayoutManager( new LinearLayoutManager( this ) );
        recycler.setAdapter( adapter );

        loadBerita();
    }

    private void loadBerita() {
        refresh.setRefreshing( true );
        AndroidNetworking.get( BERITA )
                .build()
                .getAsObject( BeritaResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        refresh.setRefreshing( false );
                        if (response instanceof BeritaResponse) {
                            adapter.swap( ((BeritaResponse) response).getData() );
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        refresh.setRefreshing( false );
                        Log.d(TAG, "onError" + anError.getErrorDetail());
                    }
                } );
    }

    public List<DataItemBerita> getAllData(List<DataItemBerita> DataItemBeritaList) {
        List<DataItemBerita> list = new ArrayList<>();
        for (int i = 0; i < DataItemBeritaList.size(); i++) {
            list.add(DataItemBeritaList.get(i));
        }
        return list;
    }

}
