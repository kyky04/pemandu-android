package com.wisata.pemandu.models;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.gson.annotations.SerializedName;
import com.mikepenz.fastadapter.FastAdapter;
import com.mikepenz.fastadapter.items.AbstractItem;
import com.mikepenz.fastadapter.listeners.ClickEventHook;
import com.wisata.pemandu.R;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DataItemBahasa implements Serializable {

    @SerializedName("bahasa")
    private String bahasa;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("kode")
    private String kode;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("id")
    private int id;

    @SerializedName("deleted_at")
    private Object deletedAt;

    private boolean selected;

//    @Override
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public void setBahasa(String bahasa) {
        this.bahasa = bahasa;
    }



    public String getBahasa() {
        return bahasa;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getKode() {
        return kode;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

//    @NonNull
////    @Override
//    public ViewHolder getViewHolder(View v) {
//        return new ViewHolder(v);
//    }
//
//    @Override
//    public int getType() {
//        return R.id.fastadapter_item_bahasa;
//    }
//
//    @Override
//    public int getLayoutRes() {
//        return R.layout.item_bahasa;
//    }


//    public class ViewHolder extends FastAdapter.ViewHolder<DataItemBahasa> {
//        protected View view;
//        @BindView(R.id.tv_bahasa)
//        TextView tvBahasa;
//        @BindView(R.id.cb_bahasa)
//        CheckBox cbBahasa;
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//            ButterKnife.bind(this, itemView);
//            this.view = itemView;
//        }
//
//        @Override
//        public void bindView(DataItemBahasa item, List<Object> payloads) {
//            tvBahasa.setText(item.bahasa);
//        }
//
//        @Override
//        public void unbindView(DataItemBahasa item) {
//            tvBahasa.setText(null);
//        }
//    }
//
//    public static class CheckBoxClickEvent extends ClickEventHook<DataItemBahasa> {
//        @Override
//        public View onBind(@NonNull RecyclerView.ViewHolder viewHolder) {
//            if (viewHolder instanceof ViewHolder) {
//                return ((ViewHolder) viewHolder).cbBahasa;
//            }
//            return null;
//        }
//
//        @Override
//        public void onClick(View v, int position, FastAdapter<DataItemBahasa> fastAdapter, DataItemBahasa item) {
//            fastAdapter.toggleSelection(position);
//        }

//    }

    @Override
    public String toString() {
        return "DataItemBahasa{" +
                "bahasa='" + bahasa + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                ", kode='" + kode + '\'' +
                ", createdAt='" + createdAt + '\'' +
                ", id=" + id +
                ", deletedAt=" + deletedAt +
                ", selected=" + selected +
                '}';
    }

}