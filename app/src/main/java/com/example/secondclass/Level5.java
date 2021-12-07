package com.example.secondclass;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.ListFragment;

import java.util.Objects;
import java.util.logging.Level;

public class Level5 extends AppCompatActivity implements View.OnClickListener {
    private Level5_Agreement level5_agreement;
    private Button mBtnLogin;
    private CheckBox CBLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level5);
        hide();
        initStringBuild();
        init();
        mBtnLogin.setOnClickListener(this);
    }
    private void init() {
        mBtnLogin = findViewById(R.id.Login_button);
        CBLogin = findViewById(R.id.checkbox);
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.Login_button:
                if(CBLogin.isChecked()){
                    Toast.makeText(Level5.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(Level5.this,Level1.class);
                    startActivity(intent1);
                }else{
                    final MyDialog myDialog = new MyDialog(Level5.this);
//                    myDialog.setNo("不是");
//                    myDialog.setYes("是");
                    myDialog.show();
                    myDialog.setYesClick(new MyDialog.YesClick() {
                        @Override
                        public void yesClick() {
                            if(!CBLogin.isChecked()){
                                CBLogin.setChecked(true);
//                                Toast.makeText(Level5.this, "", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });
                    myDialog.setNoClick(new MyDialog.NoClick() {
                        @Override
                        public void noClick() {
                            Toast.makeText(Level5.this, "登录失败，请重新尝试", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
        }
    }

//    private void initFragment() {
////        level5_agreement = new Level5_Agreement();
////        getFragmentManager().beginTransaction().replace(R.id.agreement, level5_agreement).commit();
////        getFragmentManager().beginTransaction().show(level5_agreement);
////        ListFragment fragment = new ListFragment();
////        getSupportFragmentManager().beginTransaction().add(R.id.agreement,fragment).commit();//添加
////        getSupportFragmentManager().beginTransaction().remove(fragment).commit(); //删除
////        getSupportFragmentManager().beginTransaction().replace(R.id.list_1,fragment).commit();
//        FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        Level5_Agreement level5_agreement = new Level5_Agreement();
//        transaction.add(R.id.agreement, level5_agreement);
//
//    }

    private void hide(){
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
    private void initStringBuild() {
        SpannableString spannableString = new SpannableString("同意《用户协议》和《隐私权政策》");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Level5.this,Level5_Agreement.class);
                startActivity(intent1);
            }
        };
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Level5.this,Level5_Privacy.class);
                startActivity(intent2);
            }
        };
        ClickableSpan clickableSpan3 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Level5.this, "暂不支持游客登录呢", Toast.LENGTH_SHORT).show();
            }
        };
        spannableString.setSpan(clickableSpan, 2, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(clickableSpan1, 9, 16, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(colorSpan, 2, 8, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(colorSpan1, 9, 16, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ((TextView)findViewById(R.id.stringBuild)).setText(spannableString);
        ((TextView)findViewById(R.id.stringBuild)).setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString spannableStringBottom = new SpannableString("没有学号么？游客模式吧");
        ForegroundColorSpan colorSpan2 = new ForegroundColorSpan(Color.parseColor("#000000"));
        spannableStringBottom.setSpan(clickableSpan3, 6, 11, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableStringBottom.setSpan(colorSpan2, 6, 11, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        ((TextView)findViewById(R.id.stringBottom)).setText(spannableStringBottom);
        ((TextView)findViewById(R.id.stringBottom)).setMovementMethod(LinkMovementMethod.getInstance());

    }


}