package com.wisata.pemandu.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.wisata.pemandu.R;
import com.wisata.pemandu.models.DataItemPemandu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by Comp on 2/11/2018.
 */

public class PemanduAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<DataItemPemandu> listItem;



    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public PemanduAdapter(Context ctx) {
        this.ctx = ctx;
        listItem = new ArrayList<>();
    }


    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;
        @BindView(R.id.tv_jenis_kelamin)
        TextView tvJenisKelamin;
        @BindView(R.id.tv_no_hp)
        TextView tvNoHp;
        @BindView(R.id.tv_lihat_detail)
        TextView tvLihatDetail;

        public OriginalViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);

        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pemandu, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;
            final DataItemPemandu item = listItem.get(position);
            view.tvName.setText(item.getFullname());
            view.tvJenisKelamin.setText(item.getJenisKelamin());
            view.tvNoHp.setText(item.getNomorTlp());
            view.tvLihatDetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(position);
                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public void add(DataItemPemandu item) {
        listItem.add(item);
        notifyItemInserted(listItem.size() + 1);
    }

    public void addAll(List<DataItemPemandu> listItem) {
        for (DataItemPemandu item : listItem) {
            add(item);
        }
    }

    public void removeAll() {
        listItem.clear();
        notifyDataSetChanged();
    }

    public void swap(List<DataItemPemandu> datas) {
        if (datas == null || datas.size() == 0)
            return;
        if (listItem != null && listItem.size() > 0)
            listItem.clear();
        listItem.addAll(datas);
        notifyDataSetChanged();

    }

    public DataItemPemandu getItem(int pos) {
        return listItem.get(pos);
    }

    public String showHourMinute(String hourMinute) {
        String time = "";
        time = hourMinute.substring(0, 5);
        return time;
    }


    public List<DataItemPemandu> getListItem() {
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
