package com.techno.technopreneurship;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.techno.technopreneurship.Object.Global;

/**
 * A fragment with a Google +1 button.
 * Activities that contain this fragment must implement the
 * {@link PromotionFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link PromotionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PromotionFragment extends Fragment {

    public PromotionFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promotion, container, false);

        LinearLayout linear = (LinearLayout) view.findViewById(R.id.promotion_linearLayout);

        Global.promotions.add(R.drawable.hospital_poster);
        Global.promotions.add(R.drawable.hospital_poster2);

        for (int counter = 0; counter < Global.promotions.size(); counter++) {
            ImageView imageView = new ImageView(getActivity());
            imageView.setImageResource(Global.promotions.get(counter));
            linear.addView(imageView);

        }
        return view;
    }
}
