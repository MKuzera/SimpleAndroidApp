package com.example.androidapp;

import android.app.AlertDialog;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//
public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    TextView questionX;
    TextView question;
    TextView finishViewPercent;
    TextView finishMessage;
    Button ans_A;
    Button ans_B;
    Button ans_C;
    Button ans_D;
    Button submit;
    Button start;
    Button finish;
    int score;
    int totalQuestions;
    int currentQuestion;
    String selectedAnswer;
    Quiz quiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        start =findViewById(R.id.start);
        start.setOnClickListener(this);

    }

    private void startQuiz() {
        setContentView(R.layout.activity_main);

        questionX = findViewById(R.id.QuestionX);

        question = findViewById(R.id.Question);
        ans_A = findViewById(R.id.ans_A);
        ans_B = findViewById(R.id.ans_B);
        ans_C = findViewById(R.id.ans_C);
        ans_D = findViewById(R.id.ans_D);
        submit = findViewById(R.id.submit);

        ans_A.setOnClickListener(this);
        ans_B.setOnClickListener(this);
        ans_C.setOnClickListener(this);
        ans_D.setOnClickListener(this);
        submit.setOnClickListener(this);

        quiz = new Quiz();
        quiz.generateSampleQuiz();

        score =0;
        totalQuestions = quiz.questionList.size();
        currentQuestion = 0;
        selectedAnswer = "";

        questionX.setText("Pytanie " + currentQuestion + "/" + totalQuestions);


        loadNewQuestion();
    }

    private void loadNewQuestion() {
        currentQuestion+=1;

        if(currentQuestion > totalQuestions){
            finishQuiz();
            return;
        }
        else {

            questionX.setText("Pytanie " + currentQuestion + "/" + totalQuestions);
            question.setText(quiz.questionList.get(currentQuestion - 1).ques);
            ans_A.setText(quiz.questionList.get(currentQuestion - 1).ansA);
            ans_B.setText(quiz.questionList.get(currentQuestion - 1).ansB);
            ans_C.setText(quiz.questionList.get(currentQuestion - 1).ansC);
            ans_D.setText(quiz.questionList.get(currentQuestion - 1).ansD);

            ans_A.setBackgroundColor(Color.WHITE);
            ans_B.setBackgroundColor(Color.WHITE);
            ans_C.setBackgroundColor(Color.WHITE);
            ans_D.setBackgroundColor(Color.WHITE);
        }


    }

    private void finishQuiz() {

        setContentView(R.layout.activity_finish);

        finishMessage = findViewById(R.id.finishMessage);
        finishViewPercent = findViewById(R.id.FinishPercent);

        finish =findViewById(R.id.finish);
        finish.setOnClickListener(this);

        double wynik = (double) score / (double) totalQuestions;

        String finishStatement = "";
        String finishPercentValue = wynik + "%";

        if( wynik>= 0.50){
            finishStatement = "Dobra robota zdałeś na 3.0!";
        }
        else {
            finishStatement = "Oj, zbieraj hajs na warunek";
        }

        finishMessage.setText(finishStatement);
        finishViewPercent.setText("Twoj wynik: " + score + "/" + totalQuestions);

    }

    private void restartQuiz() {

        score = 0;
        currentQuestion = 0;
        selectedAnswer = "";
        startQuiz();

    }

    @Override
    public void onClick(View view) {


        Button clickedButton = (Button) view;

        if(clickedButton.getId()==R.id.submit){
            if(selectedAnswer.equals(quiz.questionList.get(currentQuestion-1).correctAns)){
                score+=1;
                ans_A.setBackgroundColor(Color.WHITE);
                ans_B.setBackgroundColor(Color.WHITE);
                ans_C.setBackgroundColor(Color.WHITE);
                ans_D.setBackgroundColor(Color.WHITE);
                loadNewQuestion();
            }
            else{
                ans_A.setBackgroundColor(Color.WHITE);
                ans_B.setBackgroundColor(Color.WHITE);
                ans_C.setBackgroundColor(Color.WHITE);
                ans_D.setBackgroundColor(Color.WHITE);
                loadNewQuestion();

            }
        }
        else if(clickedButton.getId()==R.id.start){
            startQuiz();
        }
        else if(clickedButton.getId()==R.id.finish){
            restartQuiz();
        }
        else{

            selectedAnswer = clickedButton.getText().toString();
            ans_A.setBackgroundColor(Color.WHITE);
            ans_B.setBackgroundColor(Color.WHITE);
            ans_C.setBackgroundColor(Color.WHITE);
            ans_D.setBackgroundColor(Color.WHITE);
            clickedButton.setBackgroundColor(Color.CYAN);
        }

    }
}