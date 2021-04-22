package com.sna.wings.android.scheduleapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.Calendar;

public class FragmentPageAdapter extends FragmentActivity {
    private static final int NUM_PAGES = 5;

    public static class FragmentPagerAdapter extends FragmentStatePagerAdapter{
        public FragmentPagerAdapter (FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position){
            return new CalenderViewFragment();
        }

        @Override
        public int getCount(){

            return NUM_PAGES;
        }

    }

}
