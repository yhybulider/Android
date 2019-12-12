package com.example.zujian;

import androidx.appcompat.app.AppCompatActivity;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;//OnClickListener是其内部接口
import android.view.WindowManager;

import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);//设置禁止横屏的代码*/

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//全屏显示
        ImageButton button3 = (ImageButton)findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(MainActivity.this,"你点击了开始按钮",Toast.LENGTH_LONG).show();
            }
        });
        ImageButton button4 = (ImageButton)findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"你点击了其他按钮",Toast.LENGTH_LONG).show();
            }
        });
        /*Button button =(Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {//设置按钮点击后弹出的内容。setonclick
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"弹出对话框",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void myClick(View view){//这里要在xml文件中添加onClick=myClick
        Toast.makeText(MainActivity.this,"弹出新对话框",Toast.LENGTH_LONG ).show();//LENGTH是设置弹出来的时间长短，show（）是显示文本text的。
    */
    }
}
