package com.example.mellowoutmind;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class DoctorActivity extends AppCompatActivity {

    CardView Doc1;
    CardView Doc2;
    CardView Doc3;
    CardView Doc4;
    CardView Doc5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor);
        Doc1= findViewById(R.id.card_view_doc1);
        Doc2= findViewById(R.id.card_view_doc2);
        Doc3= findViewById(R.id.card_view_doc3);
        Doc4= findViewById(R.id.card_view_doc4);
        Doc5= findViewById(R.id.card_view_doc5);
        Doc1.setCardBackgroundColor(Color.WHITE);
        Doc2.setCardBackgroundColor(Color.WHITE);
        Doc3.setCardBackgroundColor(Color.WHITE);
        Doc4.setCardBackgroundColor(Color.WHITE);
        Doc5.setCardBackgroundColor(Color.WHITE);
        Doc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Doc1Intent = new Intent(DoctorActivity.this , Doc1.class);
                startActivity( Doc1Intent );
            }
        });
        Doc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Doc2Intent = new Intent(DoctorActivity.this , Doc1.class);
                startActivity( Doc2Intent );
            }
        });
        Doc3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Doc3Intent = new Intent(DoctorActivity.this , Doc1.class);
                startActivity( Doc3Intent );
            }
        });
        Doc4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Doc4Intent = new Intent(DoctorActivity.this , Doc1.class);
                startActivity( Doc4Intent );
            }
        });
        Doc5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Doc5Intent = new Intent(DoctorActivity.this , Doc1.class);
                startActivity( Doc5Intent );
            }
        });


    }
}