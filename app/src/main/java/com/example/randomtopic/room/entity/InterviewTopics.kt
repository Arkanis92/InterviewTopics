package com.example.randomtopic.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity

data class InterviewTopics(
    @PrimaryKey
    @ColumnInfo(
        name = "topic"
    )
    val topic: String
)