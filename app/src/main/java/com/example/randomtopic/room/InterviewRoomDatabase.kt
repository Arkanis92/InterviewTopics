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

            var topic = InterviewTopics(0,"Singleton")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics(1,"Java Collections")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (2,"Thread")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (3,"OOP")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (4,"Java Finally")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (5,"Activity")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (6,"Service")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (7,"Broadcast Receiver")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (8,"Fragments")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (9,"MVVM")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (10,"JetPack")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (11,"GSON")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (12,"Moshi")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (13,"ViewModel")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (14,"RxJava")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (15,"AsyncTask")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (16,"LiveData")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (17,"Navigation")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (18,"Databinding")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (19,"Room")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (20,"WorkManager")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (21,"Navigation")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (22,"Retrofit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (23,"Main Thread")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (24,"Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (25,"Explicit Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (26,"Implicit Intent")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (27,"JUnit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (28,"Espresso")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (29,"Mockito")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (30,"Gradle")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (31,"Robolectric")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (32,"View")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (33,"Okhttp")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (34,"Volley")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (35,"Glide")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (36,"Picasso")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (37,"Coil")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (38,"Module")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (39,"Val")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (40,"Var")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (41,"lateinit")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (42,"Lazy")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (43,"Extension Functions")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (44,"Android Extensions")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (45,"Coroutines")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (46,"Data Class")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (47,"Infix")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (48,"Inline")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (49,"Visibility Modifiers")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (50,"Access Modifiers")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (51,"Classes and Inheritance")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (52,"?.")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (53,"!!")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics (54,"?:")
            interviewDao.insertTopic(topic)
        }
    }
}