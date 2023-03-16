package com.example.test

import androidx.room.*

@Dao
interface StudentDao {
    @Query("SELECT * FROM Student")
    fun getAll(): List<Student>

    @Query("SELECT * FROM Student WHERE name = :studentName")
    fun getStudentByName(studentName: String): Student?

    @Query("SELECT * FROM Student WHERE id = :studentId")
    fun getStudentById(studentId: Int): Student?

    @Insert
    fun insert(user: Student)
}