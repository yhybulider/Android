package com.example.bobo;



import android.app.Activity;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends Activity {
    int year, month, day;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datePicker = (DatePicker) findViewById(R.id.datepicker);
        Calendar calendar = Calendar.getInstance();//定义日期变量calendar
        year = calendar.get(Calendar.YEAR);//获得当前的年份
        month = calendar.get(Calendar.MONTH);//当前的月份
        day = calendar.get(Calendar.DAY_OF_MONTH);//当前的天
        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {
            //日期信息，事件监听器，26-41行是监听器部分
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;
                MainActivity.this.month = monthOfYear;
                MainActivity.this.day = dayOfMonth;
                show(year,monthOfYear,dayOfMonth);
            }
        });

    }
    private void show(int year,int month,int day){
        String str = year + "年" + (month+1) + "月" + day + "日";
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }

}
