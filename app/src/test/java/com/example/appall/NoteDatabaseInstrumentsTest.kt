import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.appall.data.notes.NoteDao
import com.example.appall.data.notes.NoteDatabase
import com.example.appall.data.notes.NoteEntity
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException


@RunWith(AndroidJUnit4::class)
class NoteDatabaseInstrumentsTest {
    private lateinit var noteDao: NoteDao
    private lateinit var db: NoteDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, NoteDatabase::class.java
        ).build()
        noteDao = db.noteDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    @Test
    @Throws(Exception::class)
    fun writeUserAndReadInList() {
        val title = "viaje"
        val noteEntity = NoteEntity(uid = 1, title, body = "Alistar Comida")
        noteDao.insert(noteEntity = noteEntity)
        val notes= noteDao.getAll()
        noteDao.delete(noteEntity = noteEntity)
        println(notes)
        assertEquals(notes[0].title,title)
    }
}
