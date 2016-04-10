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
import com.techno.technopreneurship.Object.HeartRate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddHeartRateFragment extends Fragment {

    EditText hr;
    Button addHR;
    public AddHeartRateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_heart_rate, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        hr = (EditText) view.findViewById(R.id.add_hr_fill);
        addHR = (Button) view.findViewById(R.id.add_hr_btn);

        addHR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hr == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "all field need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    HeartRateFragment fragment = new HeartRateFragment();
//                    Bundle bundle = new Bundle();
                    //temp use to get date data
                    Date today = Calendar.getInstance().getTime();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                    String dateFormat = formatter.format(today);
//                    bundle.putString("date", dateFormat);
//                    bundle.putString("heartrate", hr.getText().toString());
//                    bundle.putString("cuser", currentUser);
//                    bundle.putString("cname", currentName);
//                    fragment.setArguments(bundle);

                    HeartRate newHeartRate = new HeartRate(Global.currentUsername, Global.currentName, dateFormat, Double.parseDouble(hr.getText().toString()));
                    Global.heartRates.add(newHeartRate);
                    Global.updateCurrentHeartRate();

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
