package com.sundar.mvvmbasednoteapp.ui.addedit

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmbasednoteapp.R
import com.sundar.mvvmbasednoteapp.data.sources.NoteRepository
import com.sundar.mvvmbasednoteapp.data.sources.local.model.Note
import com.sundar.mvvmbasednoteapp.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddEditViewModel @Inject constructor(
    private val repository: NoteRepository
) : ViewModel() {

    val title: MutableStateFlow<String> = MutableStateFlow("")
    val description: MutableStateFlow<String> = MutableStateFlow("")

    private val _noteIdEvent = MutableLiveData<Event<Long>>()
    val noteIdEvent: LiveData<Event<Long>> = _noteIdEvent

    private val _backPressEvent = MutableLiveData<Event<Unit>>()
    val backPressEvent: LiveData<Event<Unit>> = _backPressEvent

    private val _snackBarEvent = MutableLiveData<Event<Int>>()
    val snackBarEvent: LiveData<Event<Int>> = _snackBarEvent

    var noteId: Long = -1L
    private var isNewNote: Boolean = false


    fun decideBasedOnNote(noteId: Long) {

        this.noteId = noteId

        if (noteId == -1L) { // -1 means this is new note
            isNewNote = true
            return
        }

        isNewNote = false // else update the existing note

        viewModelScope.launch {
            val note = repository.getNoteStreamById(noteId).stateIn(viewModelScope)
            title.value = note.value.title
            description.value = note.value.description
        }

    }

    fun saveAndExit() {

        val currentTitle = title.value
        val currentDescription = description.value

        if (isNewNote) {

            if (currentTitle.isBlank() && currentDescription.isBlank()) {
                _snackBarEvent.value = Event(R.string.empty_note_message)
            } else {
                val note = Note(
                    id = 0L,
                    title = title.value,
                    description = description.value
                )
                createNote(note)
            }

        } else {
            if (currentTitle.isBlank() && currentDescription.isBlank()) {
                _snackBarEvent.value =
                    Event(R.string.empty_note_message)
            } else {
                updateNote()
            }

        }
        _noteIdEvent.value = Event(noteId)

        _backPressEvent.value = Event(Unit)

    }

    private fun createNote(note: Note) = viewModelScope.launch {
        repository.insertNote(note)
    }

    private fun updateNote() = viewModelScope.launch { // update the existing note
        repository.upsertNote(
            Note(
                noteId,
                title.value,
                description.value
            )
        )
    }
}