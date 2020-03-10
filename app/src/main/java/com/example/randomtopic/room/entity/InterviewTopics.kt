package com.example.randomtopic.room.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "topics_table")

data class InterviewTopics(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val topic: String
)