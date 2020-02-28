package com.example.randomtopic.repository

import androidx.lifecycle.LiveData
import com.example.randomtopic.room.dao.InterviewDao
import com.example.randomtopic.room.entity.InterviewTopics

class InterviewRepository(private val interviewDao: InterviewDao) {
    val allTopics: LiveData<List<InterviewTopics>> = interviewDao.getInterviewTopics()

    suspend fun insert(topics: InterviewTopics){
        interviewDao.insertTopic(topics)
    }
}