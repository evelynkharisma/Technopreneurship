package com.techno.technopreneurship;

/**
 * Created by User on 4/25/2016.
 */

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.User;

import java.util.Random;

public class ForgotPassword extends Activity {
    Button button;
    EditText email;
    String emailTxt;
    GMailSender sender;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        button = (Button) findViewById(R.id.button);
        email = (EditText) findViewById(R.id.email);
        // Add your mail Id and Password
        sender = new GMailSender("health.secretary.pass@gmail.com", "technopreneurship");

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.
                Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        button.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                emailTxt = email.getText().toString();

                Boolean found = false;
                for (FamilyMember member : Global.familyMembers) {
                    if (member.getEmail().equalsIgnoreCase(emailTxt)) {
                        found = true;
                        Global.currentMainFamilyMember = member;
                        try {
                            new MyAsyncClass().execute();
                        } catch (Exception ex) {
                            Toast.makeText(getApplicationContext(), ex.toString(), 100).show();
                        }
                    }
                }

                if (!found) {
                    Toast.makeText(getApplicationContext(),"Email not registered", 100).show();
                }
            }
        });

    }

    protected String getNewPassword() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it          //     is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    class MyAsyncClass extends AsyncTask<Void, Void, Void> {

        ProgressDialog pDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(ForgotPassword.this);
            pDialog.setMessage("Please wait...");
            pDialog.show();

        }

        @Override
        protected Void doInBackground(Void... mApi) {
            try {
                // Add subject, Body, your mail Id, and receiver mail Id.
                String newPass = getNewPassword();

                for (User current : Global.users) {
                    if (current.getUsername().equalsIgnoreCase(Global.currentMainFamilyMember.getUsername())) {
                        Global.currentUser = current;
                        Global.currentUser.setPassword(newPass);
                    }
                }


                sender.sendMail("Health Secretary Forgot Password", "Here is your new password " + newPass , "health.secretary.pass@gmail.com", emailTxt);
            }

            catch (Exception ex) {

            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            pDialog.cancel();
            Toast.makeText(getApplicationContext(), "Email sent", 100).show();
        }

    }
}