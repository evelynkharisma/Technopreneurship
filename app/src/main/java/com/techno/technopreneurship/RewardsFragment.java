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

    public RewardsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.fragment_rewards, container, false);

        TableLayout table = (TableLayout) view.findViewById(R.id.rewardsTable);

        for (int row = 0; row < Global.currentReward.size(); row++) {
            TableRow tableRow = new TableRow(getActivity());
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT, 100
            ));
            table.addView(tableRow);
            for (int column = 0; column < NUM_COLS; column++) {
                final Button folderButton = new Button(getActivity());
                folderButton.setId(row);

                if (Global.currentReward.get(row).getAvailable()) {
                    if (Global.currentReward.get(row).getType().equalsIgnoreCase("first three member")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.son, 0, 0, 0);
                        folderButton.setText("  First Three Member Added");
                    } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("first data in each category")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.daughter, 0, 0, 0);
                        folderButton.setText("  Your First Data Entry");
                    } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("first time request from hospital")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.mother, 0, 0, 0);
                        folderButton.setText("  First Request from Hospital");
                    } else if (Global.currentReward.get(row).getType().equalsIgnoreCase("one year")) {
                        folderButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.father, 0, 0, 0);
                        folderButton.setText("  One Year!");
                    }


                    folderButton.setPadding(40, 30, 0, 30);
                    folderButton.setTextSize(12);
                    folderButton.setBackgroundColor(getResources().getColor(R.color.transparent_background));
                    folderButton.setGravity(Gravity.LEFT);
                    folderButton.setGravity(Gravity.CENTER_VERTICAL);

                    folderButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            int choosen = folderButton.getId();

                            Log.i("reward folder clicked", folderButton.getText() + "");

//                            CategoryFragment fragment = new CategoryFragment();
//                            android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
//                            fragmentTransaction.replace(R.id.fragment_container, fragment);
//                            fragmentTransaction.commit();
                        }
                    });

                    tableRow.addView(folderButton);
                }
            }
            View line = new View(getActivity());
            TableRow.LayoutParams separatorLayoutParams = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 2);
            separatorLayoutParams.setMargins(100, 0, 0, 0);
            line.setBackgroundColor(Color.GRAY);
            table.addView(line, separatorLayoutParams);

            Space rowSpace = new Space(getActivity());
            rowSpace.setMinimumHeight(20);
            table.addView(rowSpace);
        }
        /////////////////////////////////////////Create Family List End//////////////////////////////////////////////////////

        return view;
    }
}
