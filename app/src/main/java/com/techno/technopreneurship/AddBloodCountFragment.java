package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddBloodCountFragment extends Fragment {

    EditText rbc;
    EditText wbc;
    EditText thrombocyte;
    Button addBC;
    public AddBloodCountFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_blood_count, container, false);

        rbc = (EditText) view.findViewById(R.id.add_rbc_fill);
        wbc = (EditText) view.findViewById(R.id.add_wbc_fill);
        thrombocyte = (EditText) view.findViewById(R.id.add_thrombocyte_fill);
        addBC = (Button) view.findViewById(R.id.add_bc_btn);

        addBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbc == null || wbc == null | thrombocyte == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    BloodCountFragment fragment = new BloodCountFragment();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    Blood_Count newBloodCount = new Blood_Count(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(rbc.getText().toString()), Double.parseDouble(wbc.getText().toString()),Double.parseDouble(thrombocyte.getText().toString()));

                    Global.bloodCounts.add(newBloodCount);
                    Global.updateCurrentBloodCount();

                    if (Global.currentUser.getFirstDataBloodCount()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Blood Count", "blood count", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataBloodCount(false);
                    }

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
