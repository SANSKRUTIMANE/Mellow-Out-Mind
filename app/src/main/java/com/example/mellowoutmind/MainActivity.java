package com.example.mellowoutmind;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finders();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent login_intent=new Intent(MainActivity.this,LoginActivity.class) ;
                startActivity(login_intent);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent=new Intent(MainActivity.this,RegisterActivity.class) ;
                startActivity(register_intent);
            }
        });
    }
    public void finders(){
       login=findViewById(R.id.login_button);
       register=findViewById(R.id.register_button);
    }
}