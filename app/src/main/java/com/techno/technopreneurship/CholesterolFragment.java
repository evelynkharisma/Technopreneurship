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

import com.techno.technopreneurship.Object.Cholesterol;

import java.util.ArrayList;

public class CholesterolFragment extends Fragment {
    public CholesterolFragment() {
        // Required empty public constructor
    }

    public ArrayList<Cholesterol> cholesterols = new ArrayList<Cholesterol>();
    public ArrayList<Cholesterol> myCholesterols = new ArrayList<Cholesterol>();
    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_cholesterol, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.Cholesterol_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addCholesterol);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddCholesterolFragment fragment = new AddCholesterolFragment();
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
        cholesterols.add(new Cholesterol("user","user","03-04-2016",5.3,5.4,200));
        cholesterols.add(new Cholesterol("user","user","01-04-2016",7,6,250));


        if(bundle != null)
        {
            if(bundle.getString("hdl") != null){
                String adddate = bundle.getString("date");
                String addhdl = bundle.getString("hdl");
                String addldl = bundle.getString("ldl");
                String addtotal = bundle.getString("total");
                cholesterols.add(new Cholesterol(currentUser, currentName, adddate, Double.parseDouble(addhdl), Double.parseDouble(addldl), Double.parseDouble(addtotal)));
            }
        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
        for (int i = 0; i < cholesterols.size(); i++) {
            if (currentUser.equalsIgnoreCase(cholesterols.get(i).getUser()) && currentName.equalsIgnoreCase(cholesterols.get(i).getName())) {
                myCholesterols.add(cholesterols.get(i));
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

        TextView label_hdl = new TextView(getActivity());
        label_hdl.setId(21);
        label_hdl.setText("HDL");
        label_hdl.setTextColor(Color.WHITE);
        label_hdl.setPadding(5, 5, 5, 5);
        tableRow.addView(label_hdl);

        TextView label_ldl = new TextView(getActivity());
        label_ldl.setId(22);
        label_ldl.setText("LDL");
        label_ldl.setTextColor(Color.WHITE);
        label_ldl.setPadding(5, 5, 5, 5);
        tableRow.addView(label_ldl);

        TextView label_total = new TextView(getActivity());
        label_total.setId(23);
        label_total.setText("Total");
        label_total.setTextColor(Color.WHITE);
        label_total.setPadding(5, 5, 5, 5);
        tableRow.addView(label_total);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = myCholesterols.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = myCholesterols.get(i).getDate();
            Double hdl = myCholesterols.get(i).getHdl();
            Double ldl = myCholesterols.get(i).getLdl();
            Double total = myCholesterols.get(i).getTotal();

            // Create the table row
            TableRow tr = new TableRow(getActivity());
            if(count%2!=0) tr.setBackgroundColor(Color.GRAY);
            tr.setId(100+count);
            tr.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));

            TextView labelDATE = new TextView(getActivity());
            labelDATE.setId(200+count);
            labelDATE.setText(date);
            labelDATE.setPadding(2, 0, 5, 0);
            labelDATE.setTextColor(Color.WHITE);
            tr.addView(labelDATE);

            TextView labelHDL = new TextView(getActivity());
            labelHDL.setId(200 + count);
            labelHDL.setText(hdl.toString());
            labelHDL.setTextColor(Color.WHITE);
            tr.addView(labelHDL);

            TextView labelLDL = new TextView(getActivity());
            labelLDL.setId(200+count);
            labelLDL.setText(ldl.toString());
            labelLDL.setTextColor(Color.WHITE);
            tr.addView(labelLDL);

            TextView labelTOTAL = new TextView(getActivity());
            labelTOTAL.setId(200+count);
            labelTOTAL.setText(total.toString());
            labelTOTAL.setTextColor(Color.WHITE);
            tr.addView(labelTOTAL);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
