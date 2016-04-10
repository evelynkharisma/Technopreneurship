package com.techno.technopreneurship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddBloodTensionFragment extends Fragment {

    EditText systol;
    EditText diastol;
    Button addBT;
    public AddBloodTensionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_blood_tension, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

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
//                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);
//                    bundle.putString("date", dateFormat);
//                    bundle.putString("systol", systol.getText().toString());
//                    bundle.putString("diastol", diastol.getText().toString());
//                    bundle.putString("cuser", currentUser);
//                    bundle.putString("cname", currentName);
//                    fragment.setArguments(bundle);


                    Blood_Tension newBloodTension = new Blood_Tension(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(systol.getText().toString()), Double.parseDouble(diastol.getText().toString()));
                    Global.bloodTensions.add(newBloodTension);
                    Global.updateCurrentBloodTension();

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
