package com.example.noteappwithasmrdev.database

import androidx.room.RoomDatabase

abstract class NoteDatabase: RoomDatabase() {
    abstract fun noteDao():NoteDao
}