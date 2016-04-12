package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddBloodTensionFragment extends Fragment {

    EditText systol;
    EditText diastol;
    Button addBT;
    public AddBloodTensionFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_blood_tension, container, false);


        systol = (EditText) view.findViewById(R.id.add_systol_fill);
        diastol = (EditText) view.findViewById(R.id.add_diastol_fill);
        addBT = (Button) view.findViewById(R.id.add_bt_btn);

        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(systol == null || diastol == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    BloodTensionFragment fragment = new BloodTensionFragment();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    Blood_Tension newBloodTension = new Blood_Tension(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(systol.getText().toString()), Double.parseDouble(diastol.getText().toString()));
                    Global.bloodTensions.add(newBloodTension);
                    Global.updateCurrentBloodTension();

                    if (Global.currentUser.getFirstDataBloodTension()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Blood Tension", "blood tension", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataBloodTension(false);
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
