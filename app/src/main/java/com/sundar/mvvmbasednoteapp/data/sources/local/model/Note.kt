package com.sundar.mvvmbasednoteapp.data.sources.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("note_table")
data class Note(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("note_id")
    var id: Long,

    @ColumnInfo("Title")
    val title: String,

    @ColumnInfo("Description")
    val description: String
)