package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;
import com.techno.technopreneurship.Object.Vaccine;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddVaccineFragment extends Fragment {

    AutoCompleteTextView vaccine;

    String[] arr = { "Diphtheria", "Hepatitis A","Hepatitis B", "Human papillomavirus", "Polio", "Tetanus   "};

    Spinner sta;
    Button addV;
    public AddVaccineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_vaccine, container, false);
        Global.currentPage = "AddVaccineFragment";

        vaccine = (AutoCompleteTextView) view.findViewById(R.id.add_V_fill); //this.getActivity
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.select_dialog_item, arr);

        vaccine.setThreshold(2); //copy
        vaccine.setAdapter(adapter); //copy

        sta = (Spinner)view.findViewById(R.id.add_V_stage);
        addV = (Button) view.findViewById(R.id.add_V_btn);

        addV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(vaccine == null || sta == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    VaccineFragment fragment = new VaccineFragment();
                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    Vaccine newVaccine = new Vaccine(Global.currentUsername, Global.currentName, dateFormat, vaccine.getText().toString(), sta.getSelectedItem().toString());
                    Global.vaccines.add(newVaccine);
                    Global.updateCurrentVaccine();

                    if (Global.currentUser.getFirstDataVaccine()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Vaccine", "vaccine", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataVaccine(false);
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
