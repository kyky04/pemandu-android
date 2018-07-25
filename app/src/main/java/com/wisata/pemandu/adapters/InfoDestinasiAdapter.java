package com.wisata.pemandu.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisata.pemandu.R;
import com.wisata.pemandu.models.DataItemDestinasi;
import com.wisata.pemandu.models.DataItemPemandu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Comp on 2/11/2018.
 */

public class InfoDestinasiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItemDestinasi> listItem;



    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public InfoDestinasiAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_latitude)
        TextView tvLatitude;
        @BindView(R.id.tv_langitude)
        TextView tvLangitude;
        @BindView(R.id.tv_deskripsi)
        TextView tvDeskripsi;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_destinasi, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        double Latitude;
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            final DataItemDestinasi item = listItem.get(position);
            String intLatitude = new Double( item.getLatitude()).toString();
            String intLongitude = new Double( item.getLongitude()).toString();
            view.tvName.setText(item.getNama());
            view.tvLatitude.setText(intLatitude);
            view.tvLangitude.setText( intLongitude );
            view.tvDeskripsi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(position);
                    mOnItemClickListener.onItemClick(position);
                }
            });

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


    public List<DataItemDestinasi> getListItem() {
        return listItem;
    }

//    public List<DataItemPemandu> getSelected() {
//        List<DataItemPemandu> bahasaSelected = new ArrayList<>();
//        for (int i = 0; i < listItem.size(); i++) {
//            if (listItem.get(i).isSelected()) {
//                bahasaSelected.add(listItem.get(i));
//            }
//        }
//        return bahasaSelected;
//    }

    public void filterJaroWinkler(){

    }


}
