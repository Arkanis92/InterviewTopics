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

@Database(entities = [InterviewTopics::class], version = 1)

abstract class InterviewRoomDatabase : RoomDatabase() {
    abstract fun interviewDao(): InterviewDao

    companion object {
        @Volatile
        var INSTANCE: InterviewRoomDatabase? = null

        fun getDataBase(
            context: Context,
            scope: CoroutineScope
        ): InterviewRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    InterviewRoomDatabase::class.java,
                    "topicDB"
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

            var topic = InterviewTopics("Test")
            interviewDao.insertTopic(topic)
            topic = InterviewTopics("Test Topic 2")
            interviewDao.insertTopic(topic)
        }
    }
}