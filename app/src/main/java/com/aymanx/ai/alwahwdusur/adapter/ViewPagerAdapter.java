package com.aymanx.ai.alwahwdusur.adapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final List<Fragment> lsFragment = new ArrayList<>();
    private final List<String> lsTitle = new ArrayList<>();

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return lsFragment.get(position);
    }

    @Override
    public int getCount() {
        return lsTitle.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return lsTitle.get(position);
    }

    public void AddFragment(Fragment fragment,String title){
        lsFragment.add(fragment);
        lsTitle.add(title);
    }
}