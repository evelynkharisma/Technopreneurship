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

import com.techno.technopreneurship.Object.Allergy;

import java.util.ArrayList;

public class AllergyFragment extends Fragment {

    public ArrayList<Allergy> allergies = new ArrayList<Allergy>();
    public ArrayList<Allergy> myAllergies = new ArrayList<Allergy>();
    private static final int NUM_COLS = 1;

    public AllergyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_allergy, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.allergyTable);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Allergy//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addAllergy);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAllergyFragment fragment = new AddAllergyFragment();
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", currentUser);
                choosen_bundle.putString("cname", currentName);
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        ////////////////////////////////////Add new Allergy to arraylist//////////////////////////////////////////////
        allergies.add(new Allergy("user","user","peanut"));
        allergies.add(new Allergy("user","user","paracetamol"));
        allergies.add(new Allergy("user","son","diary"));


        if(bundle != null)
        {
            if(bundle.getString("add_allergy") != null){
                String addAllergy = bundle.getString("add_allergy");
                allergies.add(new Allergy(currentUser, currentName, addAllergy));
            }
        }

        ////////////////////////////////////Create allergy list///////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
        for (int i = 0; i < allergies.size(); i++) {
            if (currentUser.equalsIgnoreCase(allergies.get(i).getUser()) && currentName.equalsIgnoreCase(allergies.get(i).getName())) {
                myAllergies.add(allergies.get(i));
                listIndexAllergy.add(i);
            }
        }

        for (int row = 0; row < myAllergies.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                folderButton.setId(listIndexAllergy.get(row));

                folderButton.setPadding(40, 30, 0, 30);
                folderButton.setText("      " + myAllergies.get(row).getAllergy());
                folderButton.setTextSize(12);
                folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                folderButton.setGravity(Gravity.LEFT);
                folderButton.setGravity(Gravity.CENTER_VERTICAL);

                folderButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        int choosen = folderButton.getId();
                        String choosen_user = myAllergies.get(choosen).getUser();
                        String choosen_name = myAllergies.get(choosen).getName();
                        Bundle choosen_bundle = new Bundle();
                        choosen_bundle.putString("cuser", choosen_user);
                        choosen_bundle.putString("cname", choosen_name);
                        CategoryFragment fragment = new CategoryFragment();
                        fragment.setArguments(choosen_bundle);
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
