package com.xcp.ffpush;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView tvContent;

    static {
       System.loadLibrary("ffpush");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvContent= findViewById(R.id.tv_content);
        tvContent.setText(stringFromJni());
    }

    public native String stringFromJni();
}