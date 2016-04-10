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

import com.techno.technopreneurship.Object.Cholesterol;
import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddCholesterolFragment extends Fragment {

    EditText hdl;
    EditText ldl;
    EditText total;
    Button addCholesterol;
    public AddCholesterolFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_cholesterol, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        hdl = (EditText) view.findViewById(R.id.add_hdl_fill);
        ldl = (EditText) view.findViewById(R.id.add_ldl_fill);
        total = (EditText) view.findViewById(R.id.add_total_fill);
        addCholesterol = (Button) view.findViewById(R.id.add_cholesterol_btn);

        addCholesterol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hdl == null || ldl == null | total == null)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    CholesterolFragment fragment = new CholesterolFragment();
                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);
//                    bundle.putString("date", dateFormat);
//                    bundle.putString("hdl", hdl.getText().toString());
//                    bundle.putString("ldl", ldl.getText().toString());
//                    bundle.putString("total", total.getText().toString());
//                    bundle.putString("cuser", currentUser);
//                    bundle.putString("cname", currentName);
//                    fragment.setArguments(bundle);

//                    String user, String name, String date, double hdl, double ldl, double total
                    Cholesterol newCholesterol = new Cholesterol(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(hdl.getText().toString()), Double.parseDouble(ldl.getText().toString()), Double.parseDouble(total.getText().toString()));
                    Global.cholesterols.add(newCholesterol);
                    Global.updateCurrentCholesterol();

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
