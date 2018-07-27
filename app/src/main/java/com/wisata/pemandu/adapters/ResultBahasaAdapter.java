package com.wisata.pemandu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.wisata.pemandu.models.DataItemPemandu;

import java.util.List;

public class ResultBahasaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    List<DataItemPemandu> listItem;
    private Context ctx;
//    private OnItemClickListener
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
