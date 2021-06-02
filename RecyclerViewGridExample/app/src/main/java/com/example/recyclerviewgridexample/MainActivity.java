package com.example.recyclerviewgridexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private List<ModelClass> modelClasses;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recyclerview);

        modelClasses = new ArrayList<>();
        modelClasses.add(new ModelClass(R.drawable.ic_launcher_background, "hello", 23));
        modelClasses.add(new ModelClass(R.drawable.ic_launcher_foreground, "pillu", 23));
        modelClasses.add(new ModelClass(R.drawable.ic_launcher_foreground,"Savita",43));
        UserAdaptor userAdaptor = new UserAdaptor(modelClasses);
        recyclerview.setAdapter(userAdaptor);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        recyclerview.setLayoutManager(gridLayoutManager);

    }
}