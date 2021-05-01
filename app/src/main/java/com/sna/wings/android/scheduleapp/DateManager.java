package com.sna.wings.android.scheduleapp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class DateManager {
    Calendar myCalender;

    public DateManager(){
        myCalender = Calendar.getInstance();
    }

    //当月の要素を取得
    public List<Date> getDays() {
        //現在の状態を保持
        Date startDate = myCalender.getTime();

        //GridViewに表示するマスの計算
        int count = (getWeeks() + 1) * 7;

        //当月のカレンダーに表示される前月分の日数を計算
        myCalender.set(Calendar.DATE,1);
        int dayOfWeek = myCalender.get(Calendar.DAY_OF_WEEK) - 1;
        //表示する月の始まりの日数分追加する
        myCalender.add(Calendar.DATE, -dayOfWeek);

        List<Date> days = new ArrayList<>();

        for(int i = 0; i < count; i++){
            days.add(myCalender.getTime());
            myCalender.add(Calendar.DATE, 1);
        }

        myCalender.setTime(startDate);

        return days;
    }

    //当月か判定
    public boolean isCurrentMonth(Date date){
        SimpleDateFormat format = new SimpleDateFormat("yy.MM", Locale.US);
        String currentMonth = format.format(myCalender.getTime());
        return currentMonth.equals(format.format(date));
    }

    //当日か判定
    public boolean isCurrentDay(Date date) {
        SimpleDateFormat dayFormat = new SimpleDateFormat("MM.dd", Locale.US);
        String currentDay = dayFormat.format(myCalender.getTime());
        return currentDay.equals(dayFormat.format(date));
    }

    //週数を取得
    public int getWeeks(){
        return myCalender.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    //曜日を取得
    public int getDayOfWeek(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    //翌月へ
    public void nextMonth(){
        myCalender.add(Calendar.MONTH, 1);
    }

    //前月へ
    public void prevMonth(){
        myCalender.add(Calendar.MONTH, -1);
    }
}
