package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
class SignUpActivity : AppCompatActivity() {
    private lateinit var studentDao: StudentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val db = DBmanager.getDatabase(applicationContext)
        studentDao = db.studentDao()

        val signUpButton = findViewById<Button>(R.id.signUp_button).setOnClickListener {
            signUp()
        }
    }

    fun signUp(){
        val name = findViewById<EditText>(R.id.eMail_EdText).text.toString()
        val password = findViewById<EditText>(R.id.pswrd_EdText).text.toString()
        val confirmpswrd = findViewById<EditText>(R.id.pswrd2_EdText).text.toString()

        if(password == confirmpswrd) {
            val student = Student(0, name, password)
            studentDao.insert(student)
            intent = Intent(this,MainActivity2::class.java)
            startActivity(intent)
        }
        else {
            Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
        }
    }
}










































/*  binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        binding.toSignInText.setOnClickListener{
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
        binding.signUpButton.setOnClickListener {
            val email = binding.eMailEdText.text.toString()
            val pass = binding.pswrdEdText.text.toString()
            val confirmPass = binding.pswrd2EdText.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty()){
                if (pass == confirmPass){
                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent = Intent(this, SignInActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }
            else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }
        }*/
