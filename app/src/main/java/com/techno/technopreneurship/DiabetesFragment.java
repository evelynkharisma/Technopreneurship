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

import java.util.ArrayList;

public class DiabetesFragment extends Fragment {
    public DiabetesFragment() {
        // Required empty public constructor
    }

//    public ArrayList<Diabetes> diabetes = new ArrayList<Diabetes>();
//    public ArrayList<Diabetes> myDiabetes = new ArrayList<Diabetes>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_diabetes, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.Diabetes_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addDiabetes);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddDiabetesFragment fragment = new AddDiabetesFragment();
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
//        diabetes.add(new Diabetes("user","user","03-04-2016",5.3));
//        diabetes.add(new Diabetes("user","user","01-04-2016",7));


//        if(bundle != null)
//        {
//            if(bundle.getString("diabeteses") != null){
//                String adddate = bundle.getString("date");
//                String adddiabetes = bundle.getString("diabeteses");
//                diabetes.add(new Diabetes(currentUser, currentName, adddate, Double.parseDouble(adddiabetes)));
//            }
//        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
//        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
//        for (int i = 0; i < diabetes.size(); i++) {
//            if (currentUser.equalsIgnoreCase(diabetes.get(i).getUser()) && currentName.equalsIgnoreCase(diabetes.get(i).getName())) {
//                myDiabetes.add(diabetes.get(i));
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

        TextView label_dia = new TextView(getActivity());
        label_dia.setId(21);
        label_dia.setText("Diabetes");
        label_dia.setTextColor(Color.WHITE);
        label_dia.setPadding(5, 5, 5, 5);
        tableRow.addView(label_dia);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = Global.currentDiabetes.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = Global.currentDiabetes.get(i).getDate();
            Double diabetes = Global.currentDiabetes.get(i).getDiabetes();

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

            TextView labelDia = new TextView(getActivity());
            labelDia.setId(200+count);
            labelDia.setText(diabetes.toString());
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
