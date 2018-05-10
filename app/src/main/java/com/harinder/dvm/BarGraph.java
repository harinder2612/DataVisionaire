package com.harinder.dvm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class BarGraph extends AppCompatActivity {

    BarChart barChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph);

        barChart=findViewById(R.id.barChart);


        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
        barChart.setHighlightPerDragEnabled(true);

        Description desc= new Description();
        desc.setText("Cost of Cultivation Analysis");
        barChart.setDescription(desc);
        barChart.setDrawGridBackground(false);

        Legend legend= barChart.getLegend();
        legend.setTextSize(4);
        legend.setFormSize(4);
        legend.setEnabled(false);

        YAxis yAxis= barChart.getAxisRight();

        yAxis.setDrawAxisLine(false);
        yAxis.setDrawLabels(false);

        final String[] quarters = new String[] { "Uttarpardesh", "Bihar", "Gujarat", "Haryana","Karnatka","AP","Maharashtra","Orissa","Punjab","Rajasthan"};

        IAxisValueFormatter formatter = new IAxisValueFormatter() {

            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return quarters[(int) value];
            }

        };

        XAxis xAxis = barChart.getXAxis();
        xAxis.setLabelCount(10,true);
        xAxis.setLabelRotationAngle(270);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(formatter);

        CsvData csvData=new CsvData();
        List<BarEntry> entries = csvData.getCostEntries();

        BarDataSet set = new BarDataSet(entries, "BarDataSet");
        set.setColors(new int[]{Color.parseColor("#C89933"),Color.parseColor("#17BECF"),Color.parseColor("#9062BB"),Color.parseColor("#2CA02C"),Color.parseColor("#FF7F0E"),Color.parseColor("#1F77B4"),Color.parseColor("#8C564B"),Color.parseColor("#D62728"),Color.parseColor("#EC058E"),Color.parseColor("#BCBD22")});
        set.setDrawValues(false);
        BarData data = new BarData(set);
        data.setBarWidth(0.9f); // set custom bar width
        barChart.setData(data);
        barChart.setFitBars(true); // make the x-axis fit exactly all bars
        barChart.animateY(3000);
    }
}
