package com.chlwhdtn.grouping.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chlwhdtn.grouping.Data.Group;
import com.chlwhdtn.grouping.GroupInfoActivity;
import com.chlwhdtn.grouping.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.ViewHolder> {

    private ArrayList<Group> list = new ArrayList<>();
    private Context context;

    public GroupAdapter(Context context) {
        this.context = context;
    }

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
        holder.itemView.setOnClickListener(item -> {
            Intent intent = new Intent(context, GroupInfoActivity.class);
            intent.putExtra("code", list.get(position).getInviteCode());
            intent.putExtra("name", list.get(position).getTitle());
            Gson gson = new Gson();
            String[] member = gson.fromJson(gson.toJson(list.get(position).getMember()), String[].class);
            intent.putExtra("member", member);
            context.startActivity(intent);
        });
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
