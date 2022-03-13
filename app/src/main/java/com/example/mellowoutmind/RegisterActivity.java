package com.example.mellowoutmind;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText mEmail , mPass;
    private TextView mTextView;
    private Button signUpBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mEmail=findViewById(R.id.email_reg);
        mPass=findViewById(R.id.passreg);
        mTextView=findViewById(R.id.textView);
        signUpBtn=findViewById(R.id.registration_btn);
        mAuth= FirebaseAuth.getInstance();

        mTextView.setOnClickListener((v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
        }));

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser();
                String email =mEmail.getText().toString();
                String pass =mPass.getText().toString();

                if(!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if(!pass.isEmpty()){
                        mAuth.createUserWithEmailAndPassword(email, pass)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        Toast.makeText(RegisterActivity.this, "Registered Succesfull!!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(RegisterActivity.this, "Registration error!!", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else {
                        mPass.setError("Empty fields are not allowed");
                    }
                }else{
                    mEmail.setError("Empty fields are not allowed");
                }
                ;
            }
        });

    }
    private void createUser(){
    }
}