package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class RegistrationActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        auth = FirebaseAuth.getInstance()
    }
    fun registerUser(view: View)  {

        val email: String = findViewById<EditText>(R.id.email_edit_text).text.toString()
        val password: String = findViewById<EditText>(R.id.password_edit_text).text.toString()
        val password2: String = findViewById<EditText>(R.id.re_password_edit_text).text.toString()

        if(password == password2){
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                    } else {
                        Toast.makeText(this, "An error occurred", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}
