package com.aymanx.ai.alwahwdusur.ui.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.aymanx.ai.alwahwdusur.R;
import com.aymanx.ai.alwahwdusur.adapter.ViewPagerAdapter;
import com.aymanx.ai.alwahwdusur.fragment.CustomFragment;
import com.aymanx.ai.alwahwdusur.ui.viewmodel.PostViewModel;
import com.google.android.material.tabs.TabLayout;

public class CategoryActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        //Conecct tablayout and viewPager
        tabLayout = findViewById(R.id.tablayout_id);
        viewPager = findViewById(R.id.viewpager_id);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //Adding Fragment
        viewPagerAdapter.AddFragment(new CustomFragment(),this.getString(R.string.all_offer));
        viewPagerAdapter.AddFragment(new CustomFragment(),this.getString(R.string.best_offer));
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        //Remove Shadow
        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);



    }
}
