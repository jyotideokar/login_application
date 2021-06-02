package com.example.recyclerviewgridexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    private TextView name, age1;
    private ImageView imageView;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        name = findViewById(R.id.name);
        age1 = findViewById(R.id.age);
        imageView = findViewById(R.id.image);
        Intent intent = getIntent();
        String personname = intent.getStringExtra("name");
        name.setText(personname);
        image = intent.getIntExtra("image", 0);
        imageView.setImageResource(image);
        String agenumber = intent.getStringExtra("age");
        age1.setText(agenumber);

    }
}