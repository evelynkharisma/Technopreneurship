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
import com.techno.technopreneurship.Object.Global;

import java.util.ArrayList;

public class BloodTensionFragment extends Fragment {
    public BloodTensionFragment() {
        // Required empty public constructor
    }

//    public ArrayList<Blood_Tension> blood_tensions = new ArrayList<Blood_Tension>();
//    public ArrayList<Blood_Tension> myBlood_tensions = new ArrayList<Blood_Tension>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_blood_tension, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.BT_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addBT);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBloodTensionFragment fragment = new AddBloodTensionFragment();
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
//        blood_tensions.add(new Blood_Tension("user","user","03-04-2016",5.3,5.4));
//        blood_tensions.add(new Blood_Tension("user","user","01-04-2016",7,6));


//        if(bundle != null)
//        {
//            if(bundle.getString("systol") != null){
//                String adddate = bundle.getString("date");
//                String addsystol = bundle.getString("systol");
//                String adddiastol = bundle.getString("diastol");
//                blood_tensions.add(new Blood_Tension(currentUser, currentName, adddate, Double.parseDouble(addsystol), Double.parseDouble(adddiastol)));
//            }
//        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
//        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
//        for (int i = 0; i < blood_tensions.size(); i++) {
//            if (currentUser.equalsIgnoreCase(blood_tensions.get(i).getUser()) && currentName.equalsIgnoreCase(blood_tensions.get(i).getName())) {
//                myBlood_tensions.add(blood_tensions.get(i));
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

        TextView label_sys = new TextView(getActivity());
        label_sys.setId(21);
        label_sys.setText("Systol");
        label_sys.setTextColor(Color.WHITE);
        label_sys.setPadding(5, 5, 5, 5);
        tableRow.addView(label_sys);

        TextView label_dia = new TextView(getActivity());
        label_dia.setId(22);
        label_dia.setText("Diastol");
        label_dia.setTextColor(Color.WHITE);
        label_dia.setPadding(5, 5, 5, 5);
        tableRow.addView(label_dia);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentBloodTension.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = Global.currentBloodTension.get(i).getDate();
            Double systol = Global.currentBloodTension.get(i).getSystol();
            Double diastol = Global.currentBloodTension.get(i).getDiastol();

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

            TextView labelSys = new TextView(getActivity());
            labelSys.setId(200 + count);
            labelSys.setText(systol.toString());
            labelSys.setTextColor(Color.WHITE);
            tr.addView(labelSys);

            TextView labelDia = new TextView(getActivity());
            labelDia.setId(200+count);
            labelDia.setText(diastol.toString());
            labelDia.setTextColor(Color.WHITE);
            tr.addView(labelDia);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
