package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun gotoLogin(view: View){
        startActivity(Intent(this, second_activity::class.java))

    }
    fun gotoReg(view: View){
        startActivity(Intent(this, RegistrationActivity::class.java))

    }
    fun gotoAdd(view: View){
        startActivity(Intent(this, AddActivity::class.java))
    }
    fun gotoRead(view: View){
        startActivity((Intent(this, ReadActivity::class.java)))
    }
}






































