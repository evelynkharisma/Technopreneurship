package com.techno.technopreneurship;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.Manifest.permission.READ_CONTACTS;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    Button btn_edit;
    TextView username;
    EditText pass;
    EditText cPass;
    TextView name;
    EditText add;
    EditText email;
    EditText phone;
    TextView day;
    TextView month;
    TextView year;
    TextView ID;
    EditText eName;
    EditText ePhone;
    TextView blood;
    EditText height;
    EditText weight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_edit=(Button)view.findViewById(R.id.profile_btn);
        username =(TextView) view.findViewById(R.id.profile_username);
        pass =(EditText) view.findViewById(R.id.profile_pass_fill);
        cPass =(EditText) view.findViewById(R.id.profile_cPass_fill);
        name= (TextView) view.findViewById(R.id.profile_name_fill);
        add= (EditText) view.findViewById(R.id.profile_add_fill);
        email= (EditText) view.findViewById(R.id.profile_email_fill);
        phone= (EditText) view.findViewById(R.id.profile_phone_fill);
        day= (TextView) view.findViewById(R.id.profile_bday_day_fill);
        month= (TextView) view.findViewById(R.id.profile_bday_month_fill);
        year= (TextView) view.findViewById(R.id.profile_bday_year_fill);
        ID= (TextView) view.findViewById(R.id.profile_ID_fill);
        eName =(EditText) view.findViewById(R.id.profile_EName_fill);
        ePhone= (EditText) view.findViewById(R.id.profile_EPhone_fill);
        blood= (TextView) view.findViewById(R.id.profile_blood_fill);
        height= (EditText) view.findViewById(R.id.profile_height_fill);
        weight= (EditText) view.findViewById(R.id.profile_weight_fill);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return view;
    }
}

