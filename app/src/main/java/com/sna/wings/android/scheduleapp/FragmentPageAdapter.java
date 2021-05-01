package com.sna.wings.android.scheduleapp;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

public class FragmentPageAdapter extends FragmentActivity {
    private static final int NUM_PAGES = 3;

    public static class FragmentPagerAdapter extends FragmentStatePagerAdapter{
        private FragmentManager myFragmentManager;

        public FragmentPagerAdapter (FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            myFragmentManager = fm;
        }

        @NonNull
        @Override
        public Fragment getItem(int position){
            Fragment calenderFragment = new CalenderViewFragment();
            return calenderFragment;
        }

        @Override
        public int getCount(){

            return NUM_PAGES;
        }
    }

}
