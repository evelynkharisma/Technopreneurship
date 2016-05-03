package com.techno.technopreneurship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;
import java.util.Calendar;


public class FamilyFragment extends Fragment {

    RelativeLayout relativeLayout;
    public ArrayList<FamilyMember> fm = new ArrayList<FamilyMember>();
    public ArrayList<FamilyMember> myFamilyMember = new ArrayList<FamilyMember>();
    private static final int NUM_COLS = 1;

    public FamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_family, container, false);
        Global.currentPage = "FamilyFragment";

        TextView mainName = (TextView) view.findViewById(R.id.selected_name_data);
        TextView mainAge = (TextView) view.findViewById(R.id.selected_age_data);
        TextView mainGender = (TextView) view.findViewById(R.id.selected_gender_data);
        TextView mainWeight = (TextView) view.findViewById(R.id.selected_weigth_data);
        TextView mainHeight = (TextView) view.findViewById(R.id.selected_height_data);

        //get the age of main user
        Calendar mainBirthday = Calendar.getInstance();
        mainBirthday.setTime(Global.currentMainHealthDetail.getBirthday());
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int bornYear = mainBirthday.get(Calendar.YEAR);
        int age = currentYear - bornYear;

        Log.i("fam current year", Calendar.getInstance().get(Calendar.YEAR) + "");
        Log.i("fam born year", bornYear + "");
        Log.i("fam age", age + "");
        mainName.setText(Global.currentMainFamilyMember.getName());
        mainAge.setText(age + "");
        mainGender.setText(Global.currentMainFamilyMember.getGender());
        mainWeight.setText(String.valueOf(Global.currentMainHealthDetail.getWeight()));
        mainHeight.setText(String.valueOf(Global.currentMainHealthDetail.getHeight()));



        TableLayout table = (TableLayout) view.findViewById(R.id.familyMemberTable);

        ////////////////////////////////////////////Add Family Member//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addMember);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddFamilyFragment fragment = new AddFamilyFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });


        ////////////////////////////////////////////Main User Go to category/////////////////////////////////
        relativeLayout = (RelativeLayout) view.findViewById(R.id.main_User_Data);
        relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Global.currentName = Global.currentMainFamilyMember.getName();
                Global.updateCurrentAllergy();
                Global.updateCurrentBloodCount();
                Global.updateCurrentBloodTension();
                Global.updateCurrentCholesterol();
                Global.updateCurrentDiabetes();
                Global.updateCurrentHeartRate();
                Global.updateCurrentUricAcid();
                Global.updateCurrentUrineTest();
                Global.updateCurrentVaccine();

                CategoryFragment fragment = new CategoryFragment();
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        for (int row = 0; row < Global.currentFamily.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                folderButton.setId(row);

                if (!Global.currentFamily.get(row).getStatus().equalsIgnoreCase("main")) {
                    if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("son")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son, 0, 0, 0);
                    } else if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("daughter")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.daughter, 0, 0, 0);
                    } else if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("wife")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.wife, 0, 0, 0);
                    } else if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("father")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.father, 0, 0, 0);
                    } else if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("mother")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mother, 0, 0, 0);
                    } else if (Global.currentUsername.equalsIgnoreCase(Global.currentFamily.get(row).getUsername()) && Global.currentFamily.get(row).getStatus().equalsIgnoreCase("husband")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.husband, 0, 0, 0);
                    }

                    folderButton.setPadding(40, 30, 0, 30);
                    folderButton.setText("      " + Global.currentFamily.get(row).getName());
                    folderButton.setTextSize(12);
                    folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                    folderButton.setGravity(Gravity.LEFT);
                    folderButton.setGravity(Gravity.CENTER_VERTICAL);

                    folderButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            int choosen = folderButton.getId();
//                            String choosen_user = Global.currentFamily.get(choosen).getUsername();
//                            String choosen_name = Global.currentFamily.get(choosen).getName();
//                            Bundle choosen_bundle = new Bundle();
//                            choosen_bundle.putString("cuser", choosen_user);
//                            choosen_bundle.putString("cname", choosen_name);

                            Global.currentName = Global.currentFamily.get(choosen).getName();
                            Global.updateCurrentAllergy();
                            Global.updateCurrentBloodCount();
                            Global.updateCurrentBloodTension();
                            Global.updateCurrentCholesterol();
                            Global.updateCurrentDiabetes();
                            Global.updateCurrentHeartRate();
                            Global.updateCurrentUricAcid();
                            Global.updateCurrentUrineTest();
                            Global.updateCurrentVaccine();

                            Log.i("fam folder clicked", Global.currentFamily.get(choosen).getName());

                            CategoryFragment fragment = new CategoryFragment();
//                            fragment.setArguments(choosen_bundle);
                            android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                            fragmentTransaction.replace(R.id.fragment_container, fragment);
                            fragmentTransaction.commit();
                        }
                    });

                    tableRow.addView(folderButton);
                }
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
