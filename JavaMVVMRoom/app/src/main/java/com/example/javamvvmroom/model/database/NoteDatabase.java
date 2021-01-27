package com.example.javamvvmroom.model.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.javamvvmroom.model.database.dao.NoteDAO;
import com.example.javamvvmroom.model.database.entity.Note;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance;

    public abstract NoteDAO noteDAO();

    public static NoteDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (NoteDatabase.class) {
                instance = Room.databaseBuilder(context.getApplicationContext(), NoteDatabase.class, "note_database")
                        .fallbackToDestructiveMigration()
                        .addCallback(callback)
                        .build();
            }
        }
        return instance;
    }

    private static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDatabase(instance).execute();
        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }

        @Override
        public void onDestructiveMigration(@NonNull SupportSQLiteDatabase db) {
            super.onDestructiveMigration(db);
        }
    };


    private static class PopulateDatabase extends AsyncTask<Void, Void, Void> {
        private NoteDAO noteDAO;

        PopulateDatabase(NoteDatabase noteDatabase) {
            noteDAO = noteDatabase.noteDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.insertNote(new Note("Title 1", "Description 1", 1));
            noteDAO.insertNote(new Note("Title 2", "Description 2", 2));
            noteDAO.insertNote(new Note("Title 3", "Description 3", 3));
            return null;
        }
    }
}
