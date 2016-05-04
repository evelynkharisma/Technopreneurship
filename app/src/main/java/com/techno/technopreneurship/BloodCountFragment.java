package com.techno.technopreneurship;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;

public class BloodCountFragment extends Fragment {
    PopupWindow popupMessage;
    LinearLayout layoutOfPopup;
    Button insidePopupButton;
    TextView popupText;

    final Context context = getActivity();
    Integer count;
    private static final int NUM_COLS = 1;
    boolean visible;

    public BloodCountFragment() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_blood_count, container, false);
        Global.currentPage = "BloodCountFragment";

        TableLayout table = (TableLayout) view.findViewById(R.id.BC_Table);

        Global.currentCategory = "blood count";

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addBC);
        fab.setVisibility(View.INVISIBLE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBloodCountFragment fragment = new AddBloodCountFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        final FloatingActionButton fab2 = (FloatingActionButton) view.findViewById(R.id.btn_chartBloodCount);
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

        TextView label_rbc = new TextView(getActivity());
        label_rbc.setId(21);
        label_rbc.setText("RBC");
        label_rbc.setPadding(5, 5, 5, 5);
        tableRow.addView(label_rbc);

        TextView label_wbc = new TextView(getActivity());
        label_wbc.setId(22);
        label_wbc.setText("WBC");
        label_wbc.setPadding(5, 5, 5, 5);
        tableRow.addView(label_wbc);

        TextView label_thrombocyte = new TextView(getActivity());
        label_thrombocyte.setId(23);
        label_thrombocyte.setText("Thrombocyte");
        label_thrombocyte.setPadding(5, 5, 5, 5);
        tableRow.addView(label_thrombocyte);

        table.addView(tableRow);


        ArrayList<TableRow> trs = new ArrayList<>();
        count=0;
        int myBCSize = Global.currentBloodCount.size();
        for (int i = 0; i < Global.currentBloodCount.size() ; i++) {
//            for (int i = myBCSize-1; i >= 0; i--){
                String date = Global.currentBloodCount.get(i).getDate();
                Double rbc = Global.currentBloodCount.get(i).getRedBC();
                Double wbc = Global.currentBloodCount.get(i).getWhiteBC();
                Double throm = Global.currentBloodCount.get(i).getThrombocyte();

                // Create the table row
                final TableRow tr = new TableRow(getActivity());
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

                TextView labelRBC = new TextView(getActivity());
                labelRBC.setId(200 + count);
                labelRBC.setText(rbc.toString());
                tr.addView(labelRBC);

                TextView labelWBC = new TextView(getActivity());
                labelWBC.setId(200 + count);
                labelWBC.setText(wbc.toString());
                tr.addView(labelWBC);

                TextView labelTHROM = new TextView(getActivity());
                labelTHROM.setId(200 + count);
                labelTHROM.setText(throm.toString());
                tr.addView(labelTHROM);

                trs.add(tr);


                // finally add this table row tr to the table row tableRow
                table.addView(tr, new TableLayout.LayoutParams(
                        FrameLayout.LayoutParams.FILL_PARENT,
                        FrameLayout.LayoutParams.WRAP_CONTENT));
                count++;
            }


            for (int index = 0; index < trs.size(); index ++) {
                Global.clickedDeleteId = index;
                trs.get(index).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                        alertDialogBuilder.setTitle("Your Title");

                        alertDialogBuilder.setMessage("Delete data?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        for (int i = 0; i < Global.bloodCounts.size(); i++) {
                                            if (Global.bloodCounts.get(i).getUsername().equalsIgnoreCase(Global.currentBloodCount.get(Global.clickedDeleteId).getUsername()) && Global.bloodCounts.get(i).getName().equalsIgnoreCase(Global.currentBloodCount.get(Global.clickedDeleteId).getName())) {
                                                Global.bloodCounts.remove(i);
                                                Global.updateCurrentBloodCount();

                                                Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                                i = Global.bloodCounts.size();
                                            }
                                        }

                                        BloodCountFragment fragment = new BloodCountFragment();
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
            }

        return view;
    }
}
