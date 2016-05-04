package com.techno.technopreneurship;

import android.app.AlertDialog;
import android.content.DialogInterface;
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
import com.techno.technopreneurship.Object.Vaccine;

import java.util.ArrayList;

public class VaccineFragment extends Fragment {
    public VaccineFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_vaccine, container, false);
        Global.currentPage = "VaccineFragment";

        TableLayout table = (TableLayout) view.findViewById(R.id.V_Table);

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addV);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddVaccineFragment fragment = new AddVaccineFragment();

                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
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

        TextView label_v = new TextView(getActivity());
        label_v.setId(21);
        label_v.setText("Vaccine");
        label_v.setPadding(5, 5, 5, 5);
        tableRow.addView(label_v);

        TextView label_s = new TextView(getActivity());
        label_s.setId(21);
        label_s.setText("Stage");
        label_s.setPadding(5, 5, 5, 5);
        tableRow.addView(label_s);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentVaccine.size();
        for (int i = 0; i < Global.currentVaccine.size() ; i++) {
            String date = Global.currentVaccine.get(i).getDate();
            String v = Global.currentVaccine.get(i).getVaccine();
            String s = Global.currentVaccine.get(i).getStage();

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

            TextView labelV = new TextView(getActivity());
            labelV.setId(200 + count);
            labelV.setText(v.toString());
            tr.addView(labelV);

            TextView labelS = new TextView(getActivity());
            labelS.setId(200 + count);
            labelS.setText(s.toString());
            tr.addView(labelS);


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

                                    for (int i = 0; i < Global.vaccines.size(); i++) {
                                        if (Global.vaccines.get(i).getUser().equalsIgnoreCase(Global.currentVaccine.get(Global.clickedDeleteId).getUser()) && Global.vaccines.get(i).getName().equalsIgnoreCase(Global.currentVaccine.get(Global.clickedDeleteId).getName())) {
                                            Global.vaccines.remove(i);
                                            Global.updateCurrentVaccine();

                                            Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                            i = Global.vaccines.size();
                                        }
                                    }

                                    VaccineFragment fragment = new VaccineFragment();
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
