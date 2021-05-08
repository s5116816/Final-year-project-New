package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button


class CreateNewTracker : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_new_tracker)

        val selectTracker1 = findViewById<Button>(R.id.selectTracker1)

        val myPref = applicationContext.getSharedPreferences("buttonState", Context.MODE_PRIVATE)
        val buttonState = myPref.getBoolean("booleanVar", true)

        if (!buttonState){

            selectTracker1.isEnabled = false

        }


        selectTracker1.setOnClickListener(){

            val intent = Intent(this, inputModule::class.java)
            startActivity(intent)

        }

    }
}