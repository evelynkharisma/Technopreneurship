package com.techno.technopreneurship;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.widget.Toast;

import com.techno.technopreneurship.Object.Global;

public class CholesterolFragment extends Fragment {
    public CholesterolFragment() {    }

    boolean visible;

    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cholesterol, container, false);
        Global.currentPage = "CholesterolFragment";

        Global.currentCategory = "cholesterol";

        TableLayout table = (TableLayout) view.findViewById(R.id.Cholesterol_Table);

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addCholesterol);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCholesterolFragment fragment = new AddCholesterolFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.btn_chartCholesterol);
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

        TextView label_hdl = new TextView(getActivity());
        label_hdl.setId(21);
        label_hdl.setText("HDL");
        label_hdl.setPadding(5, 5, 5, 5);
        tableRow.addView(label_hdl);

        TextView label_ldl = new TextView(getActivity());
        label_ldl.setId(22);
        label_ldl.setText("LDL");
        label_ldl.setPadding(5, 5, 5, 5);
        tableRow.addView(label_ldl);

        TextView label_total = new TextView(getActivity());
        label_total.setId(23);
        label_total.setText("Total");
        label_total.setPadding(5, 5, 5, 5);
        tableRow.addView(label_total);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentCholesterol.size();
        for (int i = 0; i < Global.currentCholesterol.size() ; i++) {
            String date = Global.currentCholesterol.get(i).getDate();
            Double hdl = Global.currentCholesterol.get(i).getHdl();
            Double ldl = Global.currentCholesterol.get(i).getLdl();
            Double total = Global.currentCholesterol.get(i).getTotal();

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

            TextView labelHDL = new TextView(getActivity());
            labelHDL.setId(200 + count);
            labelHDL.setText(hdl.toString());
            tr.addView(labelHDL);

            TextView labelLDL = new TextView(getActivity());
            labelLDL.setId(200 + count);
            labelLDL.setText(ldl.toString());
            tr.addView(labelLDL);

            TextView labelTOTAL = new TextView(getActivity());
            labelTOTAL.setId(200 + count);
            labelTOTAL.setText(total.toString());
            tr.addView(labelTOTAL);

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

                                    for (int i = 0; i < Global.cholesterols.size(); i++) {
                                        if (Global.cholesterols.get(i).getUser().equalsIgnoreCase(Global.currentCholesterol.get(Global.clickedDeleteId).getUser()) && Global.cholesterols.get(i).getName().equalsIgnoreCase(Global.currentCholesterol.get(Global.clickedDeleteId).getName())) {
                                            Global.cholesterols.remove(i);
                                            Global.updateCurrentCholesterol();

                                            Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                            i = Global.cholesterols.size();
                                        }
                                    }

                                    CholesterolFragment fragment = new CholesterolFragment();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
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
