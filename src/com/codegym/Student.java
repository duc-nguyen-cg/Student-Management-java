package com.codegym;

public class Student {
    private int id;
    private String name, birthDate;
    private int score;

    int getId(){
        return this.id;
    }

    String getName(){
        return this.name;
    }

    String getBirthDate(){
        return this.birthDate;
    }

    int getScore(){
        return this.score;
    }

    void setId(int id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    void setScore(int score){
        this.score = score;
    }

    public void display(){
        System.out.println(this.id+". "+this.name+"\t"+this.birthDate+"\t\t"+this.score);
    }

}
