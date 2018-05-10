package com.harinder.dvm.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.harinder.dvm.BarGraph;
import com.harinder.dvm.BarGraphAnalysis;
import com.harinder.dvm.GraphAnalyzer;
import com.harinder.dvm.Graphs;
import com.harinder.dvm.R;

public class AnalayticsFragment extends Fragment {


    public AnalayticsFragment() {
        // Required empty public constructor
    }


    TextView txt;
    View allProduction, sepProduction,cost,costAnalysis,provsCost;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_analaytics, container, false);

        allProduction=rootView.findViewById(R.id.allProduction);
        sepProduction=rootView.findViewById(R.id.separateProduction);
        cost=rootView.findViewById(R.id.costGraphs);
        costAnalysis=rootView.findViewById(R.id.costAnalysisGraphs);
        provsCost=rootView.findViewById(R.id.provscostGraphs);

        allProduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), Graphs.class);
                startActivity(intent);
            }
        });

        sepProduction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),GraphAnalyzer.class);
                startActivity(intent);
            }
        });

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),BarGraph.class);
                startActivity(intent);
            }
        });

        costAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),BarGraphAnalysis.class);
                startActivity(intent);
            }
        });

        provsCost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(),GraphAnalyzer.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

}
