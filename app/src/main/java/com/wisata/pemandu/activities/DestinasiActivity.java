package com.wisata.pemandu.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.wisata.pemandu.R;
import com.wisata.pemandu.adapters.DestinasiAdapter;
import com.wisata.pemandu.models.DataItemDestinasi;
import com.wisata.pemandu.models.DestinasiResponse;
import com.wisata.pemandu.models.PemanduResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wisata.pemandu.data.Constans.DESTINASI;
import static com.wisata.pemandu.data.Constans.PEMANDU;

public class DestinasiActivity extends AppCompatActivity {
    private static final String TAG = "PencarianBahasaActivity";
    @BindView(R.id.recyler)
    RecyclerView recyler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    ItemAdapter itemAdapter;


    List<DataItemDestinasi> itemDestinasis = new ArrayList<>();

    DestinasiAdapter adapter;
    @BindView(R.id.searchview)
    SearchView searchview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemandu);
        ButterKnife.bind(this);

        adapter = new DestinasiAdapter(this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(adapter);

//        loadBahasa();
        searchview.onActionViewExpanded();
        searchview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchview.onActionViewExpanded();
            }
        });


//        searchview.setOnSearchClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.d(TAG, "onQueryTextSubmit: "+query);
                adapter.setFilter(query,itemDestinasis);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        loadBahasa();
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                itemAdapter.clear();
                loadBahasa();
            }
        });

        adapter.setOnItemClickListener(new DestinasiAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


            }
        });
    }


    void loadBahasa() {
        refresh.setRefreshing(true);
        AndroidNetworking.get(DESTINASI)
                .build()
                .getAsObject(DestinasiResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        refresh.setRefreshing(false);
                        if (response instanceof DestinasiResponse) {

                            itemDestinasis = ((DestinasiResponse) response).getData();
//                            adapter.swap(itemDestinasis);
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        refresh.setRefreshing(false);
                        Log.d(TAG, "onError: " + anError.getErrorDetail());
                    }
                });
    }

    public List<DataItemDestinasi> getAllData(List<DataItemDestinasi> DataItemDestinasiList) {
        List<DataItemDestinasi> list = new ArrayList<>();
        for (int i = 0; i < DataItemDestinasiList.size(); i++) {
            list.add(DataItemDestinasiList.get(i));
        }
        return list;
    }


}
