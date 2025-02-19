package com.sundar.mvvmbasednoteapp.di

import android.content.Context
import androidx.room.Room
import com.sundar.mvvmbasednoteapp.data.sources.NoteRepository
import com.sundar.mvvmbasednoteapp.data.sources.NoteRepositoryImpl
import com.sundar.mvvmbasednoteapp.data.sources.local.NoteDatabase
import com.sundar.mvvmbasednoteapp.utils.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NoteDatabase {
        return Room.databaseBuilder(
            context,
            NoteDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Singleton
    @Provides
    fun getRepositoryImpl(noteDatabase: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(noteDatabase)
    }
}