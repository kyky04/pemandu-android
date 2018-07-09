package com.wisata.pemandu.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.wisata.pemandu.R;
import com.wisata.pemandu.algorithm.JaroWinkler;
import com.wisata.pemandu.models.DataItemDestinasi;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Comp on 2/11/2018.
 */

public class DestinasiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItemDestinasi> listItem;


    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public DestinasiAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_pemandu)
        TextView tvPemandu;
        @BindView(R.id.tv_deskripsi)
        TextView tvDeskripsi;
        @BindView(R.id.cb_destinasi)
        CheckBox cbDestinasi;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_destinasi, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            final DataItemDestinasi item = listItem.get(position);
            view.tvPemandu.setText(item.getNama());
            view.tvDeskripsi.setText(item.getDeskripsi());
            view.cbDestinasi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        item.setSelected(isChecked);
                    } else {
                        item.setSelected(false);
                    }
                }
            });
//            view.tvBuatJanji.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    mOnItemClickListener.onItemClick(position);
//                }
//            });

        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void add(DataItemDestinasi item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }

    public void addAll(List<DataItemDestinasi> listItem) {
        for (DataItemDestinasi item : listItem) {
            add(item);
        }
    }

    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }

    public void swap(List<DataItemDestinasi> datas) {
        if (datas == null || datas.size() == 0)
            return;
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();

    }

    public DataItemDestinasi getItem(int pos) {
        return listItem.get(pos);
    }

    public String showHourMinute(String hourMinute) {
        String time = "";
        time = hourMinute.substring(0, 5);
        return time;
    }

    public void setFilter(String query,List<DataItemDestinasi> list) {
        listItem = new ArrayList<>();
        JaroWinkler jw = new JaroWinkler();
        List<DataItemDestinasi> destinasiList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String  input = list.get(i).getNama().trim().toString();
            input = input.replace(" ", "");
                    Log.d("JARO", input.toLowerCase()+" "+query.trim().toString().toLowerCase()+" "+jw.similarity(list.get(i).getNama().trim().toString(),query.trim().toString()));
            if(jw.similarity(input.toLowerCase(),query.trim().toString().toLowerCase()) > 0.7){
                destinasiList.add(list.get(i));
            }
        }
        listItem.addAll(destinasiList);
        notifyDataSetChanged();
    }

    public List<DataItemDestinasi> getListItem() {
        return listItem;
    }

    public List<DataItemDestinasi> getSelected() {
        List<DataItemDestinasi> bahasaSelected = new ArrayList<>();
        for (int i = 0; i < listItem.size(); i++) {
            if (listItem.get(i).isSelected()) {
                bahasaSelected.add(listItem.get(i));
            }
        }
        return bahasaSelected;
    }


}
