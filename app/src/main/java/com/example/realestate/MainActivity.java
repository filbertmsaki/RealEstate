package com.example.realestate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
        DrawerLayout mDrawer;
        ActionBarDrawerToggle mToggle;
        Toolbar mToolbar;
        NavigationView mNavigationView;
        FragmentManager mFragmentManager;
        FragmentTransaction mFragmentTransaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawer=(DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle= new ActionBarDrawerToggle(this,mDrawer,mToolbar,R.string.open,R.string.close);
        mDrawer.setDrawerListener(mToggle);
        mToggle.syncState();
        mNavigationView = (NavigationView) findViewById(R.id.navigation_view);
        mNavigationView.setNavigationItemSelectedListener(this);

        mToolbar.setTitle("Dashboard");
        mFragmentManager= getSupportFragmentManager();
        mFragmentTransaction= mFragmentManager.beginTransaction();
        mFragmentTransaction.add(R.id.container_fragment,new Dashboard());
        mFragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (mDrawer.isDrawerOpen(GravityCompat.START)){
            mDrawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.drawer_menu1,menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
       int id=menuItem.getItemId();
        if (id == R.id.dashboard_menu){
            mToolbar.setTitle("Dashboard");
            mFragmentManager= getSupportFragmentManager();
            mFragmentTransaction= mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new Dashboard());
            mFragmentTransaction.commit();
        }
        if (id == R.id.residential_real_estates){
            mToolbar.setTitle("Residential Estate");
            mFragmentManager= getSupportFragmentManager();
            mFragmentTransaction= mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new ResidentialEstate());
            mFragmentTransaction.commit();
        }
        if (id == R.id.commercial_real_estate){
            mToolbar.setTitle("Commercial Estate");
            mFragmentManager= getSupportFragmentManager();
            mFragmentTransaction= mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new CommercialEstate());
            mFragmentTransaction.commit();
        }
        if (id == R.id.industrial_real_estate){
            mToolbar.setTitle("Industrial Estate");
            mFragmentManager= getSupportFragmentManager();
            mFragmentTransaction= mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new IndustrialEstate());
            mFragmentTransaction.commit();
        }
        if (id == R.id.land_real_estate){
            mToolbar.setTitle("Land Estate");
            mFragmentManager= getSupportFragmentManager();
            mFragmentTransaction= mFragmentManager.beginTransaction();
            mFragmentTransaction.replace(R.id.container_fragment,new LandEstate());
            mFragmentTransaction.commit();
        }
        if (id == R.id.settings){

        }
        if (id == R.id.login){

        }
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawer.closeDrawer(GravityCompat.START);
        return true;
    }
}