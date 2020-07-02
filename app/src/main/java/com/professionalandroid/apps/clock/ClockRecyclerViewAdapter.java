package com.professionalandroid.apps.clock;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ClockRecyclerViewAdapter extends RecyclerView.Adapter<ClockRecyclerViewAdapter.ViewHolder> {

    private final List<Clock> mClock;

    public ClockRecyclerViewAdapter(List<Clock> clocks){
        mClock = clocks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_clock, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.clock = mClock.get(position);
        holder.detailsView.setText(mClock.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return mClock.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View parentView;
        public final TextView detailsView;
        public Clock clock;


        public ViewHolder(@NonNull View view) {
            super(view);
            parentView = view;
            detailsView = (TextView)view.findViewById(R.id.list_item_clock_details);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + detailsView.getText()+"'";
        }
    }
}
