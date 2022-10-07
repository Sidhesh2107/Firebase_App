package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class second_activity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        auth = FirebaseAuth.getInstance()
    }

    fun loginUser(view: View) {
        val email: String = findViewById<EditText>(R.id.login_email_edit_text).text.toString()
        val password: String = findViewById<EditText>(R.id.login_password_edit_text).text.toString()

        auth.signInWithEmailAndPassword(email , password)
            .addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Unable to Login. Check Your Credentials and try later", Toast.LENGTH_SHORT).show()
                }
            }
    }
}