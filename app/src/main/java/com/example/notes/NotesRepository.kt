package com.example.notes

import androidx.lifecycle.LiveData

class NotesRepository(private val noteDao: NoteDao) {

    val allnotes :LiveData<List<Note>> = noteDao.generateAllNotes()

    suspend fun insert(note:Note){
        noteDao.insert(note)
    }
    suspend fun delete(note:Note){
        noteDao.delete(note)
    }
}