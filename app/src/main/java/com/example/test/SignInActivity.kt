package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignInActivity : AppCompatActivity() {
    private lateinit var studentDao: StudentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val db = DBmanager.getDatabase(applicationContext)
        studentDao = db.studentDao()

        findViewById<Button>(R.id.signIn_button).setOnClickListener { loginIn() }
    }

    fun loginIn(){
        val login = findViewById<EditText>(R.id.eMail_EdText).text.toString()
        val password = findViewById<EditText>(R.id.pswrd_EdText).text.toString()

        val student = studentDao.getStudentByName(login)

        if(student != null && password == student.password) {
            val intent = Intent(this,MainActivity2::class.java)
            intent.putExtra("id", student.id)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Wrong username or password", Toast.LENGTH_SHORT).show()
        }
    }
}























/*  private lateinit var binding:ActivitySignInBinding
    private lateinit var firebaseAuth: FirebaseAuth*/



/* binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.signInButton.setOnClickListener {
            val email = binding.eMailEdText.text.toString()
            val pass = binding.pswrdEdText.text.toString()

            /*if (email.isNotEmpty() && pass.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity2::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                    }
                }
            }
            else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }*/
        }
    }*/