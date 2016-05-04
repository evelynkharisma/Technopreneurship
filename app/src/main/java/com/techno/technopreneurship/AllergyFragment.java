package com.techno.technopreneurship;

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
                        int choosen = folderButton.getId();
                        String choosen_user = Global.currentAllergies.get(choosen).getUser();
                        String choosen_name = Global.currentAllergies.get(choosen).getName();

                        CategoryFragment fragment = new CategoryFragment();

                        android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.fragment_container, fragment);
                        fragmentTransaction.commit();
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
