package com.wisata.pemandu.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wisata.pemandu.R;
import com.wisata.pemandu.models.DataItemBerita;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BeritaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<DataItemBerita> mList;

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        Void OnItemClick (int position);
    }

    public void setmOnClickListener(final OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public BeritaAdapter (Context ctx){
        this.ctx = ctx;
        mList = new ArrayList<>();
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.tv_judul)
        TextView tvJudul;
        @BindView( R.id.tv_isi )
        TextView tvIsi;
        @BindView( R.id.tv_date_berita )
        TextView tvDate;

        public OriginalViewHolder(View v) {
            super( v );
            ButterKnife.bind( this, v );
        }
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater.from( parent.getContext()).inflate( R.layout.item_berita, parent, false );
        vh = new OriginalViewHolder( v );
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof OriginalViewHolder){
            OriginalViewHolder view = (OriginalViewHolder) holder;
            final DataItemBerita item = mList.get( position );
            view.tvJudul.setText( item.getJudul() );
            view.tvDate.setText( item.getCreatedAt() );
            view.tvIsi.setText( item.getIsi() );
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void add(DataItemBerita item){
        mList.add( item );
        notifyItemInserted( mList.size() + 1 );
    }

    public void removeAll() {
        mList.clear();
        notifyDataSetChanged();
    }

    public void swap(List<DataItemBerita> datas) {
        if (datas == null || datas.size() == 0)
            return;
        if (mList != null && mList.size() > 0)
            mList.clear();
        mList.addAll( datas );
        notifyDataSetChanged();
    }

    public DataItemBerita getItem(int pos) {
        return mList.get( pos );
    }

    public String showHourMinute(String hourMinute) {
        String time = "";
        time = hourMinute.substring( 0,5 );
        return time;
    }

    public List<DataItemBerita> getmList() {
        return mList;
    }
}
