package com.example.coffee_quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView countLabel;
    private TextView questionLabel;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;

    private String rightAnswer; //回答を入れるための変数
    private int rightAnswerCount = 0; //正解を入れるための変数
    private int quizCount = 1; //何問目を出題しているのか数える

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            //{"コーヒー名","正解","選択肢１","選択肢２","選択肢３"}
            {"WILLOW","マルチリージョン","ラテンアメリカ","アフリカ","アジア・太平洋"},//[0][0],[0][1],[0][2],[0][3],[0][4]
            {"LIGHT NOTE","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"BREAKFAST","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"KENYA","アフリカ","ラテンアメリカ","アジア・太平洋","マルチリージョン"},
            {"PIKE PLACE ROAST","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"GUATEMALA ANTIGUA","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"ETHIOPIA","アフリカ","ラテンアメリカ","アジア・太平洋","マルチリージョン"},
            {"HOUSE","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"COLOMBIA","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"TOKYO ROAST","マルチリージョン","アフリカ","アジア・太平洋","ラテンアメリカ"},
            {"SUMATRA","アジア・太平洋","アフリカ","ラテンアメリカ","マルチリージョン"},
            {"KOMODO DRAGON","アジア・太平洋","アフリカ","ラテンアメリカ","マルチリージョン"},
            {"CAFFE VERONA","マルチリージョン","アフリカ","アジア・太平洋","ラテンアメリカ"},
            {"ESPRESSO","マルチリージョン","アフリカ","アジア・太平洋","ラテンアメリカ"},
            {"ITALIAN ROAST","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
            {"FRENCH ROAST","ラテンアメリカ","アフリカ","アジア・太平洋","マルチリージョン"},
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel = findViewById(R.id.countLabel); //idをViewから見つける
        questionLabel = findViewById(R.id.questionLabel);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);

        for(int i = 0;i<quizData.length;i++){
            ArrayList<String>tmpArray=new ArrayList<>();
            tmpArray.add(quizData[i][0]);
            tmpArray.add(quizData[i][1]);
            tmpArray.add(quizData[i][2]);
            tmpArray.add(quizData[i][3]);
            tmpArray.add(quizData[i][4]);

            quizArray.add(tmpArray);
        }

    }
}