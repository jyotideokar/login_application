package com.example.javamvvmroom.model.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.javamvvmroom.model.database.NoteDatabase;
import com.example.javamvvmroom.model.database.dao.NoteDAO;
import com.example.javamvvmroom.model.database.entity.Note;

import java.util.List;

public class NoteRepository {

    private NoteDAO noteDAO;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getInstance(application);
        noteDAO = noteDatabase.noteDAO();
        allNotes = noteDAO.getAllNotes();
    }


    public LiveData<Note> getNoteById(int id) {
        return noteDAO.getNote(id);
    }

    public void insertNote(Note note) {
        new InsertNoteAsyncTask(noteDAO).execute(note);
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDAO noteDAO;

        InsertNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insertNote(notes[0]);
            return null;
        }
    }

    public void updateNote(Note note) {
        new UpdateNoteAsyncTask(noteDAO).execute(note);
    }

    static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDAO noteDAO;

        UpdateNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.updateNote(notes[0]);
            return null;
        }
    }

    public void deleteNote(Note note) {
        new DeleteNoteAsyncTask(noteDAO).execute(note);
    }

    static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        NoteDAO noteDAO;

        DeleteNoteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.deleteNote(notes[0]);
            return null;
        }
    }
}
