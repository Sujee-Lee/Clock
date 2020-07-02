package com.professionalandroid.apps.clock;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ClockListFragment extends Fragment {
    private ArrayList<Clock> mClock = new ArrayList<Clock>();
    private RecyclerView mRecyclerView;
    private ClockRecyclerViewAdapter mClockAdapter = new ClockRecyclerViewAdapter(mClock);

    public ClockListFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_clock_list, container, false);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.list);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Context context = view.getContext();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(context));
        mRecyclerView.setAdapter(mClockAdapter);
    }

    public void setmClock(List<Clock> clocks) {
        for(Clock clock : clocks) {
            if(!mClock.contains(clock)){
                mClock.add(clock);
                mClockAdapter.notifyItemChanged(mClock.indexOf(clock));
            }
        }
    }
}
