package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note :Note) // to make backgrounf task faster and easier without lag

    @Delete
    suspend fun delete(note:Note)

    @Query("Select * from NOTES_TABLE order by id ASC")
    fun generateAllNotes(): LiveData<List<Note>>// we can observe live data we can see all the changes
}