package com.example.challange4.room

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class NoteViewModel (application : Application) : AndroidViewModel(application){

    val repo : NoteRepository

    init {
        val dao = NoteDatabase.getInstance(application)!!.noteDao()
        repo = NoteRepository(dao)
    }

    fun getNote(): LiveData<List<DataNote>> = repo.getAllNote()

    fun addNote(note : DataNote) {
        repo.insertNote(note)
    }
}