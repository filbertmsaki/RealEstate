package com.example.realestate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {
    ImageView estateImage;
    TextView title,description;

     String mTitle,mDescription;
     int mImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estate_detail_layout);
        estateImage = findViewById(R.id.estateImage);
        title = findViewById(R.id.titleview);
        description = findViewById(R.id.descriptionview);
        getData();
        setData();
    }
    public void getData(){
        if (getIntent().hasExtra("titleTxt") && getIntent().hasExtra("descriptionTxt") && getIntent().hasExtra("imageView")){
            mTitle=getIntent().getStringExtra("titleTxt");
            mDescription=getIntent().getStringExtra("descriptionTxt");
            mImage = getIntent().getIntExtra("imageView",1);
        }else {
            Toast.makeText(this,"No Data",Toast.LENGTH_LONG).show();
        }
    }
    public void setData(){
            estateImage.setImageResource(mImage);
            title.setText(mTitle);
            description.setText(mDescription);
    }
}