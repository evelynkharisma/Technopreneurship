package com.techno.technopreneurship;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Space;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.google.android.gms.plus.PlusOneButton;
import com.techno.technopreneurship.Object.Global;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link RewardsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RewardsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RewardsFragment extends Fragment {
    private static final int NUM_COLS = 1;

    public RewardsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        Button btnThreeMember = (Button)  view.findViewById(R.id.rewards_addThreeMember);
        Button btnAllergy = (Button)  view.findViewById(R.id.rewards_firstDataAllergy);
        Button btnBloodCount = (Button)  view.findViewById(R.id.rewards_firstDataBloodCount);
        Button btnBloodTension = (Button)  view.findViewById(R.id.rewards_firstDataBloodTension);
        Button btnCholesterol = (Button)  view.findViewById(R.id.rewards_firstDataCholesterol);
        Button btnDiabetes = (Button)  view.findViewById(R.id.rewards_firstDataDiabetes);
        Button btnHeartRate = (Button)  view.findViewById(R.id.rewards_firstDataHeartRate);
        Button btnUricAcid = (Button)  view.findViewById(R.id.rewards_firstDataUricAcid);
        Button btnUrineTest = (Button)  view.findViewById(R.id.rewards_firstDataUrineTest);
        Button btnVaccine = (Button)  view.findViewById(R.id.rewards_firstDataVaccine);
        Button btnOneYear = (Button)  view.findViewById(R.id.rewards_oneYear);


        for (int row = 0; row < Global.currentReward.size(); row++) {

            if (Global.currentReward.get(row).getAvailable()) {
                if (Global.currentReward.get(row).getType().equalsIgnoreCase("first three member")) {
                    btnThreeMember.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("allergy")) {
                    btnAllergy.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("blood count")) {
                    btnBloodCount.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("blood tension")) {
                    btnBloodTension.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("cholesterol")) {
                    btnCholesterol.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("diabetes")) {
                    btnDiabetes.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("heart rate")) {
                    btnHeartRate.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("uric acid")) {
                    btnUricAcid.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("urine test")) {
                    btnUrineTest.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("vaccine")) {
                    btnVaccine.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("one year")) {
                    btnOneYear.setEnabled(true);
                }
            }
        }

        return view;
    }
}
