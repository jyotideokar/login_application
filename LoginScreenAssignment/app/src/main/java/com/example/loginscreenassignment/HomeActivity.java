package com.example.loginscreenassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    private TextView usernametext, emailText, genderText;
    private Button logoutbttn;
    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        usernametext = findViewById(R.id.usernametext);
        emailText = findViewById(R.id.emailText);
        genderText = findViewById(R.id.genderText);
        logoutbttn = findViewById(R.id.logoutbttn);


        sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);

        String name = sharedPreferences.getString("name", null);
        String password = sharedPreferences.getString("password", null);
        String email = sharedPreferences.getString("email", null);
        String gender = sharedPreferences.getString("gender", null);


        if (name != null || email != null) {

            usernametext.setText("Name: " + name);
            emailText.setText("Email: " + email);
            genderText.setText("Gender: " + gender);

        }


        logoutbttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             /*   SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();*/
                Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();



            }
        });


    }
}