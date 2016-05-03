package com.techno.technopreneurship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;

/**
 * Created by User on 4/25/2016.
 */
public class LineChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);

        LineChart lineChart = (LineChart) findViewById(R.id.chart);

        if (Global.currentCategory.equalsIgnoreCase("blood count")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<Entry> data2 = new ArrayList<>();
            ArrayList<Entry> data3 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentBloodCount.size(); counter++) {
                data1.add(new Entry((float) Global.currentBloodCount.get(counter).getRedBC(), counter));
                data2.add(new Entry((float) Global.currentBloodCount.get(counter).getThrombocyte(), counter));
                data3.add(new Entry((float) Global.currentBloodCount.get(counter).getWhiteBC(), counter));
                labels.add(Global.currentBloodCount.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "Red Blood Cell");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            LineDataSet lineDataSet2 = new LineDataSet(data2, "White Blood Cell");
            lineDataSet2.setColor(Color.GREEN);
            lineDataSet2.setCircleColor(Color.GREEN);
            lineDataSet2.setLineWidth(2);
            lineDataSet2.setValueTextSize(12);

            LineDataSet lineDataSet3 = new LineDataSet(data3, "Thrombocyte");
            lineDataSet3.setColor(Color.CYAN);
            lineDataSet3.setCircleColor(Color.CYAN);
            lineDataSet3.setLineWidth(2);
            lineDataSet3.setValueTextSize(12);

            lines.add(lineDataSet1);
            lines.add(lineDataSet2);
            lines.add(lineDataSet3);

//            LimitLine limitLine = new LimitLine(200);
//            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
//            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        } else if (Global.currentCategory.equalsIgnoreCase("blood tension")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<Entry> data2 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentBloodTension.size(); counter++) {
                data1.add(new Entry((float) Global.currentBloodTension.get(counter).getSystol(), counter));
                data2.add(new Entry((float) Global.currentBloodTension.get(counter).getDiastol(), counter));
                labels.add(Global.currentBloodTension.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "Systol");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            LineDataSet lineDataSet2 = new LineDataSet(data2, "Diastol");
            lineDataSet2.setColor(Color.GREEN);
            lineDataSet2.setCircleColor(Color.GREEN);
            lineDataSet2.setLineWidth(2);
            lineDataSet2.setValueTextSize(12);

            lines.add(lineDataSet1);
            lines.add(lineDataSet2);

//            LimitLine limitLine = new LimitLine(200);
//            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
//            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        } else if (Global.currentCategory.equalsIgnoreCase("cholesterol")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<Entry> data2 = new ArrayList<>();
            ArrayList<Entry> data3 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentCholesterol.size(); counter++) {
                data1.add(new Entry((float) Global.currentCholesterol.get(counter).getHdl(), counter));
                data2.add(new Entry((float) Global.currentCholesterol.get(counter).getLdl(), counter));
                data3.add(new Entry((float) Global.currentCholesterol.get(counter).getTotal(), counter));
                labels.add(Global.currentCholesterol.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "HDL");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            LineDataSet lineDataSet2 = new LineDataSet(data2, "LDL");
            lineDataSet2.setColor(Color.GREEN);
            lineDataSet2.setCircleColor(Color.GREEN);
            lineDataSet2.setLineWidth(2);
            lineDataSet2.setValueTextSize(12);

            LineDataSet lineDataSet3 = new LineDataSet(data3, "Total");
            lineDataSet3.setColor(Color.CYAN);
            lineDataSet3.setCircleColor(Color.CYAN);
            lineDataSet3.setLineWidth(2);
            lineDataSet3.setValueTextSize(12);

            lines.add(lineDataSet1);
            lines.add(lineDataSet2);
            lines.add(lineDataSet3);

            LimitLine limitLine = new LimitLine(200);
            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        } else if (Global.currentCategory.equalsIgnoreCase("diabetes")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentDiabetes.size(); counter++) {
                data1.add(new Entry((float) Global.currentDiabetes.get(counter).getDiabetes(), counter));
                labels.add(Global.currentDiabetes.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "HDL");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            lines.add(lineDataSet1);

            LimitLine limitLine = new LimitLine(130);
            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        }  else if (Global.currentCategory.equalsIgnoreCase("heart rate")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentHeartRate.size(); counter++) {
                data1.add(new Entry((float) Global.currentHeartRate.get(counter).getHeartRate(), counter));
                labels.add(Global.currentHeartRate.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "Heart Rate");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            lines.add(lineDataSet1);

            LimitLine limitLine = new LimitLine(130);
            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        } else if (Global.currentCategory.equalsIgnoreCase("diabetes")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentDiabetes.size(); counter++) {
                data1.add(new Entry((float) Global.currentDiabetes.get(counter).getDiabetes(), counter));
                labels.add(Global.currentDiabetes.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "HDL");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            lines.add(lineDataSet1);

            LimitLine limitLine = new LimitLine(130);
            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        }  else if (Global.currentCategory.equalsIgnoreCase("uric acid")) {
            ArrayList<Entry> data1 = new ArrayList<>();
            ArrayList<String> labels = new ArrayList<String>();

            for (int counter = 0; counter < Global.currentUricAcid.size(); counter++) {
                data1.add(new Entry((float) Global.currentUricAcid.get(counter).getUricAcid(), counter));
                labels.add(Global.currentUricAcid.get(counter).getDate());
            }

            ArrayList<LineDataSet> lines = new ArrayList<LineDataSet> ();

            LineDataSet lineDataSet1 = new LineDataSet(data1, "Uric Acid");
            lineDataSet1.setColor(Color.MAGENTA);
            lineDataSet1.setCircleColor(Color.MAGENTA);
            lineDataSet1.setLineWidth(2);
            lineDataSet1.setValueTextSize(12);

            lines.add(lineDataSet1);

            LimitLine limitLine = new LimitLine(130);
            limitLine.setLineWidth(2);
            YAxis leftAxis = lineChart.getAxisLeft();
            leftAxis.addLimitLine(limitLine);

            lineChart.setData(new LineData(labels, lines));
            lineChart.animateY(3000);
        }
    }
}

