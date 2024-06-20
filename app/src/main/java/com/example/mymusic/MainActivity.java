package com.example.mymusic;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.mymusic.adapter.FragAdapter;
import com.example.mymusic.fragment.Fragment1;
import com.example.mymusic.fragment.Fragment2;
import com.example.mymusic.fragment.Fragment3;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Fragment> datas = new ArrayList<>();
        datas.add(new Fragment1());
        datas.add(new Fragment2());
        datas.add(new Fragment3());
        ViewPager2 viewPager2 = findViewById(R.id.viewpager);
        FragAdapter myAapter = new FragAdapter(this,datas);
        viewPager2.setAdapter(myAapter);

        
    }

}