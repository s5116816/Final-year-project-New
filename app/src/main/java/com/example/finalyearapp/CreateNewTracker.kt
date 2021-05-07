package com.example.finalyearapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class CreateNewTracker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_tracker)
    }

    fun toInputOne(view: View){

        val intent = Intent(this, inputModule::class.java)
        startActivity(intent)

    }

}