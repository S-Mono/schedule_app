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
import android.widget.GridView;
import android.widget.TextView;

public class CalenderViewFragment extends Fragment {

    private Activity parentActivity;
    private CalenderViewAdapter myCalenderAdapter;
    private GridView calenderGridView;
    private TextView tittleText;


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

        //カレンダー表示処理
        tittleText = parentActivity.findViewById(R.id.monthTittle);
        calenderGridView = view.findViewById(R.id.calenderGrid);
        myCalenderAdapter = new CalenderViewAdapter(parentActivity);
        calenderGridView.setAdapter(myCalenderAdapter);
        tittleText.setText(myCalenderAdapter.getTittle());

        return view;
    }
}