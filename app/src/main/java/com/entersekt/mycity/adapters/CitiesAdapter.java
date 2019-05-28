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
import com.entersekt.mycity.models.City;

import java.util.List;


public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityHolder>   {

    List<City> cityList;
    Context context;

    private static OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(View itemView, int position);
    }

    public  void setOnItemClickListener(OnItemClickListener listener) {
        CitiesAdapter.listener = listener;
    }

    public CitiesAdapter(List<City> cityList, Context context) {
        this.cityList = cityList;
        this.context = context;
    }

    @NonNull
    @Override
    public CityHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list,parent,false);
        CityHolder mh = new CityHolder(v);
        return mh;
    }

    @Override
    public void onBindViewHolder(CityHolder holder, int position) {
        holder.tvName.setText(cityList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }

    public class CityHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        ImageView ivSample;

        public CityHolder(View v) {
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
