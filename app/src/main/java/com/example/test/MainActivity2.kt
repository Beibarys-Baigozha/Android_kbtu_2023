package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    private lateinit var studentDao: StudentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val db = DBmanager.getDatabase(applicationContext)
        studentDao = db.studentDao()

        welcomeMessage()
    }

    fun welcomeMessage(){
        intent = Intent(this,MainActivity2::class.java)

        val student = studentDao.getStudentById(intent.getIntExtra("id",1))

        if (student != null) {
            val text = findViewById<TextView>(R.id.wlcm_text)
            text.setText("Welcome " + student.name)
        }

        else{
            Toast.makeText(this,"Student doesn't exist", Toast.LENGTH_SHORT).show()
        }
    }

}