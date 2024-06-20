package com.example.mymusic.fragment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.mymusic.R;
import com.example.mymusic.entity.Song;
import com.example.mymusic.util.Constant;
import com.example.mymusic.util.Data;

import java.io.IOException;
import java.util.Objects;


public class Fragment1 extends Fragment {
    private static String packageName;
    private static ImageView picture;
    private static TextView name;
    private static int choice = 0;
    private static int state = Constant.STOP;
    private static TextView tvState;
    private static Context con;
    private static MediaPlayer mediaPlayer;
    private static Song song;

    static void changeSong(int choice) {
        Fragment1.choice = choice;
        song = Data.songs.get(choice);

        changeState(Constant.STOP);
        name.setText(song.getName() + "--" + song.getAuthor());
        picture.setImageDrawable(ContextCompat.getDrawable(con, song.getImgId()));
    }

    static void changeState(int state) {
        Fragment1.state = state;


//        mediaPlayer.start();
        switch (state) {
            case Constant.START:
                mediaPlayer=MediaPlayer.create(con,R.raw.ten_year);
                try {
//                    mediaPlayer.setDataSource(con, myUri);
                    mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                        @Override
                        public void onPrepared(MediaPlayer mediaPlayer) {
                            mediaPlayer.start();
                        }
                    });
                    mediaPlayer.start();
//                    mediaPlayer.prepareAsync();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName());

                tvState.setText("播放中");
                break;
            case Constant.PAUSE:
                if (mediaPlayer.isPlaying()) mediaPlayer.pause();
                tvState.setText("暂停中");
                break;
            case Constant.STOP:
                if (mediaPlayer.isPlaying()) mediaPlayer.stop();
                tvState.setText("停止中");
                break;
        }
    }

    public static class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("Fragment1", "onReceive: ");
            int operation = intent.getIntExtra(Constant.OPERATION, -1);

            switch (operation) {
                case Constant.START:
                case Constant.PAUSE:
                case Constant.STOP:

                    changeState(operation);
                    break;
                case Constant.LAST:
                    choice--;
                    if (choice < 0) choice = Data.songs.size() - 1;
//                    choice = (choice+Data.songs.size())%Data.songs.size();
                    mediaPlayer.release();

                    changeSong(choice);
                    break;
                case Constant.NEXT:
                    choice++;
                    choice %= Data.songs.size();
                    mediaPlayer.release();
                    changeSong(choice);
                    break;
                case Constant.CHOICE:
                    int myChoice = intent.getIntExtra(Constant.INDEX, -1);
                    changeSong(myChoice);
                    break;
                default:

            }

        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout1, container, false);
        packageName = Objects.requireNonNull(getClass().getPackage()).getName();
        picture = view.findViewById(R.id.picture1);
        name = view.findViewById(R.id.name1);
        tvState = view.findViewById(R.id.state);
        con = getActivity().getApplicationContext();
        mediaPlayer = new MediaPlayer();
        changeSong(0);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}



