package com.example.mvvmbasednoteapp.data.sources

import com.example.mvvmbasednoteapp.data.sources.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun insertNote(note: Note)

    suspend fun upsertNote(note: Note)

    fun getAllNote(): Flow<List<Note>>

    suspend fun deleteNote(note: Note)

    suspend fun deleteNoteById(noteId: Long)

    suspend fun deleteAllNotes()

    suspend fun deleteAllNotesInTrash()

    fun getNoteStreamById(noteId: Long): Flow<Note>

    suspend fun getNoteById(noteId: Long): Note
}