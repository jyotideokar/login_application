package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    private TextView userText, emailText, passwordText, confirmPasswordText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        confirmPasswordText = findViewById(R.id.confirmPasswordText);
        passwordText = findViewById(R.id.passwordText);
        emailText = findViewById(R.id.emailText);
        userText = findViewById(R.id.userText);


        Intent intent = getIntent();

        String name = intent.getStringExtra("username");
        userText.setText(name);

        String emailname = intent.getStringExtra("email");
        emailText.setText(emailname);
        String passwordname = intent.getStringExtra("password");
        passwordText.setText(passwordname);


        String confirmPasswordname = intent.getStringExtra("confirmPassword");
        confirmPasswordText.setText(confirmPasswordname);

    }
}
