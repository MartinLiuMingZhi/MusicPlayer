package com.example.mymusic.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mymusic.R;
import com.example.mymusic.adapter.SongAdapter;
import com.example.mymusic.util.Data;

public class Fragment3 extends Fragment {

//    private Button music_1,music_2,music_3;
    private RecyclerView rv;
    private SongAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout3,container,false);

//        music_1 = view.findViewById(R.id.music_1);
//        music_2 = view.findViewById(R.id.music_2);
//        music_3 = view.findViewById(R.id.music_3);
        rv = view.findViewById(R.id.rv);

        adapter = new SongAdapter(Data.songs,getActivity());
        rv.setAdapter(adapter);
//        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

//        MyBroadcastReceiver myBroadcastReceiver = new MyBroadcastReceiver();
////        int k = myBroadcastReceiver.getResultCode();
//        Intent intent = new Intent();
//        int k = intent.getIntExtra("data",myBroadcastReceiver.getResultCode());
//
//        if (k == 0){
//            music_1.setBackgroundResource(R.color.purple_200);
//            music_2.setBackgroundResource(R.color.teal_200);
//            music_3.setBackgroundResource(R.color.teal_200);
//        }
//        else if (k == 1){
//            music_1.setBackgroundResource(R.color.teal_200);
//            music_2.setBackgroundResource(R.color.purple_200);
//            music_3.setBackgroundResource(R.color.teal_200);
//        }
//        else if (k == 2){
//            music_1.setBackgroundResource(R.color.teal_200);
//            music_2.setBackgroundResource(R.color.teal_200);
//            music_3.setBackgroundResource(R.color.purple_200);
//        }

        return view;
    }

}
