package com.techno.technopreneurship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HealthDetails;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddFamilyFragment extends Fragment {

    Spinner status;

    EditText name;
    EditText bloodType;
    EditText height;
    EditText weight;

    Button btn_add;

    public AddFamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_family, container, false);
        Global.currentPage = "AddFamilyFragment";

        status = (Spinner) view.findViewById(R.id.add_status_fill);

        name = (EditText) view.findViewById(R.id.add_name_fill);
        bloodType = (EditText) view.findViewById(R.id.add_blood_fill);
        height = (EditText) view.findViewById(R.id.add_height_fill);
        weight = (EditText) view.findViewById(R.id.add_weight_fill);

        btn_add = (Button) view.findViewById(R.id.add_btn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name == null || status == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "name and status need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    FamilyFragment fragment = new FamilyFragment();

                    FamilyMember newMember = new FamilyMember();
                    newMember.setUsername(Global.currentUsername);
                    newMember.setName(name.getText().toString());
                    newMember.setStatus(status.getSelectedItem().toString());

                    HealthDetails newHealthDetails = new HealthDetails();
                    newHealthDetails.setUsername(Global.currentUsername);
                    newHealthDetails.setHeight(Double.parseDouble(height.getText().toString()));
                    newHealthDetails.setWeight(Double.parseDouble(weight.getText().toString()));

                    Global.familyMembers.add(newMember);
                    Global.healthDetailses.add(newHealthDetails);
                    Global.updateCurrentFamilyMember();

                    if (Global.currentFamily.size() > 3 && Global.currentUser.getFirstThreeReward()) {
                        Date today = Calendar.getInstance().getTime();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String dateFormat = formatter.format(today);

                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Three", "first three member", 10000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();

                        Global.currentUser.setFirstThreeReward(false);
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
