package com.cookandroid.ezone;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

// 통신과 json 데이터 처리..
// 요청
// 반응 객체..
// json데이터 ==> ArrayList변환처리.
// json 데이터 처리..

public class MypageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mypage);
        ImageView button1 = findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SeminarActivity.class);
                startActivity(intent);
            }
        });

        ImageView button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),QnaActivity.class);
                startActivity(intent);
            }
        });




}}
