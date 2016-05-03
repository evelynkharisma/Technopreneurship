package com.techno.technopreneurship;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.gms.plus.PlusOneButton;
import com.techno.technopreneurship.Object.Doctor;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Hospital;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link FavoriteDoctorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FavoriteDoctorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteDoctorFragment extends Fragment {

    public FavoriteDoctorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_favorite_doctor, container, false);


        TableLayout table = (TableLayout) view.findViewById(R.id.FavDoctor_Table);

        //Set category list for the table column header
        TableRow tableRow = new TableRow(getActivity());
        tableRow.setId(10);
        tableRow.setBackgroundColor(getResources().getColor(R.color.table));
        tableRow.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.FILL_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));

        TextView label_date = new TextView(getActivity());
        label_date.setId(20);
        label_date.setText("Doctor's Name");
        label_date.setPadding(7, 5, 7, 5);
        tableRow.addView(label_date);

        TextView label_day = new TextView(getActivity());
        label_day.setId(21);
        label_day.setText("Day");
        label_day.setPadding(7, 5, 7, 5);
        tableRow.addView(label_day);

        TextView label_hdl = new TextView(getActivity());
        label_hdl.setId(22);
        label_hdl.setText("Start");
        label_hdl.setPadding(7, 5, 7, 5);
        tableRow.addView(label_hdl);

        TextView label_ldl = new TextView(getActivity());
        label_ldl.setId(23);
        label_ldl.setText("End");
        label_ldl.setPadding(7, 5, 7, 5);
        tableRow.addView(label_ldl);

        TextView label_total = new TextView(getActivity());
        label_total.setId(24);
        label_total.setText("Hospital");
        label_total.setPadding(7, 5, 7, 5);
        tableRow.addView(label_total);

        table.addView(tableRow);


        Integer count=0;

        for (Hospital hos : Global.hospitals) {
            for (Doctor doc : Global.currentUser.getFavorite()) {
                if (doc.getId() == hos.getDoctorId()) {
                    TableRow tr = new TableRow(getActivity());
                    if(count%2!=0) tr.setBackgroundColor(getResources().getColor(R.color.table));
                    tr.setId(100 + count);
                    tr.setLayoutParams(new FrameLayout.LayoutParams(
                            FrameLayout.LayoutParams.FILL_PARENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT));

                    TextView labelDoctorName = new TextView(getActivity());
                    labelDoctorName.setId(200 + count);
                    labelDoctorName.setMaxWidth(20);
                    labelDoctorName.setText(doc.getName());
                    labelDoctorName.setPadding(7, 35, 7, 55);
                    tr.addView(labelDoctorName);

                    TextView labelDay = new TextView(getActivity());
                    labelDay.setId(200 + count);
                    labelDay.setText(hos.getDay());
                    tr.addView(labelDay);

                    TextView labelStartTime = new TextView(getActivity());
                    labelStartTime.setId(200 + count);
                    labelStartTime.setText(hos.getStartTime());
                    tr.addView(labelStartTime);

                    TextView labelEndTime = new TextView(getActivity());
                    labelEndTime.setId(200 + count);
                    labelEndTime.setText(hos.getEndTime());
                    tr.addView(labelEndTime);

                    TextView labelHospitalName = new TextView(getActivity());
                    labelHospitalName.setId(200 + count);
                    labelHospitalName.setMaxWidth(20);
                    labelHospitalName.setText(hos.getName());
                    tr.addView(labelHospitalName);

                    // finally add this table row tr to the table row tableRow
                    table.addView(tr, new TableLayout.LayoutParams(
                            FrameLayout.LayoutParams.FILL_PARENT,
                            FrameLayout.LayoutParams.WRAP_CONTENT));
                    count++;
                }
            }
        }
        return view;
    }
}