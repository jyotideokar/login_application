package com.example.loginscreenassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    private EditText usernameEdit, passwordEdit;
    private Button continueBttn;

    String password, name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        continueBttn = findViewById(R.id.continueBttn);
        usernameEdit = findViewById(R.id.usernameEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);

        name = sharedPreferences.getString("name", " ");
        password = sharedPreferences.getString("password", " ");


        continueBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = usernameEdit.getText().toString();
                String passwordtext = passwordEdit.getText().toString();

                if (text.equals(name) && passwordtext.equals(password)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Please Enter correct username and password", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}