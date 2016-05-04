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

import com.techno.technopreneurship.Object.Global;

public class UrineTestFragment extends Fragment {
    public UrineTestFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_urine_test, container, false);
        Global.currentPage = "UrineTestFragment";

        TableLayout table = (TableLayout) view.findViewById(R.id.UT_Table);


        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addUT);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUrineTestFragment fragment = new AddUrineTestFragment();
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

        TextView label_pro = new TextView(getActivity());
        label_pro.setId(21);
        label_pro.setText("Protein");
        label_pro.setPadding(5, 5, 5, 5);
        tableRow.addView(label_pro);

        TextView label_glu = new TextView(getActivity());
        label_glu.setId(22);
        label_glu.setText("Glucose");
        label_glu.setPadding(5, 5, 5, 5);
        tableRow.addView(label_glu);

        TextView label_blo = new TextView(getActivity());
        label_blo.setId(23);
        label_blo.setText("Blood");
        label_blo.setPadding(5, 5, 5, 5);
        tableRow.addView(label_blo);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentUrineTest.size();
        for (int i = 0; i < Global.currentUrineTest.size() ; i++) {
            String date = Global.currentUrineTest.get(i).getDate();
            boolean p = Global.currentUrineTest.get(i).isProtein();
            boolean g = Global.currentUrineTest.get(i).isGlucose();
            boolean b = Global.currentUrineTest.get(i).isBlood();

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

            TextView labelP = new TextView(getActivity());
            labelP.setId(200 + count);
            if(p == true){
                labelP.setText("\u221A");
            }else {
                labelP.setText("x");
            }
            tr.addView(labelP);

            TextView labelG = new TextView(getActivity());
            labelG.setId(200 + count);
            if(g == true){
                labelG.setText("\u221A");
            }else {
                labelG.setText("x");
            }
            tr.addView(labelG);

            TextView labelB = new TextView(getActivity());
            labelB.setId(200 + count);
            if(b == true){
                labelB.setText("\u221A");
            }else {
                labelB.setText("x");
            }
            tr.addView(labelB);

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

                                    for (int i = 0; i < Global.urineTests.size(); i++) {
                                        if (Global.urineTests.get(i).getUser().equalsIgnoreCase(Global.currentUrineTest.get(Global.clickedDeleteId).getUser()) && Global.urineTests.get(i).getName().equalsIgnoreCase(Global.currentUrineTest.get(Global.clickedDeleteId).getName())) {
                                            Global.urineTests.remove(i);
                                            Global.updateCurrentUrineTest();

                                            Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                            i = Global.urineTests.size();
                                        }
                                    }

                                    UrineTestFragment fragment = new UrineTestFragment();
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
