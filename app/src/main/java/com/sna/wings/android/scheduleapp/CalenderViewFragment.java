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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalenderViewFragment extends Fragment {

    private Activity parentActivity;
    private CalenderViewAdapter myCalenderAdapter;
    private GridView calenderGridView;
    private TextView tittleText;
    private DateManager myDateManager;
    private List<Date> dateArray = new ArrayList<>();


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
        calenderGridView = view.findViewById(R.id.calenderGrid);

        myCalenderAdapter = new CalenderViewAdapter(parentActivity);
        calenderGridView.setAdapter(myCalenderAdapter);

        //アクションバーに年月を表示する
        tittleText = parentActivity.findViewById(R.id.monthTittle);
        tittleText.setText(myCalenderAdapter.getTittle());

        return view;
    }

    //翌月表示
    public void nextMonth(){
        myDateManager.nextMonth();
        dateArray = myDateManager.getDays();
        myCalenderAdapter.notifyDataSetChanged();
    }

    //前月表示
    public void prevMonth(){
        myDateManager.prevMonth();
        dateArray = myDateManager.getDays();
        myCalenderAdapter.notifyDataSetChanged();
    }
}