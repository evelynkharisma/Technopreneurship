package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Diabetes;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddDiabetesFragment extends Fragment {

    EditText diabetes;
    Button addDiabetes;
    public AddDiabetesFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_diabetes, container, false);
        Global.currentPage = "AddDiabetesFragment";

        diabetes = (EditText) view.findViewById(R.id.add_diabetes_fill);
        addDiabetes = (Button) view.findViewById(R.id.add_diabetes_btn);

        addDiabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (diabetes == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    DiabetesFragment fragment = new DiabetesFragment();
                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    Diabetes newDiabet = new Diabetes(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(diabetes.getText().toString()));
                    Global.diabeteses.add(newDiabet);
                    Global.updateCurrentDiabetes();

                    if (Global.currentUser.getFirstDataDiabetes()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Diabetes", "diabetes", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataDiabetes(false);
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