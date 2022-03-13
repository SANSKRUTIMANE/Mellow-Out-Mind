package com.example.mellowoutmind;

import android.widget.Button;

public class Question {

    private static String[] myQues ={
            "Are you suffering from feelings of sadness, hopelessness or emptiness?","Do you find it hard to find pleasure in activities you used to enjoy",
            "Has your appetite changed?","Are you lacking energy and motivation?","Are you having trouble getting to sleep and staying asleep? Or are you finding it hard to get up in the morning?",
            "Have you had thoughts about harming yourself or ending your life?","Do you feel guilty or tearful for no reason?",
            "Have you recently suffered a traumatic event, such as a bereavement?","Do you find yourself avoiding friends and family?"
    };
    private static String[][] myOption ={
            {"Everyday","Occasionally","Never"},{"Yes","Sometimes","No"},{"Yes,there is randomness in my appetite","Yes,sometimes","No,I don't think so"},
            {"Yes","Sometimes","No"},{"Everyday","Occasionally","Never"},{"Yes","Yes,sometimes","Never"},
            {"Everyday","Occasionally","Never"},{"Yes,recently","Yes,but quite years before","No"}, {"Yes","Sometimes","No"}
    };
    public static String getQ(int a){
        return myQues[a];
    }
    public static String getChoice1(int a){
        return myOption[a][0];
    }
    public static String getChoice2(int a){
        return myOption[a][1];
    }
    public static String getChoice3(int a){
        return myOption[a][2];
    }
    String ques;


}

