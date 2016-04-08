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

        blood_tension = (ImageButton) view.findViewById(R.id.c3);
        blood_tension.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                BloodTensionFragment fragment = new BloodTensionFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        cholesterol = (ImageButton) view.findViewById(R.id.c4);
        cholesterol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                CholesterolFragment fragment = new CholesterolFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        diabetes = (ImageButton) view.findViewById(R.id.c5);
        diabetes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                DiabetesFragment fragment = new DiabetesFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        heart_rate = (ImageButton) view.findViewById(R.id.c6);
        heart_rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                HeartRateFragment fragment = new HeartRateFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        uric_acid = (ImageButton) view.findViewById(R.id.c7);
        uric_acid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                UricAcidFragment fragment = new UricAcidFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        urine_test = (ImageButton) view.findViewById(R.id.c8);
        urine_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                UrineTestFragment fragment = new UrineTestFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });

        vaccine = (ImageButton) view.findViewById(R.id.c9);
        vaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle choosen_bundle = new Bundle();
                choosen_bundle.putString("cuser", famUser);
                choosen_bundle.putString("cname", famName);
                VaccineFragment fragment = new VaccineFragment();
                fragment.setArguments(choosen_bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.commit();
            }
        });


        return view;
    }
}
