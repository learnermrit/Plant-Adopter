package com.example.minorproject;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class Statistics_farmer extends AppCompatActivity {

    ArrayList barArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics_farmer);

        BarChart barChart=findViewById(R.id.barchat);
        getData();
        BarDataSet barDataSet=new BarDataSet(barArrayList,"Combo Tutorial");
        BarData barData=new BarData(barDataSet);
        barChart.setData(barData);

        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barDataSet.setValueTextColor(Color.BLACK);

        barDataSet.setValueTextSize(16f);
    }

    private  void getData(){
        barArrayList=new ArrayList();
        barArrayList.add(new BarEntry(2f,7));
        barArrayList.add(new BarEntry(3f,6));
        barArrayList.add(new BarEntry(4f,10));
        barArrayList.add(new BarEntry(5f,5));
        barArrayList.add(new BarEntry(6f,2));
    }
}