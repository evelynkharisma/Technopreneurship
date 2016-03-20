package com.techno.technopreneurship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import static android.Manifest.permission.READ_CONTACTS;

public class SignupActivity extends Activity {
    Button btn_sign_up;
    EditText name;
    EditText add;
    EditText email;
    EditText phone;
    EditText day;
    EditText month;
    EditText year;
    EditText ID;
    EditText gPhone;
    EditText blood;
    EditText height;
    EditText weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btn_sign_up=(Button)findViewById(R.id.sign_up_btn_sign_up);
        name= (EditText) findViewById(R.id.sign_up_name_fill);
        add= (EditText) findViewById(R.id.sign_up_add_fill);
        email= (EditText) findViewById(R.id.sign_up_email_fill);
        phone= (EditText) findViewById(R.id.sign_up_phone_fill);
        day= (EditText) findViewById(R.id.sign_up_bday_day_fill);
        month= (EditText) findViewById(R.id.sign_up_bday_month_fill);
        year= (EditText) findViewById(R.id.sign_up_bday_year_fill);
        ID= (EditText) findViewById(R.id.sign_up_ID_fill);
        gPhone= (EditText) findViewById(R.id.sign_up_GPhone_fill);
        blood= (EditText) findViewById(R.id.sign_up_blood_fill);
        height= (EditText) findViewById(R.id.sign_up_height_fill);
        weight= (EditText) findViewById(R.id.sign_up_weight_fill);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}

