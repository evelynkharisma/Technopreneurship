package com.techno.technopreneurship;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.Toast;

import com.techno.technopreneurship.Object.Global;


public class NotificationFragment extends Fragment {

    public NotificationFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_notification, container, false);

        LinearLayout linear = (LinearLayout) view.findViewById(R.id.promotion_linearLayout);

        for (int counter = 0; counter < Global.notifications.size(); counter++) {
            final Button button = new Button (getActivity());
            button.setText(Global.notifications.get(counter));
            button.setId(counter);
            button.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            button.setTextColor(getResources().getColor(R.color.white));
            linear.addView(button);

            Space rowSpace = new Space(getActivity());
            rowSpace.setMinimumHeight(20);
            linear.addView(rowSpace);


            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setTitle(Global.notifications.get(button.getId()));

                    alertDialogBuilder.setMessage("Accept?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(getActivity(), "Accepted", 100).show();
                                    Global.notifications.clear();

                                    //add patient data

                                    NotificationFragment fragment = new NotificationFragment();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                                    fragmentTransaction.commit();
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    Toast.makeText(getActivity(), "Rejected", 100).show();
                                    Global.notifications.clear();
                                    NotificationFragment fragment = new NotificationFragment();
                                    android.support.v4.app.FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
                                    fragmentTransaction.replace(R.id.fragment_container, fragment);
                                    fragmentTransaction.commit();
                                }
                            });

                    // create alert dialog
                    AlertDialog alertDialog = alertDialogBuilder.create();

                    // show it
                    alertDialog.show();
                }
            });
        }

        return view;
    }
}
