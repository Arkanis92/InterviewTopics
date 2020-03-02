package com.example.randomtopic.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.randomtopic.repository.InterviewRepository
import com.example.randomtopic.room.InterviewRoomDatabase
import com.example.randomtopic.room.entity.InterviewTopics
import kotlinx.coroutines.launch

class InterviewViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: InterviewRepository

    val allTopics: LiveData<List<InterviewTopics>>

    init {
        val interviewDao = InterviewRoomDatabase.getDataBase(application, viewModelScope).interviewDao()
        repository = InterviewRepository(interviewDao)
        allTopics = repository.allTopics
    }

    fun insert(topics: InterviewTopics) = viewModelScope.launch {
        repository.insert(topics)
    }
}