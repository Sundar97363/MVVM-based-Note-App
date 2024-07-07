package com.sundar.mvvmbasednoteapp.ui.note

import androidx.lifecycle.ViewModel
import com.sundar.mvvmbasednoteapp.data.sources.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class HomeNoteViewModel(
    private val noteRepository: NoteRepository
):ViewModel() {

}