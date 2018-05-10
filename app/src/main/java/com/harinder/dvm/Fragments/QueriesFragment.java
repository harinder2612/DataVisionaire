package com.harinder.dvm.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.harinder.dvm.Home;
import com.harinder.dvm.ListOfQueries;
import com.harinder.dvm.MapsActivity;
import com.harinder.dvm.R;
import com.harinder.dvm.StorageCalls;
import com.harinder.dvm.queryAdapter;
import com.harinder.dvm.queryItemClass;

import java.util.ArrayList;
import java.util.Map;


public class QueriesFragment extends Fragment {


    public QueriesFragment() {
        // Required empty public constructor
    }


    ListView listView;
    DatabaseReference myref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dvmfirebaseproject-b0ea0.firebaseio.com/");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_queries, container, false);
        listView=rootView.findViewById(R.id.frag_list_of_queries);

        final ArrayList<queryItemClass> list = new ArrayList<>();

        final queryAdapter adapter= new queryAdapter(getContext(),list);
        listView.setAdapter(adapter);

        myref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                Map<String,String> map = (Map<String,String>) dataSnapshot.getValue();
                list.add(new queryItemClass(map.get("cropname"),map.get("time"),map.get("result"),map.get("activemonths")));
                adapter.notifyDataSetChanged();
                System.out.println("result:" +map );
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getContext(),MapsActivity.class);
                intent.putExtra("CallBy","OldQuery");
                intent.putExtra("Result", list.get(i).getResults());
                startActivity(intent);
            }
        });

        return rootView;
    }

}
