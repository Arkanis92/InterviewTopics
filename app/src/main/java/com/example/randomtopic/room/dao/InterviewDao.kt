package com.example.randomtopic.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.randomtopic.room.entity.InterviewTopics

@Dao
interface InterviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTopic(topics: InterviewTopics)

    @Update
    fun updateTopic(topics: InterviewTopics)

    @Query("SELECT * FROM InterviewTopics")
    fun getInterviewTopics(): LiveData<List<InterviewTopics>>

    @Query("DELETE FROM InterviewTopics")
    suspend fun deleteAll()
}