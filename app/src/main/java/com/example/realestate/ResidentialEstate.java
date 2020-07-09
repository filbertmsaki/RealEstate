package com.example.realestate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ResidentialEstate extends Fragment {
    RecyclerView mRecyclerView;
    String s1[], s2[];
    int images[] ={R.drawable.image,R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4,
            R.drawable.image5,R.drawable.image6};
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.residential_layout,container,false);
        mRecyclerView = view.findViewById(R.id.list_view);
        //Getting Strings
        s1= getResources().getStringArray(R.array.estate_list);
        s2 = getResources().getStringArray(R.array.description);
        //Passing the values from main activity to List Adapter
        ListAdapter listAdapter = new ListAdapter(view.getContext(),s1,s2,images);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(listAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}
