package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import com.google.firebase.firestore.FirebaseFirestore

class AddActivity : AppCompatActivity() {
    private var db: FirebaseFirestore? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        db = FirebaseFirestore.getInstance()
    }

    fun addUser(view: View) {

        val username: String = findViewById<EditText>(R.id.username_edit_text).text.toString()
        val email: String = findViewById<EditText>(R.id.email2_edit_text).text.toString()
        val name: String = findViewById<EditText>(R.id.name_edit_text).text.toString()
        val phoneNo1: String = findViewById<EditText>(R.id.phone_edit_text).text.toString()
        val user1 = hashMapOf(
            "name" to name,
            "username" to username,
            "phoneNo" to phoneNo1
        )

//        db?.collection("Users")?.document(phoneNo1)
//            ?.set(user1)
//            ?.addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
//            ?.addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }

        db?.collection("Users")
            ?.add(user1)
            ?.addOnSuccessListener { Log.d(TAG, "DocumentSnapshot successfully written!") }
            ?.addOnFailureListener { e -> Log.w(TAG, "Error writing document", e) }


        startActivity(Intent(this, MainActivity::class.java))

    }
}