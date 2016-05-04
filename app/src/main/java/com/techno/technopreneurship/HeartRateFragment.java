package com.techno.technopreneurship;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.Diabetes;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HeartRate;

import java.util.ArrayList;

public class HeartRateFragment extends Fragment {
    public HeartRateFragment() {}

    boolean visible;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_heart_rate, container, false);
        Global.currentPage = "HeartRateFragment";

        Global.currentCategory = "heart rate";

        TableLayout table = (TableLayout) view.findViewById(R.id.HR_Table);

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addHR);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddHeartRateFragment fragment = new AddHeartRateFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.btn_chartHeartRate);
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

        TextView label_hr = new TextView(getActivity());
        label_hr.setId(21);
        label_hr.setText("Heart Rate");
        label_hr.setPadding(5, 5, 5, 5);
        tableRow.addView(label_hr);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentHeartRate.size();
        for (int i = 0; i < Global.currentHeartRate.size() ; i++) {
            String date = Global.currentHeartRate.get(i).getDate();
            Double hr = Global.currentHeartRate.get(i).getHeartRate();

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

            TextView labelHR = new TextView(getActivity());
            labelHR.setId(200 + count);
            labelHR.setText(hr.toString());
            tr.addView(labelHR);

            Global.clickedDeleteId = i;
            tr.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setTitle("Your Title");

                    alertDialogBuilder.setMessage("Delete data?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {

                                    for (int i = 0; i < Global.heartRates.size(); i++) {
                                        if (Global.heartRates.get(i).getUser().equalsIgnoreCase(Global.currentHeartRate.get(Global.clickedDeleteId).getUser()) && Global.heartRates.get(i).getName().equalsIgnoreCase(Global.currentHeartRate.get(Global.clickedDeleteId).getName())) {
                                            Global.heartRates.remove(i);
                                            Global.updateCurrentHeartRate();

                                            Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                            i = Global.heartRates.size();
                                        }
                                    }

                                    HeartRateFragment fragment = new HeartRateFragment();
                                    FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                                    fragmentTransaction.commit();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }

            });




            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
