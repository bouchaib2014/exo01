package com.example.googleeb.exo01;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        float          dpWidth        = displayMetrics.widthPixels / displayMetrics.density;

        if (savedInstanceState == null) {
            FragmentManager     m = getSupportFragmentManager();
            FragmentTransaction t = m.beginTransaction();

            ListFragment list = new ListFragment();

            t.addToBackStack("").add(R.id.list_container, list);

            if (dpWidth >= 600){
                DetailFragment detail = new DetailFragment();
                t.addToBackStack("").add(R.id.detail_container, detail);
            }

            t.commit();

        }


    }
}
