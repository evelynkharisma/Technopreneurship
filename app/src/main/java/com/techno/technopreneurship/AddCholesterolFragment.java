package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Cholesterol;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddCholesterolFragment extends Fragment {

    EditText hdl;
    EditText ldl;
    EditText total;
    Button addCholesterol;
    public AddCholesterolFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_cholesterol, container, false);
        Global.currentPage = "AddCholesterolFragment";

        hdl = (EditText) view.findViewById(R.id.add_hdl_fill);
        ldl = (EditText) view.findViewById(R.id.add_ldl_fill);
        total = (EditText) view.findViewById(R.id.add_total_fill);
        addCholesterol = (Button) view.findViewById(R.id.add_cholesterol_btn);

        addCholesterol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hdl.getText().toString().equalsIgnoreCase(null) || ldl.getText().toString().equalsIgnoreCase(null) || total.getText().toString().equalsIgnoreCase(null)) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    CholesterolFragment fragment = new CholesterolFragment();

                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);

                    Cholesterol newCholesterol = new Cholesterol(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(hdl.getText().toString()), Double.parseDouble(ldl.getText().toString()), Double.parseDouble(total.getText().toString()));
                    Global.cholesterols.add(newCholesterol);
                    Global.updateCurrentCholesterol();

                    if (Global.currentUser.getFirstDataCholesterol()) {
                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Cholesterol", "cholesterol", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataCholesterol(false);
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
