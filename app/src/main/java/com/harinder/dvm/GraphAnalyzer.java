package com.harinder.dvm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class GraphAnalyzer extends AppCompatActivity {

    LineChart sepLineChart;
    CheckBox riceCheck,maizeCheck,wheatCheck,gramCheck,arharCheck,moongCheck,groundCheck,mustardCheck;
    LineData data;
    ArrayList<ILineDataSet> dataSets;
    Button drawGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_analyzer);
        sepLineChart= findViewById(R.id.sepLineChart);
        riceCheck=findViewById(R.id.riceCheck);
        maizeCheck=findViewById(R.id.maizeCheck);
        wheatCheck=findViewById(R.id.wheatCheck);
        gramCheck=findViewById(R.id.gramCheck);
        arharCheck=findViewById(R.id.arharCheck);
        moongCheck=findViewById(R.id.moongCheck);
        groundCheck=findViewById(R.id.groundCheck);
        mustardCheck=findViewById(R.id.mustardCheck);
        drawGraph=findViewById(R.id.drwaGraph);

        sepLineChart.setDragEnabled(true);
        sepLineChart.setScaleEnabled(true);
        sepLineChart.setHighlightPerDragEnabled(true);

        Description desc= new Description();
        desc.setText("Crop Production Analysis");
        sepLineChart.setDescription(desc);
        sepLineChart.setDrawGridBackground(false);

        Legend legend= sepLineChart.getLegend();
        legend.setTextSize(4);
        legend.setFormSize(4);

        YAxis yAxis= sepLineChart.getAxisRight();

        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(false);


        CsvData csvData= new CsvData();

        final LineDataSet set1=new LineDataSet(csvData.getRiceProduction(),"Rice");
        set1.setFillAlpha(110);
        set1.setAxisDependency(YAxis.AxisDependency.LEFT);
        set1.setDrawValues(false);
        set1.setCircleRadius(3f);


        final LineDataSet set2=new LineDataSet(csvData.getWheatProduction(),"Wheat");
        set2.setFillAlpha(110);
        set2.setAxisDependency(YAxis.AxisDependency.LEFT);
        set2.setColor(0x330000FF);
        set2.setDrawValues(false);
        set2.setCircleColor(0x330000FF);
        set2.setCircleRadius(3f);

        final LineDataSet set3=new LineDataSet(csvData.getMaizeProduction(),"Maize");
        set3.setFillAlpha(110);
        set3.setAxisDependency(YAxis.AxisDependency.LEFT);
        set3.setColor(0xCC2200FF);
        set3.setDrawValues(false);
        set3.setCircleColor(0xCC2200FF);
        set3.setCircleRadius(3f);

        final LineDataSet set4=new LineDataSet(csvData.getGramProduction(),"Gram");
        set4.setFillAlpha(110);
        set4.setAxisDependency(YAxis.AxisDependency.LEFT);
        set4.setColor(0xEE9900FF);
        set4.setDrawValues(false);
        set4.setCircleColor(0xEE9900FF);
        set4.setCircleRadius(3f);

        final LineDataSet set5=new LineDataSet(csvData.getArharProduction(),"Arhar");
        set5.setFillAlpha(110);
        set5.setAxisDependency(YAxis.AxisDependency.LEFT);
        set5.setColor(Color.parseColor("#53AB47"));
        set5.setDrawValues(false);
        set5.setCircleColor(Color.parseColor("#53AB47"));
        set5.setCircleRadius(3f);

        final LineDataSet set6=new LineDataSet(csvData.getMoongProduction(),"Moong");
        set6.setFillAlpha(110);
        set6.setAxisDependency(YAxis.AxisDependency.LEFT);
        set6.setColor(Color.parseColor("#A2BE39"));
        set6.setDrawValues(false);
        set6.setCircleColor(Color.parseColor("#A2BE39"));
        set6.setCircleRadius(3f);

        final LineDataSet set7=new LineDataSet(csvData.getGroundProduction(),"Ground");
        set7.setFillAlpha(110);
        set7.setAxisDependency(YAxis.AxisDependency.LEFT);
        set7.setColor(Color.parseColor("#F1A223"));
        set7.setDrawValues(false);
        set7.setCircleColor(Color.parseColor("#F1A223"));
        set7.setCircleRadius(3f);

        final LineDataSet set8=new LineDataSet(csvData.getMustardProduction(),"Mustard");
        set8.setFillAlpha(110);
        set8.setAxisDependency(YAxis.AxisDependency.LEFT);
        set8.setColor(Color.parseColor("#F9CD3B"));
        set8.setDrawValues(false);
        set8.setCircleColor(Color.parseColor("#F9CD3B"));
        set8.setCircleRadius(3f);

        LineDataSet set9=new LineDataSet(csvData.getCottonProduction(),"Cotton");
        set9.setFillAlpha(110);
        set9.setAxisDependency(YAxis.AxisDependency.LEFT);
        set9.setColor(Color.parseColor("#000000"));
        set9.setDrawValues(false);
        set9.setCircleColor(Color.parseColor("#A3146E"));
        set9.setCircleRadius(3f);


        drawGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataSets=new ArrayList<>();

                if(riceCheck.isChecked())
                {
                    dataSets.add(set1);
                }
                if(wheatCheck.isChecked())
                {
                    dataSets.add(set2);
                }
                if(maizeCheck.isChecked())
                {
                    dataSets.add(set3);
                }
                if(gramCheck.isChecked())
                {
                    dataSets.add(set4);
                }
                if(arharCheck.isChecked())
                {
                    dataSets.add(set5);
                }
                if(moongCheck.isChecked())
                {
                    dataSets.add(set6);
                }
                if(groundCheck.isChecked())
                {
                    dataSets.add(set7);
                }
                if(mustardCheck.isChecked())
                {
                    dataSets.add(set8);
                }

                data=new LineData(dataSets);
                sepLineChart.setData(data);
                sepLineChart.animateXY(3000,3000);
            }
        });

    }
}
