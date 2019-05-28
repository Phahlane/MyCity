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

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.entersekt.mycity.MainActivity;
import com.entersekt.mycity.R;
import com.entersekt.mycity.adapters.MallAdapter;
import com.entersekt.mycity.models.CityResponse;
import com.entersekt.mycity.presenters.MainPresenter;

import butterknife.BindView;

public class MallsFragment extends Fragment {

    @BindView(R.id.rvList)
    private RecyclerView rvList;


    private MallAdapter adapter;
    private MainPresenter mainPresenter;


    private static final String TAG = "MallsFragment";
    public MallsFragment() {

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

        final int positionCity = getArguments().getInt("position");
        if(CityResponse.getCityResponseInstance().getResults().size() > positionCity) {
            ((MainActivity) getActivity()).setTitle(CityResponse.getCityResponseInstance().getResults().get(positionCity).getName());
            adapter = new MallAdapter(CityResponse.getCityResponseInstance().getResults().get(positionCity).getMallArrayList(), getContext());
            adapter.setOnItemClickListener(new MallAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {
                    NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                    Bundle bundle =  new Bundle();
                    bundle.putInt("position",position);
                    bundle.putInt("positionCity",positionCity);
                    navController.navigate(R.id.action_mallFragment_to_shopFragment,bundle);
                }
            });

            rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

            rvList.setAdapter(adapter);
        }else{
            Log.d(TAG,"Malls response invalid");
        }
    }
}