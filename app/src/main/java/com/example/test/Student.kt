package com.example.test

import androidx.room.*

@Entity
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val password: String
)