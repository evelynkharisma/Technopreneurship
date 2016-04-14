package com.techno.technopreneurship;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.plus.PlusOneButton;
import com.techno.technopreneurship.Object.Doctor;
import com.techno.technopreneurship.Object.Global;
import com.techno.technopreneurship.Object.Hospital;

import java.util.ArrayList;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link ListHospitalFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListHospitalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListHospitalFragment extends Fragment {
    ArrayList<CheckBox> listDoctorBoxes = new ArrayList<>();

    public ListHospitalFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Global.doctors.clear();
        Global.doctors.add(new Doctor(0, "Dr. William Baak, MD"));
        Global.doctors.add(new Doctor(1, "Dr. Randolph P. Baca Jr., MD"));
        Global.doctors.add(new Doctor(2, "Dr. Richard Bacharach, MD"));
        Global.doctors.add(new Doctor(3, "Dr. John Backman, MD"));
        Global.doctors.add(new Doctor(4, "Dr. Kristin Baker, MD"));


        Global.hospitals.clear();
        Global.hospitals.add(new Hospital(0, "Pertamina Hospital", 1,  "Monday", "07:00", "12:00"));
        Global.hospitals.add(new Hospital(1, "Global Doctor Jakarta Int'l Medical Center ", 2, "Monday", "07:00", "12:00"));
        Global.hospitals.add(new Hospital(2, "Metropolitan Medical Centre (MMC) ", 3, "Tuesday", "07:00", "12:00"));
        Global.hospitals.add(new Hospital(3, "Pertamina Hospital", 4, "Wednesday", "07:00", "12:00"));
        Global.hospitals.add(new Hospital(3, "Pertamina Hospital", 0, "Monday", "07:00", "12:00"));

        final ArrayList<String> listHospital = new ArrayList<>();
        for (Hospital hospital : Global.hospitals) {
            if (!listHospital.contains(hospital.getName())) {
                listHospital.add(hospital.getName());
                Log.i("listHospital", hospital.getName());
            }
        }


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list_hospital, container, false);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.hospitalList_linear);
        linearLayout.removeAllViews();
        for (int i=0; i < listHospital.size(); i++) {

            final TextView hospitalName = new TextView(getActivity());
            hospitalName.setText(listHospital.get(i));
            linearLayout.addView(hospitalName);


            for (Hospital hosp : Global.hospitals) {
                ArrayList<Integer> listDoctorId = new ArrayList<>();
                for (Doctor doc : Global.doctors) {
                    if (hosp.getName().equalsIgnoreCase(listHospital.get(i)) && hosp.getDoctorId() == doc.getId() && !listDoctorBoxes.contains(doc.getId())  ) {
                        CheckBox doctorBox = new CheckBox(getActivity());
                        doctorBox.setId(doc.getId());
                        doctorBox.setText(doc.getName());

                        //check if doctor with id = doc.getId() is in the list of favorite doctors. If so, then check box will set as checked
                        for (Doctor doctorFav : Global.currentUser.getFavorite()) {
                            if (doctorFav.getId()== doc.getId()) {
                                doctorBox.setChecked(true);
                                break;
                            }
                        }
                        listDoctorBoxes.add(doctorBox);
                        linearLayout.addView(doctorBox);
                    }
                }
            }



            Button btnSave = (Button) view.findViewById(R.id.hospitalList_addFavorite);
            btnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Global.currentUser.getFavorite().clear();
                    for (CheckBox chckBox : listDoctorBoxes) {
                        if (chckBox.isChecked()) {
                            Global.currentUser.getFavorite().add(Global.doctors.get(chckBox.getId()));
                            Log.i("added", chckBox.getId() + "");
                        }
                    }
                    Log.i("listHos, btn Save", listHospital.size() + " total hospital");

                    Toast.makeText(getActivity(), "Succesfully Added!", Toast.LENGTH_SHORT).show();
                }
            });

        }
        return view;
    }
}
