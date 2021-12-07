package com.example.secondclass;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BeginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_level1;
    private Button btn_level2;
    private Button btn_level3;
    private Button btn_level4;
    private Button btn_level5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_begin);
        init();

    }

    private void init() {
        btn_level1=findViewById(R.id.level1);
        btn_level2=findViewById(R.id.Level2);
        btn_level3=findViewById(R.id.Level3);
        btn_level4=findViewById(R.id.Level4);
        btn_level5=findViewById(R.id.Level5);
        btn_level1.setOnClickListener(this);
        btn_level2.setOnClickListener(this);
        btn_level3.setOnClickListener(this);
        btn_level4.setOnClickListener(this);
        btn_level5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.level1:
                Intent intent1 = new Intent(BeginActivity.this,Level1.class);
                startActivity(intent1);
                break;
            case R.id.Level2:
                Intent intent2 = new Intent(BeginActivity.this,MainActivity.class);
                startActivity(intent2);
                break;
            case R.id.Level3:
                Intent intent3 = new Intent(BeginActivity.this,Level3_Main.class);
                startActivity(intent3);
                break;
            case R.id.Level4:
                Intent intent4 = new Intent(BeginActivity.this,Level4.class);
                startActivity(intent4);
                break;
            case R.id.Level5:
                Intent intent5 = new Intent(BeginActivity.this,Level5.class);
                startActivity(intent5);
                break;

        }
    }
}