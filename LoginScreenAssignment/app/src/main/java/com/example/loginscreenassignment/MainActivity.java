package com.example.loginscreenassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEdittext, passwordEdittext, emailEdittext;
    private RadioGroup radioGrp;
    private RadioButton femaleBttn, maleBttn;
    private CheckBox indiaCheck, usaCheck, ukCheck;
    private Button saveBttn;
    SharedPreferences sharedPreferences;
    String username;
    RadioButton checkbttn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maleBttn = findViewById(R.id.maleBttn);
        femaleBttn = findViewById(R.id.femaleBttn);
        usernameEdittext = findViewById(R.id.usernameEdittext);
        emailEdittext = findViewById(R.id.emailEdittext);
        passwordEdittext = findViewById(R.id.passwordEdittext);
        saveBttn = findViewById(R.id.saveBttn);
        radioGrp = findViewById(R.id.radioGrp);
        sharedPreferences = getSharedPreferences("demo", MODE_PRIVATE);
        username = sharedPreferences.getString("name", null);
        if (username != null) {

            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }
        saveBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = usernameEdittext.getText().toString();
                checkbttn = findViewById(radioGrp.getCheckedRadioButtonId());
                if (text.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter All Field", Toast.LENGTH_SHORT).show();


                } else {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", usernameEdittext.getText().toString());
                    editor.putString("password", passwordEdittext.getText().toString());
                    editor.putString("email", emailEdittext.getText().toString());
                    editor.putString("gender", checkbttn.getText().toString());
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    startActivity(intent);

                }
            }

        });


    }

}