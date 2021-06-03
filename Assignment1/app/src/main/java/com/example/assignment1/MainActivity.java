package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button signButton;
    private EditText usernameText, emailText, passwordText, confirmText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signButton = findViewById(R.id.signButton);
        usernameText = findViewById(R.id.usernameText);
        emailText = findViewById(R.id.emailText);
        passwordText = findViewById(R.id.passwordText);
        confirmText = findViewById(R.id.confirmText);





        signButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1 = usernameText.getText().toString();
                String email1 = emailText.getText().toString();
                String password1 = passwordText.getText().toString();
                String confirmPass1 = confirmText.getText().toString();
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("username",username1);
                intent.putExtra("email",email1);
                intent.putExtra("password",password1);
                intent.putExtra("confirmPassword",confirmPass1);
                startActivity(intent);

            }
        });


    }
}