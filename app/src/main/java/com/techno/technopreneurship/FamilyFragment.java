package com.techno.technopreneurship;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;
import com.techno.technopreneurship.Object.FamilyMember;

import java.util.ArrayList;


public class FamilyFragment extends Fragment {

    String currentUser = "user";    //temp to determine current user
    RelativeLayout relativeLayout;
    public ArrayList<FamilyMember> fm = new ArrayList<FamilyMember>();
    public ArrayList<FamilyMember> myFamilyMember = new ArrayList<FamilyMember>();
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
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", currentUser);
                choosen_bundle.putString("cname", currentUser);
                CategoryFragment fragment = new CategoryFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        //////////////////////////////////////////////Temp add family member/////////////////////////////////////////////////////
        fm.add(new FamilyMember("user", "son", "son"));
        fm.add(new FamilyMember("user", "daughter", "daughter"));
        fm.add(new FamilyMember("user", "wife", "wife"));
        fm.add(new FamilyMember("user", "husband", "husband"));
        fm.add(new FamilyMember("user", "grand father", "father"));
        fm.add(new FamilyMember("user", "grand mother", "mother"));

        ////////////////////////////////////Add new family member to arraylist
        final Bundle bundle = this.getArguments();
        if(bundle != null)
        {
            // utk cek klw bundle ini dtng drimana --> di pkai kalau bundle ny tidak hny datang dri addfamilyfragment
            //int isAdd = bundle.getInt("isAddFam");
            //if(isAdd == 1)
            //{
                String addFamName = bundle.getString("add_fam_name");
                String addFamStatus = bundle.getString("add_fam_status");
                fm.add(new FamilyMember(currentUser, addFamName, addFamStatus));
            //}
        }


        /////////////////////////////////////////////Create family member list////////////////////////////////////////////////
        ArrayList<Integer> listIndexFamily = new ArrayList<>();
        for (int i = 0; i < fm.size(); i++) {
            if (currentUser.equalsIgnoreCase(fm.get(i).getUser())) {
                myFamilyMember.add(fm.get(i));
                listIndexFamily.add(i);
            }
        }

        for (int row = 0; row < myFamilyMember.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                folderButton.setId(listIndexFamily.get(row));

                if(currentUser.equalsIgnoreCase(myFamilyMember.get(row).getUser()) && myFamilyMember.get(row).getStatus().equalsIgnoreCase("son"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(myFamilyMember.get(row).getUser()) && myFamilyMember.get(row).getStatus().equalsIgnoreCase("daughter"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.daughter, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("wife"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.wife, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("father"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.father, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("mother"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mother, 0, 0, 0);
                }
                else if(currentUser.equalsIgnoreCase(fm.get(row).getUser()) && fm.get(row).getStatus().equalsIgnoreCase("husband"))
                {
                    folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.husband, 0, 0, 0);
                }

                folderButton.setPadding(40, 30, 0, 30);
                folderButton.setText("      " + myFamilyMember.get(row).getName());
                folderButton.setTextSize(12);
                folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                folderButton.setGravity(Gravity.LEFT);
                folderButton.setGravity(Gravity.CENTER_VERTICAL);

                folderButton.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        int choosen = folderButton.getId();
                        String choosen_user = myFamilyMember.get(choosen).getUser();
                        String choosen_name = myFamilyMember.get(choosen).getName();
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
        /////////////////////////////////////////Create Family List End//////////////////////////////////////////////////////

        return view;
    }
}
