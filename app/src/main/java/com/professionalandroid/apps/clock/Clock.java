package com.professionalandroid.apps.clock;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Clock {
    private long mDate;
    private SimpleDateFormat mHour;
    private SimpleDateFormat mMin;
    private SimpleDateFormat mSec;

    public SimpleDateFormat getHour() { return mHour; }
    public SimpleDateFormat getMin() { return mMin; }
    public SimpleDateFormat getSec() { return mSec; }

    public Clock(long date, SimpleDateFormat hour, SimpleDateFormat min, SimpleDateFormat sec) {
        mHour = hour;
        mDate = date;
        mMin = min;
        mSec = sec;
    }

    @NonNull
    @Override
    public String toString() {
        SimpleDateFormat hour = new SimpleDateFormat("HH");
        SimpleDateFormat min = new SimpleDateFormat("mm");
        SimpleDateFormat sec = new SimpleDateFormat("ss");
        String dateformat1 = hour.format(mDate);
        String dateformat2 = min.format(mDate);
        String dateformat3 = sec.format(mDate);
        return dateformat1 + "시 " + dateformat2 + "분 " + dateformat3 + "초";
    }


}
