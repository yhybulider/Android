package com.example.carapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

  private ImageButton but1,but2,but3,but4;
  private Bundle mBundle;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);
        but1 =findViewById(R.id.model1);
        but2  =findViewById(R.id.model2);
        but3 =findViewById(R.id.model3);
        but4 = findViewById(R.id.link);
        but1.setOnClickListener(this);
        but2.setOnClickListener(this);
        but3.setOnClickListener(this);
        but4.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if(id ==R.id.link){
            Intent  intent2 = new Intent(MainActivity.this,BlueLink.class);
            startActivity(intent2);
        }

        mBundle = getIntent().getExtras();
        if(mBundle.getString("address")!=null){
            String address = mBundle.getString("address");
            Bundle bundle = new Bundle();
            bundle.putString("address",address);
            switch(id){
                case R.id.model1:
                    Intent intent =new Intent(MainActivity.this,otherActivity.class);
                    intent.putExtras(bundle);
                    startActivity(intent);
                    break;
                case R.id.model2:
                    Intent intent1 = new Intent (MainActivity.this,scendActivitty.class);
                    intent1.putExtras(bundle);
                    startActivity(intent1);
                    break;
            }
        }


    }
}
