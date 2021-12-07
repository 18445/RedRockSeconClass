package com.example.secondclass;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Level4 extends AppCompatActivity {
    private List<Type> mType = new ArrayList<>();
    private Title title;
    private TextView textView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level4);
        initData();
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(Level4.this, "页面正在修建中呢……", Toast.LENGTH_SHORT).show();
//            }
//        });
        RecyclerView rv = (RecyclerView) findViewById(R.id.level4_rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        Level4_Adapter level4_adapter = new Level4_Adapter(mType);
        rv.setAdapter(level4_adapter);
        DividerItemDecoration mDivider = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        rv.addItemDecoration(mDivider);
    }

    private void initData() {
//        textView.findViewById(R.id.rightTitle);
        for(int i = 0;i<50;i++){
            Type type = new Type();
            type.above ="标题"+i;
            type.below ="内容"+i;
            if(i%2==0){
            type.picture= R.drawable.ic_launcher_background;
            }else{
            type.picture= R.drawable.ic_launcher_foreground;
            }
            mType.add(type);
        }
    }
}