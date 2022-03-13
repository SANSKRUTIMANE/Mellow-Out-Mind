package com.example.mellowoutmind;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Patterns;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnFailureListener;
        import com.google.android.gms.tasks.OnSuccessListener;
        import com.google.firebase.auth.AuthResult;
        import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText mEmail , mPass;
    private TextView mTextView;
    private Button signUpBtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail=findViewById((R.id.email_signin));
        mPass=findViewById(R.id.passsignin);
        mTextView=(findViewById(R.id.textView2));
        signUpBtn=(findViewById(R.id.signin_btn));
        mAuth= FirebaseAuth.getInstance();
        mTextView.setOnClickListener((v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        }));
        signUpBtn.setOnClickListener((v) -> { loginUser();});

    }

    public void loginUser() {

        String email = mEmail.getText().toString();
        String pass = mPass.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!pass.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LoginActivity.this, "Login Successfully!!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(LoginActivity.this, Quiz.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "Login Error!!", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                mPass.setError("Empty fields are not allowed");
            }
        } else {
            mEmail.setError("Empty fields are not allowed");
        }
    }
}