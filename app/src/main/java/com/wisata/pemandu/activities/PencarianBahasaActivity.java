package com.wisata.pemandu.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.IAdapter;
import com.mikepenz.fastadapter.ISelectionListener;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.listeners.OnClickListener;
import com.wisata.pemandu.R;
import com.wisata.pemandu.adapters.BahasaAdapter;
import com.wisata.pemandu.models.BahasaResponse;
import com.wisata.pemandu.models.DataItemBahasa;
import com.wisata.pemandu.utils.CommonUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.wisata.pemandu.data.Constans.BAHASA;
import static com.wisata.pemandu.data.Constans.PEMANDU;

public class PencarianBahasaActivity extends AppCompatActivity {
    private static final String TAG = "PencarianBahasaActivity";
    @BindView(R.id.recyler)
    RecyclerView recyler;
    @BindView(R.id.refresh)
    SwipeRefreshLayout refresh;
    ItemAdapter itemAdapter;
    @BindView(R.id.btn_ok)
    Button btnOk;

    List<DataItemBahasa> itemBahasaList = new ArrayList<>();

//    private FastAdapter<DataItemBahasa> fastItemAdapter;

    BahasaAdapter bahasaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pencarian_bahasa);
        ButterKnife.bind(this);

//        itemAdapter = new ItemAdapter();

//        fastItemAdapter = FastAdapter.with(itemAdapter);
//        fastItemAdapter.withSelectable(true);
//        fastItemAdapter.withSelectionListener(new ISelectionListener<DataItemBahasa>() {
//            @Override
//            public void onSelectionChanged(@Nullable DataItemBahasa item, boolean selected) {
//                if(selected){
//                    itemBahasaList.add(item);
//                }else {
//                    itemBahasaList.remove(item);
//                }
//                Log.d(TAG, "onSelectionChanged: "+item.getBahasa()+" Selected: "+selected);
//            }
//        });

//        fastItemAdapter.withOnClickListener(new OnClickListener<DataItemBahasa>() {
//            @Override
//            public boolean onClick(@Nullable View v, IAdapter<DataItemBahasa> adapter, DataItemBahasa item, int position) {
//                fastItemAdapter.toggleSelection(position);
//                return false;
//            }
//        });

//        fastItemAdapter.withOnPreClickListener(new OnClickListener<DataItemBahasa>() {
//            @Override
//            public boolean onClick(@Nullable View v, IAdapter<DataItemBahasa> adapter, DataItemBahasa item, int position) {
//                return false;
//            }
//        });


//        fastItemAdapter.withEventHook(new DataItemBahasa.CheckBoxClickEvent());
        bahasaAdapter = new BahasaAdapter(this);
        recyler.setLayoutManager(new LinearLayoutManager(this));
        recyler.setAdapter(bahasaAdapter);

        loadBahasa();

        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
//                itemAdapter.clear();
                loadBahasa();
            }
        });
    }


    void loadBahasa() {
        refresh.setRefreshing(true);
        AndroidNetworking.get(BAHASA)
                .build()
                .getAsObject(BahasaResponse.class, new ParsedRequestListener() {
                    @Override
                    public void onResponse(Object response) {
                        refresh.setRefreshing(false);
                        if (response instanceof BahasaResponse) {
                            bahasaAdapter.swap(((BahasaResponse) response).getData());
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        refresh.setRefreshing(false);
                        Log.d(TAG, "onError: " + anError.getErrorDetail());
                    }
                });
    }

    public List<DataItemBahasa> getAllData(List<DataItemBahasa> dataItemBahasaList) {
        List<DataItemBahasa> list = new ArrayList<>();
        for (int i = 0; i < dataItemBahasaList.size(); i++) {
            list.add(dataItemBahasaList.get(i));
        }
        return list;
    }

    @OnClick(R.id.btn_ok)
    public void onViewClicked() {
        Log.d(TAG, "onViewClicked: "+bahasaAdapter.getSelected().size());
        if (bahasaAdapter.getSelected().size() != 0){
            Intent intent = new Intent(this, PencarianDestinasiActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable( "bahasa", (Serializable) bahasaAdapter.getSelected() );
            intent.putExtras( bundle );
            startActivity(intent);
        } else {
            CommonUtil.showSnack( this, "Pilih Bahasa yang dikuasai" );
        }

    }
}
