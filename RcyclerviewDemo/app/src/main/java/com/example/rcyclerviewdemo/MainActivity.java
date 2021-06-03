package com.example.rcyclerviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview);

        UserModel []  userModels = new UserModel[]{
                new UserModel(R.drawable.ic_launcher_background,"person 1"),
                new UserModel(R.drawable.ic_launcher_foreground,"person 2"),
                new UserModel(R.drawable.ic_launcher_foreground,"person 3"),
                new UserModel(R.drawable.ic_launcher_background,"person 4"),
                new UserModel(R.drawable.ic_launcher_background,"person 5"),
        };

        UserAdaptor userAdaptor = new UserAdaptor(userModels);
        recyclerView.setAdapter(userAdaptor);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);















    }
}