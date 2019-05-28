package com.entersekt.mycity.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.entersekt.mycity.R;
import com.entersekt.mycity.models.Mall;

import java.util.List;


public class MallAdapter extends RecyclerView.Adapter<MallAdapter.MallHolder>   {

    List<Mall> mallList;
    Context context;

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public  void setOnItemClickListener(OnItemClickListener listener) {
        MallAdapter.listener = listener;
    }

    public MallAdapter(List<Mall> mallList, Context context) {
        this.mallList = mallList;
        this.context = context;
    }

    @NonNull
    @Override
    public MallHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        MallHolder mh = new MallHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(MallHolder holder, int position) {
        holder.tvName.setText(mallList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mallList.size();
    }

    public class MallHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView ivSample;

        public MallHolder(View v) {
            super(v);
            tvName = v.findViewById(R.id.tvName);

            ivSample = v.findViewById(R.id.ivSample);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Triggers click upwards to the adapter on click
                    if (listener != null)
                        listener.onItemClick(itemView, getLayoutPosition());
                }
            });
        }
    }
}
