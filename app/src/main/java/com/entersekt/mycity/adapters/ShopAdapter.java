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
import com.entersekt.mycity.models.Shop;

import java.util.List;


public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopHolder>   {

    List<Shop> shopList;
    Context context;

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public  void setOnItemClickListener(OnItemClickListener listener) {
        ShopAdapter.listener = listener;
    }

    public ShopAdapter(List<Shop> shopList, Context context) {
        this.shopList = shopList;
        this.context = context;
    }

    @NonNull
    @Override
    public ShopHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        ShopHolder mh = new ShopHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(ShopHolder holder, int position) {
        holder.tvName.setText(shopList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

    public class ShopHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView ivSample;

        public ShopHolder(View v) {
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
