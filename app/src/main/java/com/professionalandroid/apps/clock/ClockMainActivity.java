package com.professionalandroid.apps.clock;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ClockMainActivity extends AppCompatActivity {

    private static final String TAG_LIST_FRAGMENT = "TAG_LIST_FRAGMENT";

    ClockListFragment mClockListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clock_main);

        FragmentManager fm = getSupportFragmentManager();

        if(savedInstanceState == null){
            FragmentTransaction ft = fm.beginTransaction();

            mClockListFragment = new ClockListFragment();
            ft.add(R.id.main_activity_frame, mClockListFragment, TAG_LIST_FRAGMENT);

            ft.commitNow();
        } else {
            mClockListFragment = (ClockListFragment)fm.findFragmentByTag(TAG_LIST_FRAGMENT);
        }


        long now = System.currentTimeMillis();
        Date date = new Date(now);
        SimpleDateFormat hour = new SimpleDateFormat("HH");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        SimpleDateFormat sec = new SimpleDateFormat("ss");
        List<Clock> dummyClocks = new ArrayList<Clock>(0);
        dummyClocks.add(new Clock(now, hour, min, sec));

        mClockListFragment.setmClock(dummyClocks);
    }
}