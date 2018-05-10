package com.harinder.dvm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.Toast;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.ChartTouchListener;
import com.github.mikephil.charting.listener.OnChartGestureListener;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Graphs extends AppCompatActivity{

    LineChart lineChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graphs);

        lineChart=findViewById(R.id.lineChart);

        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setHighlightPerDragEnabled(true);

        Description desc= new Description();
        desc.setText("Crop Production Analysis");
        lineChart.setDescription(desc);
        lineChart.setDrawGridBackground(false);

        Legend legend= lineChart.getLegend();
        legend.setTextSize(4);
        legend.setFormSize(4);

        YAxis yAxis= lineChart.getAxisRight();

        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(false);


        CsvData csvData= new CsvData();

        LineDataSet set1=new LineDataSet(csvData.getRiceProduction(),"Rice");
        set1.setFillAlpha(110);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setDrawValues(false);
        set1.setCircleRadius(3f);


        LineDataSet set2=new LineDataSet(csvData.getWheatProduction(),"Wheat");
        set2.setFillAlpha(110);
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
        set2.setColor(0x330000FF);
        set2.setDrawValues(false);
        set2.setCircleColor(0x330000FF);
        set2.setCircleRadius(3f);

        LineDataSet set3=new LineDataSet(csvData.getMaizeProduction(),"Maize");
        set3.setFillAlpha(110);
        set3.setAxisDependency(YAxis.AxisDependency.LEFT);
        set3.setColor(0xCC2200FF);
        set3.setDrawValues(false);
        set3.setCircleColor(0xCC2200FF);
        set3.setCircleRadius(3f);

        LineDataSet set4=new LineDataSet(csvData.getGramProduction(),"Gram");
        set4.setFillAlpha(110);
        set4.setAxisDependency(YAxis.AxisDependency.LEFT);
        set4.setColor(0xEE9900FF);
        set4.setDrawValues(false);
        set4.setCircleColor(0xEE9900FF);
        set4.setCircleRadius(3f);

        LineDataSet set5=new LineDataSet(csvData.getArharProduction(),"Arhar");
        set5.setFillAlpha(110);
        set5.setAxisDependency(YAxis.AxisDependency.LEFT);
        set5.setColor(0xEE9900FF);
        set5.setDrawValues(false);
        set5.setCircleColor(0x999900FF);
        set5.setCircleRadius(3f);

        LineDataSet set6=new LineDataSet(csvData.getMoongProduction(),"Moong");
        set6.setFillAlpha(110);
        set6.setAxisDependency(YAxis.AxisDependency.LEFT);
        set6.setColor(Color.parseColor("#F9CD3B"));
        set6.setDrawValues(false);
        set6.setCircleColor(Color.parseColor("#F9CD3B"));
        set6.setCircleRadius(3f);

        LineDataSet set7=new LineDataSet(csvData.getGroundProduction(),"Ground");
        set7.setFillAlpha(110);
        set7.setAxisDependency(YAxis.AxisDependency.LEFT);
        set7.setColor(Color.parseColor("#F1A223"));
        set7.setDrawValues(false);
        set7.setCircleColor(Color.parseColor("#F1A223"));
        set7.setCircleRadius(3f);

        LineDataSet set8=new LineDataSet(csvData.getMustardProduction(),"Mustard");
        set8.setFillAlpha(110);
        set8.setAxisDependency(YAxis.AxisDependency.LEFT);
        set8.setColor(Color.parseColor("#A2BE39"));
        set8.setDrawValues(false);
        set8.setCircleColor(Color.parseColor("#A2BE39"));
        set8.setCircleRadius(3f);

        LineDataSet set9=new LineDataSet(csvData.getCottonProduction(),"Cotton");
        set9.setFillAlpha(110);
        set9.setAxisDependency(YAxis.AxisDependency.LEFT);
        set9.setColor(Color.parseColor("#53AB47"));
        set9.setDrawValues(false);
        set9.setCircleColor(Color.parseColor("#53AB47"));
        set9.setCircleRadius(3f);

        ArrayList<ILineDataSet> dataSets=new ArrayList<>();
        dataSets.add(set1);
        dataSets.add(set2);
        dataSets.add(set3);
        dataSets.add(set4);
        dataSets.add(set5);
        dataSets.add(set6);
        dataSets.add(set7);
        dataSets.add(set8);
        dataSets.add(set9);

        LineData data= new LineData(dataSets);

        lineChart.setData(data);
        lineChart.animateXY(3000,3000);
        getData();
    }

    public void getData()
    {
        InputStream is=getResources().openRawResource(R.raw.cropproduction);

        BufferedReader reader= new BufferedReader(new InputStreamReader(is,Charset.forName("UTF-8")));

        String line="";

        try{
            while ((line=reader.readLine())!=null)
            {
                System.out.println(">>>>>>>>>"+line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
