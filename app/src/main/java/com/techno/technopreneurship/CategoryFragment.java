package com.techno.technopreneurship;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageButton;


public class CategoryFragment extends Fragment {

    ImageButton allergy;
    ImageButton blood_count;
    ImageButton blood_tension;
    ImageButton cholesterol;
    ImageButton diabetes;
    ImageButton heart_rate;
    ImageButton uric_acid;
    ImageButton urine_test;
    ImageButton vaccine;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_category, container, false);

        final Bundle bundle = this.getArguments();
        final String famUser = bundle.getString("cuser");
        final String famName = bundle.getString("cname");

        allergy = (ImageButton) view.findViewById(R.id.c1);
        allergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                AllergyFragment fragment = new AllergyFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        blood_count = (ImageButton) view.findViewById(R.id.c2);
        blood_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                BloodCountFragment fragment = new BloodCountFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}
