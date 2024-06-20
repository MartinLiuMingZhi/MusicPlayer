package com.example.mymusic.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.mymusic.R;
import com.example.mymusic.util.Constant;

public class Fragment2 extends Fragment {

    private Button start,pause,stop,first_song,next_song;
    private int k=0;
    private SharedPreferences num;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout2,container,false);
        start = view.findViewById(R.id.start);
        pause = view.findViewById(R.id.pause);
        stop = view.findViewById(R.id.stop);
        first_song = view.findViewById(R.id.front_song);
        next_song = view.findViewById(R.id.next_song);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        num = getContext().getSharedPreferences("config",Context.MODE_PRIVATE);
//
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction("com.example.mymuic.MyBroadcastReceiver");
//        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
//        getActivity().registerReceiver(myBroadcastReceiver,intentFilter);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");
                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.START);
                getActivity().sendBroadcast(intent);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");
                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.PAUSE);
                getActivity().sendBroadcast(intent);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");
                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.STOP);
                getActivity().sendBroadcast(intent);
            }
        });
        first_song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");
                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.LAST);
                getActivity().sendBroadcast(intent);
            }
        });
        next_song.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("com.example.mymuic.MyBroadcastReceiver");
                intent.setPackage(Constant.PACKAGE_NAME);
                intent.putExtra(Constant.OPERATION,Constant.NEXT);
                getActivity().sendBroadcast(intent);
            }

        });

    }
}
