package com.techno.technopreneurship;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.techno.technopreneurship.Object.Blood_Count;
import com.techno.technopreneurship.Object.Blood_Tension;
import com.techno.technopreneurship.Object.Cholesterol;
import com.techno.technopreneurship.Object.Diabetes;
import com.techno.technopreneurship.Object.FamilyMember;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.HealthDetails;
import com.techno.technopreneurship.Object.HeartRate;
import com.techno.technopreneurship.Object.UricAcid;
import com.techno.technopreneurship.Object.UrineTest;
import com.techno.technopreneurship.Object.User;
import com.techno.technopreneurship.Object.Vaccine;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Splashscreen  extends Activity {
    //Set waktu lama splashscreen
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.splashscreen);


        Global.promotions.add(R.drawable.hospital_poster);
        Global.promotions.add(R.drawable.hospital_poster2);

        FamilyMember newFamMember = new FamilyMember("jan", "janis", "Female", "main", "tasik", "janis_giovani@ymail.com", Long.parseLong("083827303093"), 31392, "apih",  Long.parseLong("083827303091"));
        User newUser = new User("jan", "123");
        Date myBirthday = new Date();
        myBirthday.setDate(9);
        myBirthday.setMonth(6);
        myBirthday.setYear(96);
        HealthDetails newHealthDetail = new HealthDetails("jan", "janis", "a", myBirthday, 10.00, 10.00);

        Global.users.add(newUser);
        Global.familyMembers.add(newFamMember);
        Global.healthDetailses.add(newHealthDetail);

        FamilyMember newFamMember2 = new FamilyMember("eve", "Evelyn Kharisma", "Female", "main", "BINUS Square", "kharismaeve@gmail.com", Long.getLong("08117678877"), 12345, "mom",  Long.parseLong("08127518680"));
        User newUser2 = new User("eve", "123");
        Date myBirthday2 = new Date();
        myBirthday2.setDate(26);
        myBirthday2.setMonth(11);
        myBirthday2.setYear(94);
        HealthDetails newHealthDetail2 = new HealthDetails("eve", "Evelyn Kharisma", "A", myBirthday2, 10.00, 10.00);

        Global.users.add(newUser2);
        Global.familyMembers.add(newFamMember2);
        Global.healthDetailses.add(newHealthDetail2);

        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateFormat = formatter.format(today);

        Blood_Count newBloodCount = new Blood_Count(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 135, 120, 150);
        Global.bloodCounts.add(newBloodCount);

        Blood_Tension newBloodTension = new Blood_Tension(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 90, 110);
        Global.bloodTensions.add(newBloodTension);

        Cholesterol newCholesterol = new Cholesterol(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 170, 175, 190);
        Global.cholesterols.add(newCholesterol);
        Cholesterol newCholesterol2 = new Cholesterol(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 155, 160, 200);
        Global.cholesterols.add(newCholesterol2);
        Cholesterol newCholesterol3 = new Cholesterol(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 160, 200, 220);
        Global.cholesterols.add(newCholesterol3);
        Cholesterol newCholesterol4 = new Cholesterol(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 130, 145, 175);
        Global.cholesterols.add(newCholesterol4);

        Diabetes newDiabet = new Diabetes(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 80);
        Global.diabeteses.add(newDiabet);

        HeartRate newHeartRate = new HeartRate(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 80);
        Global.heartRates.add(newHeartRate);

        UricAcid newUricAcid = new UricAcid(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, 75);
        Global.uricAcids.add(newUricAcid);

        UrineTest newUrineTest = new UrineTest(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, false, false, false);
        Global.urineTests.add(newUrineTest);

        Vaccine newVaccine = new Vaccine(newFamMember2.getUsername(), newFamMember2.getName(), dateFormat, "Hepatitis B", "1");
        Global.vaccines.add(newVaccine);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                Intent i = new Intent(Splashscreen.this, LoginActivity.class);
                startActivity(i);

                //jeda selesai Splashscreen
                this.finish();
            }

            private void finish() {
                // TODO Auto-generated method stub

            }
        }, splashInterval);

    };
}
