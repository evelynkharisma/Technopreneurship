package com.techno.technopreneurship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;


public class FamilyFragment extends Fragment {

    String currentUser = "user";    //temp to determine current user
    ImageButton proceed;
    public ArrayList<FamilyMember> fm = new ArrayList<FamilyMember>();
    private static final int NUM_COLS = 1;

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_family, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.familyMemberTable);

        ////////////////////////////////////////////Add Family Member//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addMember);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        ////////////////////////////////////////////Temp button to go to category/////////////////////////////////
        proceed = (ImageButton) view.findViewById(R.id.btn_proceed);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryFragment fragment = new CategoryFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        //////////////////////////////////////////////Temp add family member/////////////////////////////////////////////////////
        fm.add(new FamilyMember("user", "son1", "son"));
        fm.add(new FamilyMember("user", "daughter1", "daughter"));
        fm.add(new FamilyMember("user", "son2", "son"));
        fm.add(new FamilyMember("user", "daughter2", "daughter"));
        fm.add(new FamilyMember("user", "son3", "son"));
        fm.add(new FamilyMember("user", "daughter3", "daughter"));

        /////////////////////////////////////////////Create family member list////////////////////////////////////////////////
        for (int row = 0; row < fm.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                //folderButton.setId(listIndexCourse.get(row));

                if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("son"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_f2685f, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("daughter"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_52c5d0, 0, 0, 0);
                }
                /*else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("wife"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_52c5d0, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("father"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_52c5d0, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("mother"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_52c5d0, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("husband"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son_52c5d0, 0, 0, 0);
                }*/

                folderButton.setPadding(40, 30, 0, 30);
                folderButton.setText("      " + fm.get(row).getName());
                folderButton.setTextSize(12);
                folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                folderButton.setGravity(Gravity.LEFT);
                folderButton.setGravity(Gravity.CENTER_VERTICAL);

                folderButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {

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
        /////////////////////////////////////////Create Family List End//////////////////////////////////////////////////////

        return view;
    }
}
