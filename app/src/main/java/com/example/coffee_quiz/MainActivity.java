package com.example.coffee_quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
    static final private int QUIZ_COUNT = 5;//5回問題を出題する

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();
    ArrayList<String> test = new ArrayList<>();

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
        showNextQuiz();
    }
    public void showNextQuiz(){
        //何問目かを表示する
        countLabel.setText("Q" + quizCount);

        //ランダムな数字を取得
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());//quizArrayの数まででランダムに数を作成
        ArrayList<String> quiz = quizArray.get(randomNum);

        questionLabel.setText(quiz.get(0));//[0]が問題
        rightAnswer =quiz.get(1);//[1]が解答
        quiz.remove(0);//クイズから問題の配列を削除
        Collections.shuffle(quiz);//選択肢と解答をシャッフル

        answerBtn1.setText(quiz.get(0));//ボタン1〜4に解答、選択肢を表示
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        quizArray.remove(randomNum);//この問題をquizArrayから削除

    }

    public void checkAnswer(View view){
        Button answerBtn = findViewById(view.getId());//押された解答ボタンを見つける
        String btnText = answerBtn.getText().toString();//そのテキストを取得する
        String alertTitle;
        if(btnText.equals(rightAnswer)){ //回答ボタンのテキストと、rightAnswerが一致するかどうかで判定
            alertTitle = "正解！";
            rightAnswerCount++;
        }else{
            alertTitle = "不正解！";
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("答え："+rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(quizCount ==QUIZ_COUNT){
                    //結果画面に移動する
                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

}