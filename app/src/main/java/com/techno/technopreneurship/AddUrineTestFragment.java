package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;
import com.techno.technopreneurship.Object.UrineTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddUrineTestFragment extends Fragment {

    Switch protein;
    Switch glucose;
    Switch blood;
    boolean p = false;
    boolean g = false;
    boolean b = false;
    Button addUT;
    public AddUrineTestFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_urine_test, container, false);

        protein = (Switch) view.findViewById(R.id.switch1);
        protein.setChecked(false);
        glucose = (Switch) view.findViewById(R.id.switch2);
        glucose.setChecked(false);
        blood = (Switch) view.findViewById(R.id.switch3);
        blood.setChecked(false);
        addUT = (Button) view.findViewById(R.id.add_ut_btn);

        protein.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    p = true;
                } else {
                    p = false;
                }
            }
        });

        glucose.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    g = true;
                } else {
                    g = false;
                }
            }
        });

        blood.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    b = true;
                } else {
                    b = false;
                }
            }
        });

        addUT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UrineTestFragment fragment = new UrineTestFragment();
                //temp use to get date data
                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateFormat = formatter.format(today);

                UrineTest newUrineTest = new UrineTest(Global.currentUsername, Global.currentName, dateFormat, p, g, b);
                Global.urineTests.add(newUrineTest);
                Global.updateCurrentUrineTest();

                if (Global.currentUser.getFirstDataUrineTest()) {
                    Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Urine Test", "urine test", 20000, true);
                    Global.rewards.add(newReward);
                    Global.updateCurrentReward();
                    Global.currentUser.setFirstDataUrineTest(false);
                }


                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
