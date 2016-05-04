package com.techno.technopreneurship;

import android.content.Context;
import android.content.Intent;
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

import java.util.ArrayList;

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

        ArrayList<Button> buttons = new ArrayList<>();
        buttons.add(btnThreeMember);
        buttons.add(btnAllergy);
        buttons.add(btnBloodCount);
        buttons.add(btnBloodTension);
        buttons.add(btnCholesterol);
        buttons.add(btnDiabetes);
        buttons.add(btnHeartRate);
        buttons.add(btnOneYear);
        buttons.add(btnUricAcid);
        buttons.add(btnUrineTest);
        buttons.add(btnVaccine);

        for (int row = 0; row < Global.currentReward.size(); row++) {
            if (Global.currentReward.get(row).getAvailable() && !Global.currentReward.get(row).getUsed()) {
                if (Global.currentReward.get(row).getType().equalsIgnoreCase("first three member")) {
                    btnThreeMember.setId(row);
                    btnThreeMember.setEnabled(true);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("allergy")) {
                    btnAllergy.setEnabled(true);
                    btnAllergy.setId(row);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("blood count")) {
                    btnBloodCount.setEnabled(true);
                    btnBloodCount.setId(row);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("blood tension")) {
                    btnBloodTension.setEnabled(true);
                    btnBloodTension.setId(row);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("cholesterol")) {
                    btnCholesterol.setEnabled(true);
                    btnCholesterol.setId(row);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("diabetes")) {
                    btnDiabetes.setEnabled(true);
                    btnDiabetes.setId(5);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("heart rate")) {
                    btnHeartRate.setEnabled(true);
                    btnHeartRate.setId(6);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("uric acid")) {
                    btnUricAcid.setEnabled(true);
                    btnUricAcid.setId(7);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("urine test")) {
                    btnUrineTest.setEnabled(true);
                    btnUrineTest.setId(8);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("vaccine")) {
                    btnVaccine.setEnabled(true);
                    btnVaccine.setId(9);
                } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("one year")) {
                    btnOneYear.setEnabled(true);
                    btnOneYear.setId(10);
                }
            }
        }

        for (final Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Global.clickedRewardId = button.getId();
                    Intent intent = new Intent(getActivity(), RedeemRewardActivity.class);
                    startActivity(intent);
                }
            });
        }

        return view;
    }
}
