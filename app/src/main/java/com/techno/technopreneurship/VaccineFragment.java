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
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HeartRate;
import com.techno.technopreneurship.Object.Vaccine;

import java.util.ArrayList;

public class VaccineFragment extends Fragment {
    public VaccineFragment() {
        // Required empty public constructor
    }

//    public ArrayList<Vaccine> vaccines = new ArrayList<Vaccine>();
//    public ArrayList<Vaccine> myVaccines = new ArrayList<Vaccine>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_vaccine, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.V_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addV);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddVaccineFragment fragment = new AddVaccineFragment();
//                Bundle choosen_bundle = new Bundle();
//                choosen_bundle.putString("cuser", currentUser);
//                choosen_bundle.putString("cname", currentName);
//                fragment.setArguments(choosen_bundle);


                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        ////////////////////////////////////Add new Blood Count to arraylist//////////////////////////////////////////////
//        vaccines.add(new Vaccine("user","user","03-01-2016","Hepatitis B","1"));
//        vaccines.add(new Vaccine("user","user","03-02-2016","Hepatitis B","2"));

//        if(bundle != null)
//        {
//            if(bundle.getString("vaccine") != null){
//                String adddate = bundle.getString("date");
//                String addv = bundle.getString("vaccine");
//                String addstage = bundle.getString("stage");
//                vaccines.add(new Vaccine(currentUser, currentName, adddate, addv, addstage));
//            }
//        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
//        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
//        for (int i = 0; i < vaccines.size(); i++) {
//            if (currentUser.equalsIgnoreCase(vaccines.get(i).getUser()) && currentName.equalsIgnoreCase(vaccines.get(i).getName())) {
//                myVaccines.add(vaccines.get(i));
//                listIndexAllergy.add(i);
//            }
//        }

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

        TextView label_v = new TextView(getActivity());
        label_v.setId(21);
        label_v.setText("Vaccine");
        label_v.setTextColor(Color.WHITE);
        label_v.setPadding(5, 5, 5, 5);
        tableRow.addView(label_v);

        TextView label_s = new TextView(getActivity());
        label_s.setId(21);
        label_s.setText("Stage");
        label_s.setTextColor(Color.WHITE);
        label_s.setPadding(5, 5, 5, 5);
        tableRow.addView(label_s);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentVaccine.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = Global.currentVaccine.get(i).getDate();
            String v = Global.currentVaccine.get(i).getVaccine();
            String s = Global.currentVaccine.get(i).getStage();

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

            TextView labelV = new TextView(getActivity());
            labelV.setId(200 + count);
            labelV.setText(v.toString());
            labelV.setTextColor(Color.WHITE);
            tr.addView(labelV);

            TextView labelS = new TextView(getActivity());
            labelS.setId(200+count);
            labelS.setText(s.toString());
            labelS.setTextColor(Color.WHITE);
            tr.addView(labelS);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
