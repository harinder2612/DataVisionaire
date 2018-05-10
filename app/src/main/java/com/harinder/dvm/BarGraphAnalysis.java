package com.harinder.dvm;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class BarGraphAnalysis extends AppCompatActivity {

    BarChart barChart;
    CheckBox riceCheck,maizeCheck,wheatCheck,gramCheck,arharCheck,moongCheck,groundCheck,mustardCheck,cottonCheck,caneCheck;
    Button drawGraph;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar_graph_analysis);

        barChart=findViewById(R.id.barChartAnalysis);
        riceCheck=findViewById(R.id.barriceCheck);
        maizeCheck=findViewById(R.id.barmaizeCheck);
        wheatCheck=findViewById(R.id.barwheatCheck);
        gramCheck=findViewById(R.id.bargramCheck);
        arharCheck=findViewById(R.id.bararharCheck);
        moongCheck=findViewById(R.id.barmoongCheck);
        groundCheck=findViewById(R.id.bargroundCheck);
        mustardCheck=findViewById(R.id.barmustardCheck);
        drawGraph=findViewById(R.id.bardrwaGraph);
        cottonCheck=findViewById(R.id.barcotton);
        caneCheck=findViewById(R.id.barcane);

        barChart.setDragEnabled(true);
        barChart.setScaleEnabled(true);
       // barChart.setHighlightPerDragEnabled(true);

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
        xAxis.setLabelCount(11,true);
        xAxis.setLabelRotationAngle(270);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(formatter);



        drawGraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int []arr=new int[10];

                for(int i=0;i<10;i++)
                    arr[i]=0;

                if(riceCheck.isChecked())
                {
                    arr[7]=1;
                }
                if(wheatCheck.isChecked())
                {
                    arr[9]=1;
                }
                if(maizeCheck.isChecked())
                {
                    arr[4]=1;
                }
                if(gramCheck.isChecked())
                {
                    arr[2]=1;
                }
                if(arharCheck.isChecked())
                {
                    arr[0]=1;
                }
                if(moongCheck.isChecked())
                {
                    arr[5]=1;
                }
                if(groundCheck.isChecked())
                {
                    arr[3]=1;
                }
                if(mustardCheck.isChecked())
                {
                    arr[6]=1;
                }
                if(cottonCheck.isChecked())
                {
                    arr[1]=1;
                }
                if(caneCheck.isChecked())
                {
                    arr[8]=1;
                }

                CsvData csvData= new CsvData();

                float [][]mainarr= csvData.getCostForCrops(arr);

                float []temp1=new float[10];
                float []temp2=new float[10];
                float []temp3=new float[10];
                float []temp4=new float[10];
                float []temp5=new float[10];
                float []temp6=new float[10];
                float []temp7=new float[10];
                float []temp8=new float[10];
                float []temp9=new float[10];
                float []temp10=new float[10];

                for (int i=0;i<10;i++)
                {
                    temp1[i]=mainarr[0][i];
                }

                for (int i=0;i<10;i++)
                {
                    temp2[i]=mainarr[1][i];
                }

                for (int i=0;i<10;i++)
                {
                    temp3[i]=mainarr[2][i];
                }

                for (int i=0;i<10;i++)
                {
                    temp4[i]=mainarr[3][i];
                }

                for (int i=0;i<10;i++)
                {
                    temp5[i]=mainarr[4][i];
                }
                for (int i=0;i<10;i++)
                {
                    temp6[i]=mainarr[5][i];
                }
                for (int i=0;i<10;i++)
                {
                    temp7[i]=mainarr[6][i];
                }
                for (int i=0;i<10;i++)
                {
                    temp8[i]=mainarr[7][i];
                }
                for (int i=0;i<10;i++)
                {
                    temp9[i]=mainarr[8][i];
                }
                for (int i=0;i<10;i++)
                {
                    temp10[i]=mainarr[9][i];
                }


                List<BarEntry> entries= new ArrayList<>();

                entries.add(new BarEntry(0f,temp1));
                entries.add(new BarEntry(1f,temp2));
                entries.add(new BarEntry(2f,temp3));
                entries.add(new BarEntry(3f,temp4));
                entries.add(new BarEntry(4f,temp5));
                entries.add(new BarEntry(5f,temp6));
                entries.add(new BarEntry(6f,temp7));
                entries.add(new BarEntry(7f,temp8));
                entries.add(new BarEntry(8f,temp9));
                entries.add(new BarEntry(9f,temp10));


                BarDataSet set = new BarDataSet(entries, "BarDataSet");
                set.setColors(new int[]{Color.parseColor("#C89933"),Color.parseColor("#17BECF"),Color.parseColor("#9062BB"),Color.parseColor("#2CA02C"),Color.parseColor("#FF7F0E"),Color.parseColor("#1F77B4"),Color.parseColor("#8C564B"),Color.parseColor("#D62728"),Color.parseColor("#EC058E"),Color.parseColor("#BCBD22")});
//        set.setDrawValues(false);
                BarData data = new BarData(set);
                data.setBarWidth(0.9f); // set custom bar width
                barChart.setData(data);
                barChart.setFitBars(true); // make the x-axis fit exactly all bars
                barChart.animateY(3000);



            }
        });
    }
}
