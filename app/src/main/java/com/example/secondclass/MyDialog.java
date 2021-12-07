package com.example.secondclass;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;

import org.w3c.dom.Text;

public class MyDialog extends Dialog {
    private TextView title;
    private TextView message;
    private Button no;
    private Button yes;
    private String titletext;
    private String messagetext;
    private String notext;
    private String yestext;
    private CheckBox checkBox;

    public MyDialog(@NonNull Context context) {
        super(context);
    }
    //创建接口
    public interface NoClick{
        void noClick();
    }
    protected interface YesClick{
        void yesClick();
    }
    //初始化接口
    private NoClick noClick;
    private YesClick yesClick;
    //定义接口方法
    public MyDialog setNoClick(NoClick noClick) {
        this.noClick = noClick;
        return this;
    }
    public MyDialog setYesClick(YesClick yesClick) {
        this.yesClick = yesClick;
        return this;
    }

    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_round);
        title = (TextView) findViewById(R.id.title);
        message = (TextView) findViewById(R.id.message);
        no = (Button) findViewById(R.id.no);
        yes = (Button) findViewById(R.id.yes);
        checkBox = (CheckBox) findViewById(R.id.checkbox);
        //如果修改显示的文字
        if (titletext!=null){
            title.setText(titletext);
        }
        if (messagetext!=null){
            message.setText(messagetext);
        }
        if (notext!=null){
            no.setText(notext);
        }
        if (yestext!=null){
            yes.setText(yestext);
        }
        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noClick.noClick();
                dismiss();
            }
        });
        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesClick.yesClick();
                dismiss();
            }
        });
        SpannableString spannableString = new SpannableString("友友，欢迎使用掌上重邮！在您使用掌上重邮前，请认真阅读《用户协议》和《隐私权政策》，它们将帮助您了解我们所采集的个人信息与用途的对应关系。如您同意，请点击下方按钮开始接受我们的服务。");
        ForegroundColorSpan colorSpan = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        ForegroundColorSpan colorSpan1 = new ForegroundColorSpan(Color.parseColor("#009ad6"));
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getContext(),Level5_Agreement.class);
                getContext().startActivity(intent1);
            }
        };
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getContext(),Level5_Privacy.class);
                getContext().startActivity(intent2);
            }
        };
        spannableString.setSpan(clickableSpan, 27, 33, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(clickableSpan1, 34, 41, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(colorSpan, 27, 33, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        spannableString.setSpan(colorSpan1, 34, 41, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        message.setText(spannableString);
        message.setMovementMethod(LinkMovementMethod.getInstance());

    }
    //接收要改成的内容
    public void setTitle(String title) {
        titletext=title;
    }
    public void setMessage(String message) {
        messagetext=message;
    }
    public void setNo(String no) {
        notext=no;
    }
    public void setYes(String yes) {
        yestext=yes;
    }
}
