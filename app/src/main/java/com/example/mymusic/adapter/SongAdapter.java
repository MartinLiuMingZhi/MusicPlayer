package com.example.mymusic.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.R;
import com.example.mymusic.entity.Song;
import com.example.mymusic.util.Constant;

import java.util.ArrayList;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.SongViewHolder> {
    private ArrayList<Song> songs;
    private Activity activity;
    private int choice = 0;
    public SongAdapter(ArrayList<Song> songs, Activity activity) {
        this.songs = songs;
        this.activity = activity;
    }

    @NonNull
    @Override
    public SongViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_song, parent, false);
        SongViewHolder holder = new SongViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SongViewHolder holder, int position) {
        Song song = songs.get(position);
        holder.name.setText(song.getName());
        holder.author.setText(song.getAuthor());
        if (position == choice) holder.view.setBackgroundColor(activity.getResources().getColor(R.color.teal_200));
        else holder.view.setBackgroundColor(activity.getResources().getColor(R.color.white));
        holder.view.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int t =choice;
                choice = holder.getAdapterPosition();
                if(t!=-1)notifyItemChanged(t);
                notifyItemChanged(holder.getAdapterPosition());

                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");

                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.CHOICE);
                intent.putExtra(Constant.INDEX,holder.getAdapterPosition());
                activity.sendBroadcast(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    static class SongViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView author;
        private View view;
        public SongViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            author = itemView.findViewById(R.id.author);
            view = itemView;
        }
    }
}

