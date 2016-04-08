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

import java.util.ArrayList;

public class UricAcidFragment extends Fragment {
    public UricAcidFragment() {
        // Required empty public constructor
    }

    public ArrayList<UricAcid> uricAcids = new ArrayList<UricAcid>();
    public ArrayList<UricAcid> myUricAcids = new ArrayList<UricAcid>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_uric_acid, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.UA_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addUA);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddUricAcidFragment fragment = new AddUricAcidFragment();
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
        uricAcids.add(new UricAcid("user","user","03-04-2016",5.3));
        uricAcids.add(new UricAcid("user","user","01-04-2016",7));


        if(bundle != null)
        {
            if(bundle.getString("uricacid") != null){
                String adddate = bundle.getString("date");
                String addua = bundle.getString("uricacid");
                uricAcids.add(new UricAcid(currentUser, currentName, adddate, Double.parseDouble(addua)));
            }
        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
        for (int i = 0; i < uricAcids.size(); i++) {
            if (currentUser.equalsIgnoreCase(uricAcids.get(i).getUser()) && currentName.equalsIgnoreCase(uricAcids.get(i).getName())) {
                myUricAcids.add(uricAcids.get(i));
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

        TextView label_ua = new TextView(getActivity());
        label_ua.setId(21);
        label_ua.setText("Uric Acid");
        label_ua.setTextColor(Color.WHITE);
        label_ua.setPadding(5, 5, 5, 5);
        tableRow.addView(label_ua);

        table.addView(tableRow);


        Integer count=0;
        int myBCSize = myUricAcids.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = myUricAcids.get(i).getDate();
            Double ua = myUricAcids.get(i).getUricAcid();

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

            TextView labelUA = new TextView(getActivity());
            labelUA.setId(200+count);
            labelUA.setText(ua.toString());
            labelUA.setTextColor(Color.WHITE);
            tr.addView(labelUA);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
