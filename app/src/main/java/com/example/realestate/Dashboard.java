package com.example.realestate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

public class Dashboard extends Fragment {
        ViewPager mViewPager;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dashboard_layout,container,false);
         mViewPager= view.findViewById(R.id.sliderView);
         ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getContext());
         mViewPager.setAdapter(viewPagerAdapter);
        return view;
    }
}
