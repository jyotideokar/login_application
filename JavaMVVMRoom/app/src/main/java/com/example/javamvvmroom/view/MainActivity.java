package com.example.javamvvmroom.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.javamvvmroom.R;
import com.example.javamvvmroom.model.database.entity.Note;
import com.example.javamvvmroom.view.adapter.NoteRecyclerAdapter;
import com.example.javamvvmroom.viewmodel.NoteViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, NoteRecyclerAdapter.OnItemClickListener {
    private NoteViewModel noteViewModel;
    private RecyclerView noteRecyclerView;
    private NoteRecyclerAdapter noteRecyclerAdapter;
    private FloatingActionButton fabAdd;
    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteRecyclerView = findViewById(R.id.noteRecyclerView);
        fabAdd = findViewById(R.id.fabAdd);
        noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        noteRecyclerAdapter = new NoteRecyclerAdapter(MainActivity.this);
        noteRecyclerView.setAdapter(noteRecyclerAdapter);
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.initData(getApplication());
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                noteRecyclerAdapter.setNoteList(notes);
            }
        });
        fabAdd.setOnClickListener(this);
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                noteViewModel.deleteNote(noteRecyclerAdapter.getNote(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Note Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(noteRecyclerView);
        noteRecyclerAdapter.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fabAdd:
                showAddAlertDialog(new Note("", "", 1), false);
                break;
        }
    }

    private void showAddAlertDialog(Note note, boolean fromUpdated) {
        View customDialogLayout = LayoutInflater.from(this).inflate(R.layout.custom_add_note_dialog_layout, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(customDialogLayout);
        TextView titleTextView = customDialogLayout.findViewById(R.id.titleTextView);
        TextInputEditText titleEditText = customDialogLayout.findViewById(R.id.titleEditText);
        TextInputEditText descriptionEditText = customDialogLayout.findViewById(R.id.descriptionEditText);
        Button cancelButton = customDialogLayout.findViewById(R.id.buttonCancel);
        Button saveButton = customDialogLayout.findViewById(R.id.buttonSave);
        if (fromUpdated) {
            titleEditText.setText(note.getTitle());
            descriptionEditText.setText(note.getDescription());
            titleTextView.setText("Update Note");
            saveButton.setText("Update");
        }
        AlertDialog alertDialog = builder.create();
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleEditText.getText().toString().trim();
                String description = descriptionEditText.getText().toString();
                if (title.length() > 0) {
                    if (fromUpdated) {
                        note.setTitle(title);
                        note.setDescription(description);
                        noteViewModel.updateNote(note);
                    } else {
                        noteViewModel.insertNote(new Note(title, description, 1));
                    }
                    alertDialog.dismiss();
                } else {
                    Toast.makeText(MainActivity.this, "Please enter title", Toast.LENGTH_SHORT).show();
                }

            }
        });
        alertDialog.show();
    }

    @Override
    public void onItemClick(Note note) {
        showAddAlertDialog(note, true);
    }
}