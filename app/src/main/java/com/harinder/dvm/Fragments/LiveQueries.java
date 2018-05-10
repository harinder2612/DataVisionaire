package com.harinder.dvm.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.harinder.dvm.LiveQueryAdapter;
import com.harinder.dvm.LiveQueryItem;
import com.harinder.dvm.MapsActivity;
import com.harinder.dvm.R;

import java.util.ArrayList;

public class LiveQueries extends Fragment {


    public LiveQueries() {
        // Required empty public constructor
    }

    ListView listView;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_live_queries, container, false);

        listView=rootView.findViewById(R.id.liveQueriesList);

        final ArrayList<LiveQueryItem> cropList= new ArrayList<>();

        cropList.add(new LiveQueryItem("Rice",R.drawable.ricee));
        cropList.add(new LiveQueryItem("Wheat",R.drawable.wheat));
        cropList.add(new LiveQueryItem("Maize",R.drawable.maize));
        cropList.add(new LiveQueryItem("Gram",R.drawable.gram));
        cropList.add(new LiveQueryItem("Arhar",R.drawable.arhar));
        cropList.add(new LiveQueryItem("Moong",R.drawable.moong));
        cropList.add(new LiveQueryItem("GroundNuts",R.drawable.groundnuts));
        cropList.add(new LiveQueryItem("Mustard",R.drawable.mustard));
        cropList.add(new LiveQueryItem("Cotton",R.drawable.cotton));
        cropList.add(new LiveQueryItem("Sugarcane",R.drawable.sugarcane));

        LiveQueryAdapter liveQueryAdapter= new LiveQueryAdapter(getContext(),cropList);
        listView.setAdapter(liveQueryAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getContext(),MapsActivity.class);
                intent.putExtra("CallBy","LiveQuery");
                intent.putExtra("CropName",cropList.get(i).getCrop());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
