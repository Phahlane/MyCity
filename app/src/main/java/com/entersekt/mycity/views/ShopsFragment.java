package com.entersekt.mycity.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.entersekt.mycity.MainActivity;
import com.entersekt.mycity.R;
import com.entersekt.mycity.adapters.MallAdapter;
import com.entersekt.mycity.adapters.ShopAdapter;
import com.entersekt.mycity.models.CityResponse;
import com.entersekt.mycity.presenters.MainPresenter;

import butterknife.BindView;

public class ShopsFragment extends Fragment {

    @BindView(R.id.rvList)
    private RecyclerView rvList;


    private ShopAdapter adapter;
    private MainPresenter mainPresenter;


    private static final String TAG = "ShopsFragment";
    public ShopsFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {



        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_malls, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        setupViews(view);
        viewListOfMalls();

    }


    private void setupViews(View view) {
        rvList = view.findViewById(R.id.rvList);
    }

    private void viewListOfMalls(){

        int positionCity = getArguments().getInt("positionCity");
        int position = getArguments().getInt("position");
        if(CityResponse.getCityResponseInstance().getResults().size() > position) {
            ((MainActivity) getActivity()).setTitle(CityResponse.getCityResponseInstance().getResults().get(positionCity).getMallArrayList().get(position).getName());
            adapter = new ShopAdapter(CityResponse.getCityResponseInstance().getResults().get(positionCity).getMallArrayList().get(position).getShopList(), getContext());

            rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

            rvList.setAdapter(adapter);
        }else{
            Log.d(TAG,"Cities response null");
        }
    }
}