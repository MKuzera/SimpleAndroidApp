package com.example.androidapp;

public class Question {
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String ques;
    public String ansA;
    public String ansB;
    public String ansC;
    public String ansD;
    public String correctAns;


    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getAnsA() {
        return ansA;
    }

    public void setAnsA(String ansA) {
        this.ansA = ansA;
    }

    public String getAnsB() {
        return ansB;
    }

    public void setAnsB(String ansB) {
        this.ansB = ansB;
    }

    public String getAnsC() {
        return ansC;
    }

    public void setAnsC(String ansC) {
        this.ansC = ansC;
    }

    public String getAnsD() {
        return ansD;
    }

    public void setAnsD(String ansD) {
        this.ansD = ansD;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public Question(int id,String ques, String ansA, String ansB, String ansC, String ansD, String correctAns) {
        this.id = id;
        this.ques = ques;
        this.ansA = ansA;
        this.ansB = ansB;
        this.ansC = ansC;
        this.ansD = ansD;
        this.correctAns = correctAns;
    }
}
