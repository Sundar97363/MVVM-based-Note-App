package com.example.mvvmbasednoteapp.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mvvmbasednoteapp.data.sources.local.dao.NoteDao
import com.example.mvvmbasednoteapp.data.sources.local.model.Note

@Database(
    entities = [Note::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase: RoomDatabase() {
    abstract val getDao: NoteDao
}