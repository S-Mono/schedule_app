package com.sna.wings.android.scheduleapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CalenderViewFragment extends Fragment {

    private Activity parentActivity;

    public CalenderViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //所属する親アクティビティを取得
        parentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calender_view, container, false);

//        Intent intent = parentActivity.getIntent();
//
//        FragmentManager manager = getFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        CalenderViewFragment calenderViewFragment = new CalenderViewFragment();
//        transaction.replace(R.id.calenderGridViewPager, calenderViewFragment);
//        transaction.commit();

        return view;
    }
}