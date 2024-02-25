package com.zybooks.diabeticrunner;

import static java.util.Calendar.getInstance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ImageButton addRunButton;

    private TextView weeklyMileage;
    private TextView weeklyBGStart;
    private TextView weeklyBGEnd;
    private ListView shoeList;
    private Shoe shoeEntry;
    private ArrayList<RunActivity> RunArray = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addRunButton = findViewById(R.id.add_run_button);
        addRunButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

            }
        });
        weeklyMileage = findViewById(R.id.weekly_mileage_text);
        weeklyBGStart = findViewById(R.id.weekly_bg_start_text);
        weeklyBGEnd = findViewById(R.id.weekly_bg_end_text);

        RunActivity runActivity = CreateTestLastRun();

        RunArray.add(runActivity);
        RunActivity lastRun = RunArray.get(RunArray.size() - 1);




        weeklyMileage.setText("10 Miles");
        weeklyBGStart.setText("80 mg/dL");
        weeklyBGEnd.setText("75 mg/dL");

        PopulateLastRunFragment(lastRun);


/*
        //create a arrayList of the type Shoe
        final ArrayList<Shoe> arrayList = new ArrayList<Shoe>();
        //add all the shoes to the arrayList
        arrayList.add(new Shoe("New Balance 1080v13", 300));

        //Now create the instance of the ShoesViewAdapter and pass
        //the context and arrayList created above
        ShoesViewAdapter shoesViewAdapter = new ShoesViewAdapter(this, arrayList);

        //create the instance of the ListView to set the shoesViewAdapter
        ListView shoesListView = findViewById(R.id.shoeList);

        //set the ShoesViewAdapter for ListView
        //shoesListView.setAdapter(shoesViewAdapter);
*/
    }

    public void openNewActivity(){
        Intent intent = new Intent(this, AddRunActivity.class);
        startActivity(intent);
    }

    private RunActivity CreateTestLastRun(){
        Calendar calendar = getInstance();
        calendar.set(2024, Calendar.FEBRUARY,25);
        Date runDate = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String dateTime = simpleDateFormat.format(calendar.getTime()).toString();


        RunActivity runActivity = new RunActivity("Altavista", "10:00", runDate,
                "10:00", 10, "120", "70");

        return runActivity;
    }
    private void PopulateLastRunFragment(RunActivity lastRun){
        // Declaring fragment manager from making data
        // transactions using the custom fragment
        final androidx.fragment.app
                .FragmentManager mFragmentManager
                = getSupportFragmentManager();
        final androidx.fragment.app
                .FragmentTransaction mFragmentTransaction
                = mFragmentManager.beginTransaction();
        final RunActivityFragment mFragment
                = new RunActivityFragment();

        Bundle mBundle = new Bundle();
        mBundle.putString(
                "mParamDescription",
                lastRun.Description);
        mBundle.putString(
                "mParamAvgPace",
                lastRun.AveragePace);
        mBundle.putString(
                "mParamDate",
                lastRun.RunDate.toString());
        mBundle.putString(
                "mParamDistance",
                String.valueOf(lastRun.Distance));
        mBundle.putString(
                "mParamElapsedTime",
                String.valueOf(lastRun.TimeElapsed));
        mBundle.putString(
                "mParamStartBg",
                String.valueOf(lastRun.StarBg));
        mBundle.putString(
                "mParamEndBg",
                String.valueOf(lastRun.EndBg));
        mFragment.setArguments(mBundle);
        mFragmentTransaction
                .add(R.id.fragmentContainerView_last_activity, mFragment)
                .commit();
    }
}