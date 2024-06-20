package com.example.mymusic.util;

import com.example.mymusic.R;
import com.example.mymusic.entity.Song;

import java.util.ArrayList;

public class Data {
    public static ArrayList<Song> songs = new ArrayList<>();
    static {
        songs.add(new Song("十年","陈奕迅",R.drawable.ten_year,R.raw.ten_year));
        songs.add(new Song("丑八怪","薛之谦",R.drawable.ugly_child,R.raw.ugly_child));
        songs.add(new Song("曹操","林俊杰",R.drawable.caochao,R.raw.caochao));
    }

}
