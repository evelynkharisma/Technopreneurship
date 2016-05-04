package com.techno.technopreneurship;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.Space;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Global;

public class AllergyFragment extends Fragment {

    private static final int NUM_COLS = 1;

    public AllergyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_allergy, container, false);
        Global.currentPage = "AllergyFragment";

        TableLayout table = (TableLayout) view.findViewById(R.id.allergyTable);

        ////////////////////////////////////////////Add Allergy//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addAllergy);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAllergyFragment fragment = new AddAllergyFragment();

                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });


        ////////////////////////////////////Create allergy list///////////////////////////////////////////////////////////////////////////


        for (int row = 0; row < Global.currentAllergies.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                folderButton.setId(row);

                folderButton.setPadding(40, 30, 0, 30);
                folderButton.setText("      " + Global.currentAllergies.get(row).getAllergy());
                folderButton.setTextSize(12);
                folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                folderButton.setGravity(Gravity.LEFT);
                folderButton.setGravity(Gravity.CENTER_VERTICAL);

                folderButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                        alertDialogBuilder.setTitle("Your Title");

                        alertDialogBuilder.setMessage("Delete data?")
                                .setCancelable(false)
                                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {

                                        for (int i = 0; i < Global.allergies.size(); i++) {
                                            if (Global.allergies.get(i).getUser().equalsIgnoreCase(Global.currentAllergies.get(Global.clickedDeleteId).getUser()) && Global.allergies.get(i).getName().equalsIgnoreCase(Global.currentAllergies.get(Global.clickedDeleteId).getName())) {
                                                Global.allergies.remove(i);
                                                Global.updateCurrentAllergy();

                                                Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                                i = Global.allergies.size();
                                            }
                                        }

                                        AllergyFragment fragment = new AllergyFragment();
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

            Global.clickedDeleteId = row;
            tableRow.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                            alertDialogBuilder.setTitle("Your Title");

                            alertDialogBuilder.setMessage("Delete data?")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {

                                            for (int i = 0; i < Global.bloodCounts.size(); i++) {
                                                if (Global.allergies.get(i).getUser().equalsIgnoreCase(Global.currentAllergies.get(Global.clickedDeleteId).getUser()) && Global.bloodCounts.get(i).getName().equalsIgnoreCase(Global.currentBloodCount.get(Global.clickedDeleteId).getName())) {
                                                    Global.allergies.remove(i);
                                                    Global.updateCurrentAllergy();

                                                    Toast.makeText(getActivity(), "Delete success" + Global.clickedDeleteId, 100).show();
                                                    i = Global.allergies.size();
                                                }
                                            }

                                            AllergyFragment fragment = new AllergyFragment();
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

                tableRow.addView(folderButton);
            }
            View line = new View(getActivity());
            TableRow.LayoutParams separatorLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2);
            separatorLayoutParams.setMargins(100, 0, 0, 0);
            line.setBackgroundColor(Color.GRAY);
            table.addView(line, separatorLayoutParams);

            Space rowSpace = new Space(getActivity());
            rowSpace.setMinimumHeight(20);
            table.addView(rowSpace);
        }

        return view;
    }
}
