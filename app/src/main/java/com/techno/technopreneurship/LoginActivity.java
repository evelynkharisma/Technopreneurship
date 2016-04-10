package com.techno.technopreneurship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HealthDetails;
import com.techno.technopreneurship.Object.User;

import java.util.Date;

public class LoginActivity extends Activity  {
    Button btn_login;
    Button btn_forgot_pass;
    Button btn_sign_up;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        FamilyMember newFamMember = new FamilyMember("jan", "janis", "Female", "main", "tasik", "janis_giovani@ymail.com", Long.getLong("083827303093"), 31392, "apih",  Long.parseLong("083827303091"));
        User newUser = new User("jan", "123");
        Date myBirthday = new Date();
        myBirthday.setDate(9);
        myBirthday.setMonth(6);
        myBirthday.setYear(96);
        HealthDetails newHealthDetail = new HealthDetails("jan", "janis", myBirthday, 10.00, 10.00);

        Global.users.add(newUser);
        Global.familyMembers.add(newFamMember);
        Global.healthDetailses.add(newHealthDetail);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

        btn_login=(Button)findViewById(R.id.btn_login);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < Global.users.size(); i++) {
                    if (username.getText().toString().equalsIgnoreCase(Global.users.get(i).getUsername()) && password.getText().toString().equals(Global.users.get(i).getPassword())) {
                        //Toast.makeText(getApplicationContext(), "Redirecting...", Toast.LENGTH_SHORT).show();

                        Global.setMainFamilyMember(username.getText().toString());
                        Global.setMainHealthDetail(username.getText().toString(), Global.currentMainFamilyMember.getName());
                        Log.i("login current user", Global.currentMainFamilyMember.getUsername() + "");
                        Log.i("login current Name", Global.currentMainFamilyMember.getName() + "");
                        Log.i("login birthday ", Global.currentMainHealthDetail.getBirthday().toString());


                        Global.currentName = Global.currentMainFamilyMember.getName();
                        Global.currentUsername = Global.currentMainFamilyMember.getUsername();

//                        Log.i("login age", age + "");


                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Not registered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        /*btn_forgot_pass=(Button)findViewById(R.id.btn_forgot_pass);

        btn_forgot_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/

        btn_sign_up=(Button)findViewById(R.id.btn_sign_up);

        btn_sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}