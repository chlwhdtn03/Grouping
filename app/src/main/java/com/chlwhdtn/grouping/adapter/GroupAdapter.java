package com.chlwhdtn.grouping.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chlwhdtn.grouping.Data.Group;
import com.chlwhdtn.grouping.R;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private ArrayList<Group> list = new ArrayList<>();

    public void setData(ArrayList<Group> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public GroupAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_group,parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GroupAdapter.ViewHolder holder, int position) {
        String text = list.get(position).getTitle();
        holder.tv.setText(text);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ViewHolder(View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.item_group_title);
        }
    }
}
