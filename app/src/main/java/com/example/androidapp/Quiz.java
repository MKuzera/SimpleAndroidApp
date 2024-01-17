package com.example.androidapp;

import java.util.ArrayList;
import java.util.List;

public class Quiz {
    public List<Question> questionList = new ArrayList<>();
    public String quizName;
    public Quiz(List<Question> questionList,String quizName) {
        this.questionList = questionList;
        this.quizName = quizName;
    }

    public Quiz(){}

    public void generateSampleQuiz(){
        this.quizName = "Quiz czy jestes studentem";
        questionList.add(new Question(1,"Co sie robi w czwartek wieczor?","Uczy sie na kolokwium","Robi sie projekt z PAOiM","Idzie sie na miasteczko","Spi sie","Idzie sie na miasteczko"));
        questionList.add(new Question(2,"Jaka ocena to bardzo dobra ocena?","3.0","4.0","2.0","5.0","3.0"));
        questionList.add(new Question(3,"Najgorsze w życiu studenta","Pusty portfel","Sesja","Warunek","Brak snu","Warunek"));
        questionList.add(new Question(4,"Najlepszy wydział na AGH to?","WIMIR","WIMiIP","WILiGZ","WH","WIMiIP"));
        questionList.add(new Question(5,"Na ile punktów oceniasz ten projekt?","2p :(","3p :)","4p :D","5p (wybierz to!)","5p (wybierz to!)"));
    }



}
