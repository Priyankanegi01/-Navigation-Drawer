package com.example.navigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.navigationbar.Fragments.AboutUs;
import com.example.navigationbar.Fragments.AllCourses;
import com.example.navigationbar.Fragments.Faculty;
import com.example.navigationbar.Fragments.Home;
import com.example.navigationbar.Fragments.MyCourses;
import com.example.navigationbar.Fragments.RateUs;
import com.example.navigationbar.Fragments.Settings;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawerLayout;
private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout=findViewById(R.id.drawer_layout);
        navigationView=findViewById(R.id.navigation_drawer);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar=findViewById(R.id.toolbar);
       setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_bar_open,R.string.navigation_bar_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Home()).commit();
                break;

            case R.id.nav_Mycourses:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new MyCourses()).commit();
                break;

            case R.id.nav_aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new AboutUs()).commit();
                break;

            case R.id.nav_allcourses:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new AllCourses()).commit();
                break;

            case R.id.nav_faculty:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Faculty()).commit();
                break;

            case R.id.nav_rateus:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new RateUs()).commit();
                break;

            case R.id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Settings()).commit();
                break;
        }
        item.setChecked(true);
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
