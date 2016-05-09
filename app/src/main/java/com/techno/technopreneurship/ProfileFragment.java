package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.techno.technopreneurship.Object.Global;

import java.util.Date;

public class ProfileFragment extends Fragment {
    public ProfileFragment() {
        // Required empty public constructor
    }

    Button btn_edit;
    EditText username;
    TextView gender;

    EditText pass;
    EditText cPass;
    EditText name;
    EditText add;
    EditText email;
    EditText phone;
    EditText day;
    EditText month;
    EditText year;
    EditText ID;
    EditText eName;
    EditText ePhone;
    EditText blood;
    EditText height;
    EditText weight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_edit=(Button)view.findViewById(R.id.profile_btn);
        username =(EditText) view.findViewById(R.id.profile_username_fill);
        username.setText(Global.currentUser.getUsername());
        pass =(EditText) view.findViewById(R.id.profile_pass_fill);
        pass.setText(Global.currentUser.getPassword().toCharArray(), 0, Global.currentUser.getPassword().toString().length());
        cPass =(EditText) view.findViewById(R.id.profile_cPass_fill);
        cPass.setText(Global.currentUser.getPassword().toCharArray(), 0, Global.currentUser.getPassword().toString().length());
        name= (EditText) view.findViewById(R.id.profile_name_fill);
        name.setText(Global.currentMainFamilyMember.getName());
        gender = (TextView) view.findViewById(R.id.profile_gender_fill);
        gender.setText(Global.currentMainFamilyMember.getGender());
        add= (EditText) view.findViewById(R.id.profile_add_fill);
        add.setText(Global.currentMainFamilyMember.getAddress());
        email= (EditText) view.findViewById(R.id.profile_email_fill);
        email.setText(Global.currentMainFamilyMember.getEmail());
        phone= (EditText) view.findViewById(R.id.profile_phone_fill);

        phone.setText(String.valueOf(Global.currentMainFamilyMember.getPhone()));
        day= (EditText) view.findViewById(R.id.profile_bday_day_fill);
        day.setText(String.valueOf(Global.currentMainHealthDetail.getBirthday().getDay()));

        month= (EditText) view.findViewById(R.id.profile_bday_month_fill);
        month.setText(String.valueOf(Global.currentMainHealthDetail.getBirthday().getMonth()));
        year= (EditText) view.findViewById(R.id.profile_bday_year_fill);
        year.setText(String.valueOf(Global.currentMainHealthDetail.getBirthday().getYear()));
        ID= (EditText) view.findViewById(R.id.profile_ID_fill);
        ID.setText(String.valueOf(Global.currentMainFamilyMember.getKtp()));
        eName =(EditText) view.findViewById(R.id.profile_EName_fill);
        eName.setText(Global.currentMainFamilyMember.getEmergencyName());
        ePhone= (EditText) view.findViewById(R.id.profile_EPhone_fill);
        ePhone.setText(String.valueOf(Global.currentMainFamilyMember.getEmergencyPhone()));
        blood= (EditText) view.findViewById(R.id.profile_blood_fill);
        blood.setText(Global.currentMainHealthDetail.getBloodType());
        height= (EditText) view.findViewById(R.id.profile_height_fill);
        height.setText(String.valueOf(Global.currentMainHealthDetail.getHeight()));
        weight= (EditText) view.findViewById(R.id.profile_weight_fill);
        weight.setText(String.valueOf(Global.currentMainHealthDetail.getWeight()));

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pass.getText().toString().equals(cPass.getText().toString())) {
                    Global.currentUser.setPassword(pass.getText().toString());
                }

                Date bday = new Date();
                bday.setYear(Integer.parseInt(year.getText().toString()) - 1900);
                bday.setMonth(Integer.parseInt(month.getText().toString()));
                bday.setDate(Integer.parseInt(day.getText().toString()));

                Global.currentMainFamilyMember.setName(name.getText().toString());
                Global.currentMainFamilyMember.setAddress(add.getText().toString());
                Global.currentMainFamilyMember.setEmail(email.getText().toString());
                Global.currentMainFamilyMember.setPhone(Long.parseLong(phone.getText().toString()));
                Global.currentMainFamilyMember.setKtp(Integer.parseInt(ID.getText().toString()));
                Global.currentMainFamilyMember.setEmergencyName(eName.getText().toString());
                Global.currentMainFamilyMember.setEmergencyPhone(Long.parseLong(ePhone.getText().toString()));

                Global.currentMainHealthDetail.setBloodType(blood.getText().toString());
                Global.currentMainHealthDetail.setHeight(Long.parseLong(height.getText().toString()));
                Global.currentMainHealthDetail.setWeight(Long.parseLong(weight.getText().toString()));
                Global.currentMainHealthDetail.setBirthday(bday);

            }
        });

        return view;
    }
}

