package com.zybooks.diabeticrunner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RunActivityFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RunActivityFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_DESCRIPTION = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam_Description;
    private String mParam2;

    private TextView mActivityDescription;
    private TextView mActivityAveragePace;
    private TextView mActivityDate;
    private TextView mActivityElapsedTime;
    private TextView mActivityDistance;
    private TextView mActivityStartBg;
    private TextView mActivityEndbg;

    public RunActivityFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RunActivityFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RunActivityFragment newInstance(String param1, String param2) {
        RunActivityFragment fragment = new RunActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_DESCRIPTION, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam_Description = getArguments().getString(ARG_DESCRIPTION);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflates the custom fragment layout
        View view = inflater.inflate(
                R.layout.fragment_run_activity, container, false);
        mActivityDescription = (TextView)view.findViewById(
                R.id.activity_description);
        mActivityAveragePace = (TextView)view.findViewById(R.id.activity_avg_pace);
        mActivityDate = (TextView)view.findViewById(R.id.activity_date);
        mActivityElapsedTime = (TextView)view.findViewById(R.id.activity_elapsed_time);
        mActivityDistance = (TextView)view.findViewById(R.id.activity_distance);
        mActivityStartBg = (TextView)view.findViewById(R.id.activity_bg_start);
        mActivityEndbg = (TextView)view.findViewById(R.id.activity_bg_end);

        // Gets the data from the passed bundle
        Bundle bundle = getArguments();
        if (bundle != null){
            String runDescription = bundle.getString("mParamDescription");
            String runAveragePace = bundle.getString("mParamAvgPace");
            String runDate = bundle.getString("mParamDate");
            String runElapsedTime = bundle.getString("mParamElapsedTime");
            String runDistance = bundle.getString("mParamDistance") + " " + getString(R.string.distance_measurement);
            String runStartBg = bundle.getString("mParamStartBg");
            String runEndBg = bundle.getString("mParamEndBg");

            // Sets the derived data (type String) in the
            // TextView
            mActivityDescription.setText(runDescription);
            mActivityAveragePace.setText(runAveragePace);
            mActivityDate.setText(runDate);
            mActivityElapsedTime.setText(runElapsedTime);
            mActivityDistance.setText(runDistance);
            mActivityStartBg.setText(runStartBg);
            mActivityEndbg.setText(runEndBg);
        }




        return view;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_run_activity, container, false);
    }
}