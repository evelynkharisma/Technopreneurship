package com.techno.technopreneurship;

import android.graphics.Color;
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

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.Diabetes;
import com.techno.technopreneurship.Object.HeartRate;
import com.techno.technopreneurship.Object.UricAcid;
import com.techno.technopreneurship.Object.UrineTest;

import java.util.ArrayList;

public class UrineTestFragment extends Fragment {
    public UrineTestFragment() {
        // Required empty public constructor
    }

    public ArrayList<UrineTest> urineTests = new ArrayList<UrineTest>();
    public ArrayList<UrineTest> myUrineTests = new ArrayList<UrineTest>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_urine_test, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.UT_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addUT);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUrineTestFragment fragment = new AddUrineTestFragment();
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", currentUser);
                choosen_bundle.putString("cname", currentName);
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        ////////////////////////////////////Add new Blood Count to arraylist//////////////////////////////////////////////
        urineTests.add(new UrineTest("user","user","03-04-2016",true, false, false));
        urineTests.add(new UrineTest("user","user","01-04-2016",false, false, false));


        if(bundle != null)
        {
            if(bundle.getString("exist") != null){
                String adddate = bundle.getString("date");
                boolean addProtein = bundle.getBoolean("protein");
                boolean addGlucose = bundle.getBoolean("glucose");
                boolean addBlood = bundle.getBoolean("blood");
                urineTests.add(new UrineTest(currentUser, currentName, adddate, addProtein, addGlucose, addBlood));
            }
        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
        for (int i = 0; i < urineTests.size(); i++) {
            if (currentUser.equalsIgnoreCase(urineTests.get(i).getUser()) && currentName.equalsIgnoreCase(urineTests.get(i).getName())) {
                myUrineTests.add(urineTests.get(i));
                listIndexAllergy.add(i);
            }
        }

        //Set category list for the table column header
        TableRow tableRow = new TableRow(getActivity());
        tableRow.setId(10);
        tableRow.setBackgroundColor(Color.GRAY);
        tableRow.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));

        TextView label_date = new TextView(getActivity());
        label_date.setId(20);
        label_date.setText("DATE");
        label_date.setTextColor(Color.WHITE);
        label_date.setPadding(5, 5, 5, 5);
        tableRow.addView(label_date);

        TextView label_pro = new TextView(getActivity());
        label_pro.setId(21);
        label_pro.setText("Protein");
        label_pro.setTextColor(Color.WHITE);
        label_pro.setPadding(5, 5, 5, 5);
        tableRow.addView(label_pro);

        TextView label_glu = new TextView(getActivity());
        label_glu.setId(22);
        label_glu.setText("Glucose");
        label_glu.setTextColor(Color.WHITE);
        label_glu.setPadding(5, 5, 5, 5);
        tableRow.addView(label_glu);

        TextView label_blo = new TextView(getActivity());
        label_blo.setId(23);
        label_blo.setText("Blood");
        label_blo.setTextColor(Color.WHITE);
        label_blo.setPadding(5, 5, 5, 5);
        tableRow.addView(label_blo);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = myUrineTests.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = myUrineTests.get(i).getDate();
            boolean p = myUrineTests.get(i).isProtein();
            boolean g = myUrineTests.get(i).isGlucose();
            boolean b = myUrineTests.get(i).isBlood();

            // Create the table row
            TableRow tr = new TableRow(getActivity());
            if(count%2!=0) tr.setBackgroundColor(Color.GRAY);
            tr.setId(100 + count);
            tr.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));

            TextView labelDATE = new TextView(getActivity());
            labelDATE.setId(200+count);
            labelDATE.setText(date);
            labelDATE.setPadding(2, 0, 5, 0);
            labelDATE.setTextColor(Color.WHITE);
            tr.addView(labelDATE);

            TextView labelP = new TextView(getActivity());
            labelP.setId(200 + count);
            if(p == true){
                labelP.setText("\u221A");
            }else {
                labelP.setText("x");
            }
            labelP.setTextColor(Color.WHITE);
            tr.addView(labelP);

            TextView labelG = new TextView(getActivity());
            labelG.setId(200 + count);
            if(g == true){
                labelG.setText("\u221A");
            }else {
                labelG.setText("x");
            }
            labelG.setTextColor(Color.WHITE);
            tr.addView(labelG);

            TextView labelB = new TextView(getActivity());
            labelB.setId(200 + count);
            if(b == true){
                labelB.setText("\u221A");
            }else {
                labelB.setText("x");
            }
            labelB.setTextColor(Color.WHITE);
            tr.addView(labelB);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
