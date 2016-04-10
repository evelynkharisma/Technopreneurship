package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Allergy;
import com.techno.technopreneurship.Object.Global;

public class AddAllergyFragment extends Fragment {

    EditText allergy;
    Button addAllergy;

    public AddAllergyFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_allergy, container, false);

        //////////////////////////////////////Determine which user and which member////////////////////////////////
//        final Bundle bundle = this.getArguments();
//        final String currentUser = bundle.getString("cuser");
//        final String currentName = bundle.getString("cname");

        allergy = (EditText) view.findViewById(R.id.add_allergy_fill);
        addAllergy = (Button) view.findViewById(R.id.add_allergy_btn);

        addAllergy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(allergy == null)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "allergy need to be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    AllergyFragment fragment = new AllergyFragment();
                    Allergy newAllergy = new Allergy(Global.currentUsername, Global.currentName, allergy.getText().toString());

                    Global.allergies.add(newAllergy);
                    Global.updateCurrentAllergy();

                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                    fragmentTransaction.commit();
                }
            }
        });

        return view;
    }
}
