package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;
import com.techno.technopreneurship.Object.UricAcid;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddUricAcidFragment extends Fragment {

    EditText ua;
    Button addUA;
    public AddUricAcidFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_uric_acid, container, false);


        ua = (EditText) view.findViewById(R.id.add_ua_fill);
        addUA = (Button) view.findViewById(R.id.add_ua_btn);

        addUA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ua == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    UricAcidFragment fragment = new UricAcidFragment();
                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    UricAcid newUricAcid = new UricAcid(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(ua.getText().toString()));
                    Global.uricAcids.add(newUricAcid);
                    Global.updateCurrentUricAcid();

                    if (Global.currentUser.getFirstDataUricAcid()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Uric Acid", "first data in each category", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataUricAcid(false);
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
