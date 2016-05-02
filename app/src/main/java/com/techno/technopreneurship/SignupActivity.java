package com.techno.technopreneurship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HealthDetails;
import com.techno.technopreneurship.Object.User;

import java.util.Date;

public class SignupActivity extends Activity {
    Button btn_sign_up;
    EditText username;
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
    RadioGroup gender;
    String genderClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_sign_up=(Button)findViewById(R.id.sign_up_btn_sign_up);
        username =(EditText) findViewById(R.id.sign_up_username_fill);
        pass =(EditText) findViewById(R.id.sign_up_pass_fill);
        cPass =(EditText) findViewById(R.id.sign_up_cPass_fill);
        name= (EditText) findViewById(R.id.sign_up_name_fill);
        gender = (RadioGroup) findViewById(R.id.sign_up_gender_fill);
        add= (EditText) findViewById(R.id.sign_up_add_fill);
        email= (EditText) findViewById(R.id.sign_up_email_fill);
        phone= (EditText) findViewById(R.id.sign_up_phone_fill);
        day= (EditText) findViewById(R.id.sign_up_bday_day_fill);
        month= (EditText) findViewById(R.id.sign_up_bday_month_fill);
        year= (EditText) findViewById(R.id.sign_up_bday_year_fill);
        ID= (EditText) findViewById(R.id.sign_up_ID_fill);
        eName =(EditText) findViewById(R.id.sign_up_EName_fill);
        ePhone= (EditText) findViewById(R.id.sign_up_EPhone_fill);
        blood= (EditText) findViewById(R.id.sign_up_blood_fill);
        height= (EditText) findViewById(R.id.sign_up_height_fill);
        weight= (EditText) findViewById(R.id.sign_up_weight_fill);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equalsIgnoreCase(null) || pass.getText().toString().equalsIgnoreCase(null) || cPass.getText().toString().equalsIgnoreCase(null) ||
                        name.getText().toString().equalsIgnoreCase(null) || add.getText().toString().equalsIgnoreCase(null) || email.getText().toString().equalsIgnoreCase(null) ||
                        phone.getText().toString().equalsIgnoreCase(null) || day.getText().toString().equalsIgnoreCase(null) || month.getText().toString().equalsIgnoreCase(null) ||
                        year.getText().toString().equalsIgnoreCase(null) || ID.getText().toString().equalsIgnoreCase(null) || eName.getText().toString().equalsIgnoreCase(null) ||
                        ePhone.getText().toString().equalsIgnoreCase(null) || blood.getText().toString().equalsIgnoreCase(null) || height.getText().toString().equalsIgnoreCase(null) ||
                        weight.getText().toString().equalsIgnoreCase(null) || (gender.getCheckedRadioButtonId() == -1)) {

                    Toast.makeText(getApplicationContext(), "You must fill all information!", Toast.LENGTH_SHORT).show();
                    username.requestFocus();
                } else if (!pass.getText().toString().equals(cPass.getText().toString())) {
                    pass.setText("");
                    cPass.setText("");
                    pass.requestFocus();

                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_SHORT).show();
                } else {
                    Date bday = new Date();
                    bday.setYear(Integer.parseInt(year.getText().toString())-1900);
                    bday.setMonth(Integer.parseInt(month.getText().toString()));
                    bday.setDate(Integer.parseInt(day.getText().toString()));

                    User newUser = new User(username.getText().toString(), pass.getText().toString());

                    FamilyMember newFamMember = new FamilyMember(username.getText().toString(), name.getText().toString(), genderClicked, "main", add.getText().toString(),
                            email.getText().toString(), Long.parseLong(phone.getText().toString()), Integer.parseInt(ID.getText().toString()), eName.getText().toString(),
                            Long.parseLong(ePhone.getText().toString()));

                    HealthDetails newHealthDetail = new HealthDetails(username.getText().toString(), name.getText().toString(), blood.getText().toString(), bday, Double.parseDouble(weight.getText().toString()), Double.parseDouble(height.getText().toString()));

                    Global.users.add(newUser);
                    Global.familyMembers.add(newFamMember);
                    Global.healthDetailses.add(newHealthDetail);
                    Global.currentName = newFamMember.getName();
                    Global.currentUsername = newFamMember.getUsername();
                    Global.currentMainFamilyMember = newFamMember;
                    Global.currentMainHealthDetail = newHealthDetail;

                    Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }

        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.sign_up_female:
                if (checked) {
                    genderClicked = "Female";
                    break;
                }
            case R.id.sign_up_male :
                if (checked) {
                    genderClicked = "Male";
                    break;
                }
        }
    }
}

