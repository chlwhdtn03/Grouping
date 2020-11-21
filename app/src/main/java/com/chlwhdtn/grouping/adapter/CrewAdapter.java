package com.chlwhdtn.grouping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chlwhdtn.grouping.Data.Schedule;
import com.chlwhdtn.grouping.Data.User;
import com.chlwhdtn.grouping.R;

import java.util.ArrayList;

public class CrewAdapter extends RecyclerView.Adapter<CrewAdapter.ViewHolder> {

    public ArrayList<User> list;

    public CrewAdapter(ArrayList<User> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CrewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CrewAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_crew, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CrewAdapter.ViewHolder holder, int position) {
        holder.name.setText(list.get(position).getUsername());
    }

    @Override
    public int getItemCount() {

        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_crew_name);
        }


    }

}
