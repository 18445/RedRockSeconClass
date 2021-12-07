package com.example.secondclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Level1 extends AppCompatActivity implements View.OnClickListener {
    static boolean i = true;
    private TextView mtv_class;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level1_layout);
        init();
        mtv_class.setOnClickListener(this);
    }

    void init(){
        mtv_class =findViewById(R.id.textView);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.textView:
                if(i){
                    mtv_class.setBackground(getResources().getDrawable(R.drawable.txt_radiuborder1));
                    i=false;
                }else{
                    mtv_class.setBackground(getResources().getDrawable(R.drawable.txt_radiuborder));
                    i=true;
                }
                break;
        }
    }
}
