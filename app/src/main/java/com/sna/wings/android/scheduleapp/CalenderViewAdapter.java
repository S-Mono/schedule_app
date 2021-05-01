package com.sna.wings.android.scheduleapp;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.*;

public class CalenderViewAdapter extends BaseAdapter {

    private List<Date> dateArray = new ArrayList<>();
    private Context myContext;
    private DateManager myDateManager;
    private LayoutInflater myLayoutInflater;

    private static class ViewHolder {
        public TextView dateText;
    }

    public CalenderViewAdapter(Context context){
        myLayoutInflater = LayoutInflater.from(context);
        myDateManager = new DateManager();
        dateArray = myDateManager.getDays();
    }

    @Override
    public int getCount(){
        return dateArray.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder;
        if(convertView == null){
            convertView = myLayoutInflater.inflate(R.layout.activity_calender_cell, null);
            holder = new ViewHolder();
            holder.dateText = convertView.findViewById(R.id.dateText);
            convertView.setTag(holder);
        } else {
           holder = (ViewHolder)convertView.getTag();
        }

        //セルのサイズ指定
        GridView.LayoutParams params = new GridView.LayoutParams(parent.getWidth()/7, parent.getHeight() / (myDateManager.getWeeks()+1) -2);
        convertView.setLayoutParams(params);

        //日付のみを表示する
        SimpleDateFormat dateFormat = new SimpleDateFormat("d", Locale.US);
        holder.dateText.setText(dateFormat.format(dateArray.get(position)));


        //当月以外のセルをグレーアウト、当日はピンクで背景を変更する
        if(myDateManager.isCurrentDay(dateArray.get(position))){
            convertView.setBackgroundColor(Color.rgb(255,230, 230));
        } else if (myDateManager.isCurrentMonth(dateArray.get(position))){
            convertView.setBackgroundColor(Color.WHITE);
        } else {
            convertView.setBackgroundColor(Color.LTGRAY);
        }

        //日曜日を赤、土曜日を青にする
        int colorId;
        switch (myDateManager.getDayOfWeek(dateArray.get(position))){
            case 1:
                colorId = Color.RED;
                break;
            case 7:
                colorId = Color.BLUE;
                break;
            default:
                colorId = Color.BLACK;
        }
        holder.dateText.setTextColor(colorId);

        return convertView;
    }

    @Override
    public long getItemId(int position){
        return 1;
    }

    @Override
    public Object getItem(int position){
        return null;
    }

    //表示月を取得
    public String getTittle(){
        SimpleDateFormat format = new SimpleDateFormat("yy.MM", Locale.US);
        return format.format(myDateManager.myCalender.getTime());
    }

}
