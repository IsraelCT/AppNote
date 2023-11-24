package com.example.appall.data.notes

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.room.*
import com.example.appall.Constants

@Dao
interface NoteDao {
    @Query("SELECT * FROM ${Constants.note_table_name}")
    fun getAll(): List<NoteEntity>

    @Insert
    fun insert(noteEntity: NoteEntity)

    @Delete
    fun delete(noteEntity: NoteEntity)
    @Update
    fun update(noteEntity: NoteEntity)

}