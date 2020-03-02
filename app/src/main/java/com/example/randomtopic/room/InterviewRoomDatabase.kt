package com.example.randomtopic.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.randomtopic.room.dao.InterviewDao
import com.example.randomtopic.room.entity.InterviewTopics
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [InterviewTopics::class], version = 1, exportSchema = false)

abstract class InterviewRoomDatabase : RoomDatabase() {
    abstract fun interviewDao(): InterviewDao

    companion object {
        @Volatile
        private var INSTANCE: InterviewRoomDatabase? = null

        fun getDataBase(
            context: Context,
            scope: CoroutineScope
        ): InterviewRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InterviewRoomDatabase::class.java,
                    "topic_database"
                )
                    .addCallback(InterviewDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }

        private class InterviewDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.interviewDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(interviewDao: InterviewDao) {
            interviewDao.deleteAll()

            var topic = InterviewTopics("Singleton")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics("Java Collections")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Thread")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("OOP")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Java Finally")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Activity")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Service")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Broadcast Receiver")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Fragments")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("MVVM")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("JetPack")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("GSON")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Moshi")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("ViewModel")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("RxJava")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("AsyncTask")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("LiveData")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Navigation")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Databinding")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Room")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("WorkManager")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Navigation")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Retrofit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Main Thread")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Explicit Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Implicit Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("JUnit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Espresso")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Mockito")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Gradle")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Robolectric")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("View")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Okhttp")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Volley")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Glide")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Picasso")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Coil")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Module")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Val")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Var")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("lateinit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Lazy")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Extension Functions")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Android Extensions")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Coroutines")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Data Class")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Infix")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Inline")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Visibility Modifiers")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Access Modifiers")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("Classes and Inheritance")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("?.")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("!!")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics ("?:")
            interviewDao.insertTopic(topic)
        }
    }
}