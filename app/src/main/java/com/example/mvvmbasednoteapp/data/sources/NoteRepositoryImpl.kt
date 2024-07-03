package com.example.mvvmbasednoteapp.data.sources

import com.example.mvvmbasednoteapp.data.sources.local.model.Note
import kotlinx.coroutines.flow.Flow

class NoteRepositoryImpl:NoteRepository {
    override suspend fun insertNote(note: Note) {

    }

    override suspend fun upsertNote(note: Note) {

    }

    override fun getAllNote(): Flow<List<Note>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNote(note: Note) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNoteById(noteId: Long) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNotes() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAllNotesInTrash() {
        TODO("Not yet implemented")
    }

    override fun getNoteStreamById(noteId: Long): Flow<Note> {
        TODO("Not yet implemented")
    }

    override suspend fun getNoteById(noteId: Long): Note {
        TODO("Not yet implemented")
    }
}