package com.wisata.pemandu.activities;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.wisata.pemandu.R;
import com.wisata.pemandu.adapters.BeritaAdapter;
import com.wisata.pemandu.adapters.InfoDestinasiAdapter;
import com.wisata.pemandu.models.BeritaResponse;
import com.wisata.pemandu.models.DataItemBerita;
import com.wisata.pemandu.models.DataItemDestinasi;
import com.wisata.pemandu.models.DestinasiResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.wisata.pemandu.data.Constans.BERITA;
import static com.wisata.pemandu.data.Constans.DESTINASI;

public class InfoDestinasiActivity extends AppCompatActivity {
    private static final String TAG = "InfoDestinasiActivity";

    @BindView( R.id.recyler )
    RecyclerView recycler;
    @BindView( R.id.refresh )
    SwipeRefreshLayout refresh;

    List<DataItemDestinasi> itemDestinasiList = new ArrayList<>();

    InfoDestinasiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_info_destinasi );

        ButterKnife.bind( this );

        adapter = new InfoDestinasiAdapter( this );
        recycler.setLayoutManager( new LinearLayoutManager( this ) );
        recycler.setAdapter( adapter );

        loadInfoDestinasi();
    }

    private void loadInfoDestinasi() {
        refresh.setRefreshing( true );
        AndroidNetworking.get( DESTINASI )
                .build()
                .getAsObject( DestinasiResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        refresh.setRefreshing( false );
                        if (response instanceof DestinasiResponse) {
                            adapter.swap( ((DestinasiResponse) response).getData() );
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        refresh.setRefreshing( false );
                        Log.d(TAG, "onError" + anError.getErrorDetail());
                    }
                } );
    }

    public List<DataItemDestinasi> getAllData(List<DataItemDestinasi> DataItemDestinasiList) {
        List<DataItemDestinasi> list = new ArrayList<>();
        for (int i = 0; i < DataItemDestinasiList.size(); i++) {
            list.add(DataItemDestinasiList.get(i));
        }
        return list;
    }

}
