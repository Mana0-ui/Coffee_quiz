package com.example.coffee_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView resultLabel = findViewById(R.id.resultLabel);
        TextView totalScoreLabel = findViewById(R.id.totalScoreLabel);
        //正解数を、RIGHT_ANSWER_COUNTで取得する
        //getIntExtra(キー,値が取得できなかった時の値)
        int score = getIntent().getIntExtra("RIGHT_ANSWER_COUNT",0);

        SharedPreferences prefs = getSharedPreferences("coffee_quiz", Context.MODE_PRIVATE);
        int totalScore = prefs.getInt("totalScore",0);
        //トータルスコアに今回のスコアを加算
        totalScore+=score;

        //TextViewに表示する
        resultLabel.setText(score+"/５");
        totalScoreLabel.setText("トータルスコア："+totalScore);

        //トータルスコアを保存
        SharedPreferences.Editor editor = prefs.edit();

        //キー,保存する値
        editor.putInt("totalScore",totalScore);
        //apply()で保存する
        editor.apply();
    }

    public void returnTop(View view){
        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }

}