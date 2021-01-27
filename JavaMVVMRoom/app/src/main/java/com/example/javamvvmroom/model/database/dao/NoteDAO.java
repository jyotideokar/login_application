package com.example.javamvvmroom.model.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.javamvvmroom.model.database.entity.Note;

import java.util.List;

@Dao
public interface NoteDAO {

    @Insert
    public void insertNote(Note note);

    @Update
    public int updateNote(Note note);

    @Delete
    public int deleteNote(Note note);

    @Query("Select * from note_table order by priority desc")
    public LiveData<List<Note>> getAllNotes();

    @Query("Select * from note_table where id=:id")
    public LiveData<Note> getNote(int id);
}
