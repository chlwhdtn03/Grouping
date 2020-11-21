package com.chlwhdtn.grouping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chlwhdtn.grouping.Data.Group;
import com.chlwhdtn.grouping.Data.Schedule;
import com.chlwhdtn.grouping.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {

    public ArrayList<Schedule> list = new ArrayList<>();

    public void setData(ArrayList<Schedule> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.date.setText(list.get(position).getDate());
        holder.group.setText(list.get(position).getLocation());
        holder.title.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView title, date, group;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_schedule_title);
            group = itemView.findViewById(R.id.item_schedule_owner);
            date = itemView.findViewById(R.id.item_schedule_date);
        }


    }

}
