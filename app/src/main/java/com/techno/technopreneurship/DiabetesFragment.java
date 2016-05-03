package com.techno.technopreneurship;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.Diabetes;
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;

public class DiabetesFragment extends Fragment {
    public DiabetesFragment() {}

    boolean visible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_diabetes, container, false);
        Global.currentPage = "DiabetesFragment";

        Global.currentCategory = "diabetes";

        TableLayout table = (TableLayout) view.findViewById(R.id.Diabetes_Table);

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addDiabetes);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiabetesFragment fragment = new AddDiabetesFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.btn_chartDiabetes);
        fab2.setVisibility(View.INVISIBLE);
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LineChartActivity.class);
                startActivity(intent);
            }
        });

        visible = false;

        FloatingActionButton fab3 = (FloatingActionButton) view.findViewById(R.id.btn_menu);
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!visible) {
                    fab.setVisibility(View.VISIBLE);
                    fab2.setVisibility(View.VISIBLE);
                    visible = true;
                } else {
                    fab.setVisibility(View.INVISIBLE);
                    fab2.setVisibility(View.INVISIBLE);
                    visible = false;
                }
            }
        });


        //Set category list for the table column header
        TableRow tableRow = new TableRow(getActivity());
        tableRow.setId(10);
        tableRow.setBackgroundColor(getResources().getColor(R.color.table));
        tableRow.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));

        TextView label_date = new TextView(getActivity());
        label_date.setId(20);
        label_date.setText("DATE");
        label_date.setPadding(5, 5, 5, 5);
        tableRow.addView(label_date);

        TextView label_dia = new TextView(getActivity());
        label_dia.setId(21);
        label_dia.setText("Diabetes");
        label_dia.setPadding(5, 5, 5, 5);
        tableRow.addView(label_dia);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentDiabetes.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = Global.currentDiabetes.get(i).getDate();
            Double diabetes = Global.currentDiabetes.get(i).getDiabetes();

            // Create the table row
            TableRow tr = new TableRow(getActivity());
            if(count%2!=0) tr.setBackgroundColor(getResources().getColor(R.color.table));
            tr.setId(100 + count);
            tr.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));

            TextView labelDATE = new TextView(getActivity());
            labelDATE.setId(200 + count);
            labelDATE.setText(date);
            labelDATE.setPadding(2, 30, 5, 30);
            tr.addView(labelDATE);

            TextView labelDia = new TextView(getActivity());
            labelDia.setId(200 + count);
            labelDia.setText(diabetes.toString());
            tr.addView(labelDia);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
