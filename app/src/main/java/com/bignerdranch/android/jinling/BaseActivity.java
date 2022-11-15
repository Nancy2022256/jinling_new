package com.bignerdranch.android.jinling;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getlayoutId());
        initViews();
    }

    protected abstract void initViews();

    protected abstract int getlayoutId();

    protected <T extends View>T find(@IdRes int id){
        return  findViewById(id);
    }


    public abstract boolean onNavigationItemSelected(@NonNull MenuItem item);


}
