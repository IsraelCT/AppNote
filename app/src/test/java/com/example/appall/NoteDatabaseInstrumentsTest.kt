package com.example.appall

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appall.data.notes.NoteDao
import com.example.appall.data.notes.NoteEntity
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NoteDatabaseInstrumentsTest {
    private lateinit var noteDao: NoteDao
    private lateinit var db:

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, TestDatabase::class.java).build()
        userDao = db.getUserDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val user: User = TestUtil.createUser(3).apply {
            setName("george")
        }
        userDao.insert(user)
        val byName = userDao.findUsersByName("george")
        assertThat(byName.get(0), equalTo(user))
    }
}