package com.harinder.dvm;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    FloatingActionButton fab;
    Dialog mydialog;
    Button delhi,haryana, punjab, maharashtra,up,uttrakhand,tamilnadu,goa,jnk,himachal;
    ImageView menu;
    ArrayList<String> resultStates;
    String callby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        mydialog= new Dialog(this);
        fab=findViewById(R.id.fab);
        delhi=findViewById(R.id.delhi);
        haryana=findViewById(R.id.haryana);
        punjab=findViewById(R.id.punjab);
        maharashtra=findViewById(R.id.maharashtra);
        up=findViewById(R.id.up);
        uttrakhand=findViewById(R.id.uttrakhand);
        tamilnadu=findViewById(R.id.tamilnadu);
        goa=findViewById(R.id.goa);
        jnk=findViewById(R.id.jnk);
        himachal=findViewById(R.id.himachal);
        menu=findViewById(R.id.menu);

        fab.setVisibility(View.GONE);
        menu.setVisibility(View.GONE);

        Bundle extras= getIntent().getExtras();
        callby=extras.getString("CallBy");

        if(callby.equals("OldQuery"))
        {
            String result= extras.getString("Result");
            resultStates= new ArrayList<>();

            for(int i=0,start=0,end=0; i<result.length();i++)
            {
                if(result.charAt(i)==',')
                {
                    end=i;
                    resultStates.add(result.substring(start,end));
                    start=end;
                }
                if (i==result.length()-1)
                {
                    if(start!=0)
                    {resultStates.add(result.substring(start+1,i+1));}
                    else
                    {resultStates.add(result.substring(start,i+1));}
                }
            }

            System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>"+resultStates);
        }
        else
        {
            String cropname= extras.getString("CropName");
            resultStates=new ArrayList<>();
            resultStates= new CsvData().getCropResults(cropname);
        }

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp();

            }
        });

        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MapsActivity.this,ListOfQueries.class));
            }
        });

        final CsvData csvData= new CsvData();

        delhi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
               showResults(csvData.getCropResults("Rice"));
            }
        });

        haryana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Wheat"));
            }
        });

        punjab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Gram"));
            }
        });

        maharashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Maize"));
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Arhar"));
            }
        });

        uttrakhand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Cotton"));
            }
        });

        tamilnadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("GroundNuts"));
            }
        });

        goa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Moong"));
            }
        });

        jnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Sugarcane"));
            }
        });

        himachal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mMap.clear();
                showResults(csvData.getCropResults("Mustard"));
            }
        });

    }

    public void showPopUp()
    {
        mydialog.setContentView(R.layout.popup);
        mydialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        mydialog.show();
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return;
        }
        mMap.setMyLocationEnabled(true);

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(23.983494, 79.418930),4.3f));

        showResults(resultStates);

    }

    public void showResults(ArrayList<String> results)
    {
        for(int i=0;i<results.size();i++)
        {
            drawPolygon(results.get(i));
        }
    }

    public void drawPolygon(String state)
    {
        PolygonOptions statePoly= new PolygonOptions()
                .fillColor(0x330000FF)
                .strokeWidth(0)
                .strokeColor(Color.RED);

        getStateLatLng stateObj= new getStateLatLng();

        switch (state)
        {
            case "Delhi":
                {
                    for (int i=0;i<stateObj.getDelhi().size();i++)
                    {
                        statePoly.add(stateObj.getDelhi().get(i));
                    }
                }
                break;

            case "Punjab":
            {
                for (int i=0;i<stateObj.getPunjab().size();i++)
                {
                    statePoly.add(stateObj.getPunjab().get(i));
                }
            }
            break;

            case "Bihar":
            {
                for (int i=0;i<stateObj.getBihar().size();i++)
                {
                    statePoly.add(stateObj.getBihar().get(i));
                }
            }
            break;

            case "Gujarat":
            {
                for (int i=0;i<stateObj.getGujarat().size();i++)
                {
                    statePoly.add(stateObj.getGujarat().get(i));
                }
            }
            break;

            case "AndhraPradesh":
            {
                for (int i=0;i<stateObj.getAP().size();i++)
                {
                    statePoly.add(stateObj.getAP().get(i));
                }
            }
            break;

            case "UttarPradesh":
            {
                for (int i=0;i<stateObj.getUP().size();i++)
                {
                    statePoly.add(stateObj.getUP().get(i));
                }
            }
            break;

            case "MadhyaPradesh":
            {
                for (int i=0;i<stateObj.getMP().size();i++)
                {
                    statePoly.add(stateObj.getMP().get(i));
                }
            }
            break;

            case "Rajasthan":
            {
                for (int i=0;i<stateObj.getRajasthan().size();i++)
                {
                    statePoly.add(stateObj.getRajasthan().get(i));
                }
            }
            break;

            case "WestBengal":
            {
                for (int i=0;i<stateObj.getWestBengal().size();i++)
                {
                    statePoly.add(stateObj.getWestBengal().get(i));
                }
            }
            break;

            case "Maharashtra":
            {
                for (int i=0;i<stateObj.getMaharashtra().size();i++)
                {
                    statePoly.add(stateObj.getMaharashtra().get(i));
                }
            }
            break;

            case "Haryana":
            {
                for (int i=0;i<stateObj.getHaryana().size();i++)
                {
                    statePoly.add(stateObj.getHaryana().get(i));
                }
            }
            break;

            default:{
                for (int i=0;i<stateObj.getDelhi().size();i++)
                {
                    statePoly.add(stateObj.getDelhi().get(i));
                }
            }

        }

        mMap.addPolygon(statePoly);
    }
}
