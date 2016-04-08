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

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddBloodCountFragment extends Fragment {

    EditText rbc;
    EditText wbc;
    EditText thrombocyte;
    Button addBC;
    public AddBloodCountFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_blood_count, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
        final Bundle bundle = this.getArguments();
        final String currentUser = bundle.getString("cuser");
        final String currentName = bundle.getString("cname");

        rbc = (EditText) view.findViewById(R.id.add_rbc_fill);
        wbc = (EditText) view.findViewById(R.id.add_wbc_fill);
        thrombocyte = (EditText) view.findViewById(R.id.add_thrombocyte_fill);
        addBC = (Button) view.findViewById(R.id.add_bc_btn);

        addBC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(rbc == null || wbc == null | thrombocyte == null)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    BloodCountFragment fragment = new BloodCountFragment();
                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);
                    bundle.putString("date", dateFormat);
                    bundle.putString("rbc", rbc.getText().toString());
                    bundle.putString("wbc", wbc.getText().toString());
                    bundle.putString("thrombocyte", thrombocyte.getText().toString());
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
