package com.example.randomtopic.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.randomtopic.room.entity.InterviewTopics

@Dao
interface InterviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopic(topics: InterviewTopics)

    @Query("SELECT * FROM topics_table")
    fun getInterviewTopics(): LiveData<List<InterviewTopics>>

    @Query("DELETE FROM topics_table")
    suspend fun deleteAll()
}