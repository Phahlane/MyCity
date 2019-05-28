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
import android.widget.ProgressBar;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.entersekt.mycity.MainActivity;
import com.entersekt.mycity.R;
import com.entersekt.mycity.adapters.CitiesAdapter;
import com.entersekt.mycity.models.CityResponse;
import com.entersekt.mycity.presenters.MainPresenter;

import butterknife.BindView;

public class CitiesFragment  extends Fragment implements CitiesInterface {

    @BindView(R.id.rvList)
    private RecyclerView rvList;

    @BindView(R.id.progressBar)
    private ProgressBar progressBar;


    CitiesAdapter adapter;
    private MainPresenter mainPresenter;


    private static final String TAG = "CitiesFragment";

    public CitiesFragment() {

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        setupMVP();
        setupViews(view);
        getCities();


    }


    private void setupMVP() {

        mainPresenter = new MainPresenter(this);
    }

    private void setupViews(View view){
        rvList = view.findViewById(R.id.rvList);
        progressBar = view.findViewById(R.id.progressBar);

        ((MainActivity) getActivity()).setTitle("Cities");
    }

    private void getCities() {
        mainPresenter.getCities();

    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void displayCities(final CityResponse cityResponse) {
        if(cityResponse!=null) {
            Log.d(TAG,cityResponse.getResults().get(1).getName());
            adapter = new CitiesAdapter(cityResponse.getResults(), getContext());
            adapter.setOnItemClickListener(new CitiesAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(View view, int position) {


                    NavController navController = Navigation.findNavController(getActivity(), R.id.my_nav_host_fragment);
                    Bundle bundle =  new Bundle();
                    bundle.putInt("position",position);
                    navController.navigate(R.id.action_cityFragment_to_mallFragment,bundle);

                }
            });

            rvList.setLayoutManager(new LinearLayoutManager(getActivity()));

             rvList.setAdapter(adapter);
        }else{
            Log.d(TAG,"Cities response null");
        }
    }

    @Override
    public void displayError(String s) {

    }
}