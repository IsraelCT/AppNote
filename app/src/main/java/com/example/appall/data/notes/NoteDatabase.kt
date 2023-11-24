package com.example.appall.data.notes

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.Database
import androidx.room.RoomDatabase

    @Database(entities = [NoteEntity::class], version = 1)
    abstract class NoteDatabase : RoomDatabase() { //Recordar agregar NoteDatabase para inicializarlo en el InstrumentsTest

        abstract fun noteDao(): NoteDao
    }