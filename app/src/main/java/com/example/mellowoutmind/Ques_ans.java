package com.example.mellowoutmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public  class Ques_ans extends AppCompatActivity {
    private Question myQues=new Question();
    private TextView Que_text;
    private TextView result_text;
    private Button opt1_button;
    private Button opt2_button;
    private Button opt3_button;
    private Button display_button;
    private int  score=0;
    private int ques_no=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques_ans);
        finders();
        if(ques_no==0){
            updateQuestion();

        }

        opt1_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=score+3;
                if(ques_no==9){
                    showPopup();
                    showResult();
                    display_button.setVisibility(View.VISIBLE);
                    display_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent mcq_intent=new Intent(Ques_ans.this,DoctorActivity.class) ;
                            startActivity(mcq_intent);
                        }
                    });
                }
                else {
                    updateQuestion();
                    display_button.setVisibility(View.INVISIBLE);
                }
            }
        });
        opt2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=score+2;
                if(ques_no==9){
                    showPopup();
                    showResult();
                    display_button.setVisibility(View.VISIBLE);
                    display_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent mcq_intent=new Intent(Ques_ans.this,MainActivity.class) ;
                            startActivity(mcq_intent);
                        }
                    });
                }
                else {
                    updateQuestion();
                    display_button.setVisibility(View.INVISIBLE);
                }
            }
        });
        opt3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                score=score+1;

                if(ques_no==9){
                    showPopup();
                    showResult();
                    display_button.setVisibility(View.VISIBLE);
                    display_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Intent mcq_intent=new Intent(Ques_ans.this,MainActivity.class) ;
                            startActivity(mcq_intent);
                        }
                    });
                }
                else {
                    updateQuestion();
                    display_button.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
    public void finders(){
        Que_text=findViewById(R.id.Ques_text);
        opt1_button=findViewById(R.id.c1);
        opt2_button=findViewById(R.id.c2);
        opt3_button=findViewById(R.id.c3);
        result_text=findViewById(R.id.result_textview);
        display_button=findViewById(R.id.DisplayDoctor_button);
    }
    private void updateQuestion(){
        Que_text.setText(myQues.getQ(ques_no));
        opt1_button.setText(myQues.getChoice1(ques_no));
        opt2_button.setText(myQues.getChoice2(ques_no));
        opt3_button.setText(myQues.getChoice3(ques_no));

        ques_no++;

    }
    private void showPopup(){
        Toast toast= Toast.makeText(getApplicationContext(), "You are done with quiz!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }
    private void showResult(){
        String s;
        if(score>20){
            s="The level of depression is high,but don't worry.Our doctors are always there to help you.Click the button to view profiles of doctors.";
        }
        else if(score>=14){
            s="Your level of depression is moderate,it might be possible that this due to the situation you are in.Although,what we think is that it is good handle these issues at this level.We advise you to consult a doctor.Click the button to view profiles of doctors.";
        }
        else{
            s="You don't seem to have any depression.Stay happy!We don't personally advice you a doctor but it is always your choice as an aware patient,we have the best doctors out there.Click the button to view profiles of doctors.";
        }
        result_text.setText(s);
    }
}