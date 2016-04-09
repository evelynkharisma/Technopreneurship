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

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.HeartRate;
import com.techno.technopreneurship.Object.Vaccine;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddVaccineFragment extends Fragment {

    EditText vac;
    Spinner sta;
    Button addV;
    public AddVaccineFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_vaccine, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        vac = (EditText) view.findViewById(R.id.add_V_fill);
        sta = (Spinner)view.findViewById(R.id.add_V_stage);
        addV = (Button) view.findViewById(R.id.add_V_btn);

        addV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(vac == null || sta == null)
            {
                Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
            }
            else
            {
                VaccineFragment fragment = new VaccineFragment();
                Bundle bundle = new Bundle();
                //temp use to get date data
                Date today = Calendar.getInstance().getTime();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                String dateFormat = formatter.format(today);
                bundle.putString("date", dateFormat);
                bundle.putString("vaccine", vac.getText().toString());
                bundle.putString("stage", sta.getSelectedItem().toString());
                bundle.putString("cuser", currentUser);
                bundle.putString("cname", currentName);
                fragment.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
            }
        });

        return view;
    }
}