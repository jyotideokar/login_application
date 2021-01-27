package com.example.javamvvmroom.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.javamvvmroom.model.database.entity.Note;
import com.example.javamvvmroom.model.repository.NoteRepository;

import java.util.List;

public class NoteViewModel extends ViewModel {
    private NoteRepository noteRepository;
    private LiveData<List<Note>> allNotes;


    public void initData(Application application) {
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }


    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    public void insertNote(Note note) {
        noteRepository.insertNote(note);
    }

    public void updateNote(Note note) {
        noteRepository.updateNote(note);
    }

    public void deleteNote(Note note) {
        noteRepository.deleteNote(note);
    }

    public LiveData<Note> getNoteById(int id) {
        return noteRepository.getNoteById(id);
    }
}
