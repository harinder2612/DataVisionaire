package com.harinder.dvm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

public class ListOfQueries extends AppCompatActivity {

    ListView listOfQueries;
    DatabaseReference myref= FirebaseDatabase.getInstance().getReferenceFromUrl("https://dvmfirebaseproject-b0ea0.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_queries);
        listOfQueries=findViewById(R.id.list_of_queries);

        final ArrayList<queryItemClass> list = new ArrayList<>();

        final queryAdapter adapter= new queryAdapter(this,list);
        listOfQueries.setAdapter(adapter);

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

        listOfQueries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(ListOfQueries.this,StorageCalls.class);
                intent.putExtra("NameOfScreen", list.get(i).getTime());
                startActivity(intent);
            }
        });

    }
}
