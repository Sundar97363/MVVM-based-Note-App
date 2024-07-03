package com.example.mvvmbasednoteapp.data.sources

import com.example.mvvmbasednoteapp.data.sources.local.NoteDatabase
import com.example.mvvmbasednoteapp.data.sources.local.model.Note
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val noteDatabase: NoteDatabase,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
):NoteRepository {

    override suspend fun insertNote(note: Note) = withContext(dispatcher){
        noteDatabase.getDao.insertNote(note)
    }

    override suspend fun upsertNote(note: Note) {
        noteDatabase.getDao.upsertNote(note)
    }

    override fun getAllNote(): Flow<List<Note>> {
        return noteDatabase.getDao.getAllNotes()
    }

    override suspend fun deleteNote(note: Note) {
        noteDatabase.getDao.deleteNote(note)
    }

    override suspend fun deleteNoteById(noteId: Long) {
        noteDatabase.getDao.deleteNoteById(noteId)
    }

    override suspend fun deleteAllNotes() {
        noteDatabase.getDao.deleteAllNotes()
    }

    override fun getNoteStreamById(noteId: Long): Flow<Note> {
        return noteDatabase.getDao.getNoteStream(noteId)
    }

    override suspend fun getNoteById(noteId: Long): Note {
        return withContext(dispatcher){
            noteDatabase.getDao.getNoteById(noteId)
        }
    }
}