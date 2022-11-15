package com.bignerdranch.android.jinling;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import home.fragment.homeFragment;
import message.messageFragment;
import mine.mineFragment;
import road.roadFragment;

public class MainActivity extends BaseActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FragmentManager fm;
    FragmentTransaction ft;
    private Fragment[] fragments;
    private int lastFragmentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Theme_Jinling);
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

    }



    @Override
    protected int getlayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        BottomNavigationView bottomNavigationView = find(R.id.main_bottom);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        fragments=new Fragment[]{
                new homeFragment(),
                new messageFragment(),
                new roadFragment(),
                new mineFragment()
        };

        getSupportFragmentManager().beginTransaction()
                .add(R.id.main_frame,fragments[0])
                .commit();


    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item){
       item.setChecked(true);
        switch (item.getItemId()){
            case R.id.homeFragment:
                switchFragment(0);
                break;
            case R.id.messageFragment:
                switchFragment(1);
                break;
            case R.id.roadFragment:
                switchFragment(2);
                break;
            case R.id.mineFragment:
                switchFragment(3);
                break;
        }
        return false;
    }


    public void switchFragment(int to){
        if (lastFragmentIndex==to){
            return;
        }
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        if (!fragments[to].isAdded()){
            fragmentTransaction.add(R.id.main_frame,fragments[to]);
        }else {
            fragmentTransaction.show(fragments[to]);
        }
        fragmentTransaction.hide(fragments[lastFragmentIndex])
                .commitAllowingStateLoss();

        lastFragmentIndex=to;
    }





}