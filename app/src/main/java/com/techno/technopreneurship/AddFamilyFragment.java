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

public class AddFamilyFragment extends Fragment {

    FamilyFragment familyFragment;
    private String fam_user = "user";
    private String fam_name;
    private String fam_status;
    Spinner dropdown;
    EditText name;
    Button btn_add;
    public AddFamilyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_add_family, container, false);

        dropdown = (Spinner)view.findViewById(R.id.spinner1);
        name = (EditText) view.findViewById(R.id.add_name_fill);
        btn_add = (Button) view.findViewById(R.id.add_btn);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name == null || dropdown == null)
                {
                    Toast.makeText(getActivity().getApplicationContext(), "name and status need to be filled", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    //fam_name = name.toString();
                    //fam_status = dropdown.getSelectedItem().toString();
                    //familyFragment.fm.add(new FamilyMember(fam_user, fam_name, fam_status));
                    FamilyFragment fragment = new FamilyFragment();
                    Bundle bundle = new Bundle();
                    //bundle.putInt("isAddFam",1);      //klw ada bundle lain slain dari addfamilyfragment
                    bundle.putString("add_fam_name", name.getText().toString());
                    bundle.putString("add_fam_status", dropdown.getSelectedItem().toString());
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
