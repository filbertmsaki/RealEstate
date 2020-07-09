package com.example.realestate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.zip.Inflater;

public class ViewPagerAdapter extends PagerAdapter {
    Context mContext;
    LayoutInflater mLayoutInflater;
    ImageView mImageView;
    int[] sliderImages ={R.drawable.slider1,R.drawable.slider2,R.drawable.slider3};
    public ViewPagerAdapter(Context context){
        this.mContext= context;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=  mLayoutInflater.inflate(R.layout.slider_layout,null);
        mImageView = (ImageView) view.findViewById(R.id.sliderImageView);
        mImageView.setImageResource(sliderImages[position]);
        ViewPager viewPager =(ViewPager) container;
        viewPager.addView(view,0);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        ViewPager viewPager =(ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

    @Override
    public int getCount() {
        return sliderImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }
}
