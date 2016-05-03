package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Allergy;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Reward;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AddAllergyFragment extends Fragment {

    AutoCompleteTextView allergy;

    String[] arr = { "Peanut", "Paracetamol","Pineapple", "Cataflam", "Almond", "Alcohol"};
    Button addAllergy;

    public AddAllergyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_allergy, container, false);
        Global.currentPage = "AddAllergyFragment";

        allergy = (AutoCompleteTextView) view.findViewById(R.id.add_allergy_fill); //this.getActivity
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this.getActivity(),android.R.layout.select_dialog_item, arr);

        allergy.setThreshold(2); //copy
        allergy.setAdapter(adapter); //copy

        addAllergy = (Button) view.findViewById(R.id.add_allergy_btn);

        addAllergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergy == null) {
                    Toast.makeText(getActivity().getApplicationContext(), "allergy need to be filled", Toast.LENGTH_SHORT).show();
                } else {
                    AllergyFragment fragment = new AllergyFragment();
                    Allergy newAllergy = new Allergy(Global.currentUsername, Global.currentName, allergy.getText().toString());

                    Global.allergies.add(newAllergy);
                    Global.updateCurrentAllergy();

                    if (Global.currentUser.getFirstDataAllergy()) {
                        Date today = Calendar.getInstance().getTime();
                        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                        String dateFormat = formatter.format(today);

                        Reward newReward = new Reward(Global.currentUsername, dateFormat, "First Data of Allergy", "allergy", 20000, true);
                        Global.rewards.add(newReward);
                        Global.updateCurrentReward();
                        Global.currentUser.setFirstDataAllergy(false);
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
