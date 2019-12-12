package com.example.yuefenxiala;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity /*implements AdapterView.OnItemSelectedListener */{
    private Spinner spinner_season,spinner_month;
    ArrayAdapter <String> adapter_season,adapter_month;
    private List<String> list_season;
    String[][] months = {{"一月", "二月", "三月"}, {"四月", "五月", "六月"}, {"7月", "8月", "9月"}, {"10月", "11月", "12月"}};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner_month = /*(Spinner)*/ findViewById(R.id.spinner_month);
        spinner_season = /*(Spinner) */findViewById(R.id.spinner_season);
        spinner_season.setPrompt("请选择季节");
        initDatas();
        adapter_season = new ArrayAdapter/*<String>*/(this, android.R.layout.simple_list_item_1, list_season);
        spinner_season.setAdapter(adapter_season);
        spinner_season.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){

            public void OnItemSelected (AdapterView <?> parent, View view,int position, long id){
                adapter_month = new ArrayAdapter/*<String>*/(MainActivity.this,android.R.layout.simple_list_item_1,months[position]);
                adapter_month.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
                spinner_month.setAdapter(adapter_month);
            }

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> parent){

            }
        });
    }
    private void initDatas(){
        list_season= new ArrayList/*<String>*/();
        list_season.add("春季");
        list_season.add("夏季");
        list_season.add("秋季");
        list_season.add("冬季");

    }
}

