package com.wisata.pemandu.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.wisata.pemandu.R;
import com.wisata.pemandu.adapters.DestinasiAdapter;
import com.wisata.pemandu.adapters.PemanduAdapter;
import com.wisata.pemandu.models.BahasaResponse;
import com.wisata.pemandu.models.DataItemDestinasi;
import com.wisata.pemandu.models.PemanduResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wisata.pemandu.data.Constans.PEMANDU;

public class PencarianPemanduActivity extends AppCompatActivity {
    private static final String TAG = "PencarianBahasaActivity";
    @BindView(R.id.recyler)
    RecyclerView recyler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    ItemAdapter itemAdapter;
    @BindView(R.id.btn_ok)
    Button btnOk;

    List<DataItemDestinasi> itemBahasaList = new ArrayList<>();

    PemanduAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_bahasa);
        ButterKnife.bind(this);

        adapter = new PemanduAdapter(this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(adapter);

        loadBahasa();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                itemAdapter.clear();
                loadBahasa();
            }
        });

        adapter.setOnItemClickListener(new PemanduAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+adapter.getItem(position).getNomorTlp()));
                startActivity(intent);
            }
        });
    }


    void loadBahasa() {
        refresh.setRefreshing(true);
        AndroidNetworking.get(PEMANDU)
                .build()
                .getAsObject(PemanduResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        refresh.setRefreshing(false);
                        if (response instanceof PemanduResponse) {
                            adapter.swap(((PemanduResponse) response).getData());
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

    @OnClick(R.id.btn_ok)
    public void onViewClicked() {
//        Log.d(TAG, "onViewClicked: "+ adapter.getSelected().size());
    }
}
