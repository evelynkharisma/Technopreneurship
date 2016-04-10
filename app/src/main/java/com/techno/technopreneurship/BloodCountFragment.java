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

import com.techno.technopreneurship.Object.Global;

public class BloodCountFragment extends Fragment {
    public BloodCountFragment() {
        // Required empty public constructor
    }

    //    public ArrayList<Blood_Count> blood_counts = new ArrayList<Blood_Count>();
//    public ArrayList<Blood_Count> myBlood_counts = new ArrayList<Blood_Count>();
    private static final int NUM_COLS = 1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_blood_count, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.BC_Table);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        ////////////////////////////////////////////Add Blood Count//////////////////////////////////////////////
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.btn_addBC);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddBloodCountFragment fragment = new AddBloodCountFragment();
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
//        blood_counts.add(new Blood_Count("user","user","03-04-2016",5.3,5.4,200));
//        blood_counts.add(new Blood_Count("user","user","01-04-2016",7,6,250));


//        if(bundle != null)
//        {
//            if(bundle.getString("rbc") != null){
//                String adddate = bundle.getString("date");
//                String addrbc = bundle.getString("rbc");
//                String addwbc = bundle.getString("wbc");
//                String addthrombocyte = bundle.getString("thrombocyte");
//                blood_counts.add(new Blood_Count(currentUser, currentName, adddate, Double.parseDouble(addrbc), Double.parseDouble(addwbc), Double.parseDouble(addthrombocyte)));
//            }
//        }

        ////////////////////////////////////Create blood count list///////////////////////////////////////////////////////////////////////////
//        ArrayList<Integer> listIndexAllergy = new ArrayList<>();
//        for (int i = 0; i < blood_counts.size(); i++) {
//            if (currentUser.equalsIgnoreCase(blood_counts.get(i).getUsername()) && currentName.equalsIgnoreCase(blood_counts.get(i).getName())) {
//                myBlood_counts.add(blood_counts.get(i));
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

        TextView label_rbc = new TextView(getActivity());
        label_rbc.setId(21);
        label_rbc.setText("RBC");
        label_rbc.setTextColor(Color.WHITE);
        label_rbc.setPadding(5, 5, 5, 5);
        tableRow.addView(label_rbc);

        TextView label_wbc = new TextView(getActivity());
        label_wbc.setId(22);
        label_wbc.setText("WBC");
        label_wbc.setTextColor(Color.WHITE);
        label_wbc.setPadding(5, 5, 5, 5);
        tableRow.addView(label_wbc);

        TextView label_thrombocyte = new TextView(getActivity());
        label_thrombocyte.setId(23);
        label_thrombocyte.setText("Thrombocyte");
        label_thrombocyte.setTextColor(Color.WHITE);
        label_thrombocyte.setPadding(5, 5, 5, 5);
        tableRow.addView(label_thrombocyte);

        table.addView(tableRow);


//        Global.updateCurrentBloodCount();
        Integer count=0;
        int myBCSize = Global.currentBloodCount.size();
        for (int i = myBCSize-1; i >= 0; i--){
            String date = Global.currentBloodCount.get(i).getDate();
            Double rbc = Global.currentBloodCount.get(i).getRedBC();
            Double wbc = Global.currentBloodCount.get(i).getWhiteBC();
            Double throm = Global.currentBloodCount.get(i).getThrombocyte();

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

            TextView labelRBC = new TextView(getActivity());
            labelRBC.setId(200 + count);
            labelRBC.setText(rbc.toString());
            labelRBC.setTextColor(Color.WHITE);
            tr.addView(labelRBC);

            TextView labelWBC = new TextView(getActivity());
            labelWBC.setId(200+count);
            labelWBC.setText(wbc.toString());
            labelWBC.setTextColor(Color.WHITE);
            tr.addView(labelWBC);

            TextView labelTHROM = new TextView(getActivity());
            labelTHROM.setId(200+count);
            labelTHROM.setText(throm.toString());
            labelTHROM.setTextColor(Color.WHITE);
            tr.addView(labelTHROM);

            // finally add this table row tr to the table row tableRow
            table.addView(tr, new TableLayout.LayoutParams(
                    FrameLayout.LayoutParams.FILL_PARENT,
                    FrameLayout.LayoutParams.WRAP_CONTENT));
            count++;
        }

        return view;
    }
}
