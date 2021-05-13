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

        val createTracker1 = findViewById<Button>(R.id.createTracker1)

        val createTrackerPref = applicationContext.getSharedPreferences("createTrackerButtons", Context.MODE_PRIVATE)
        val createTrackerButton1 = createTrackerPref.getBoolean("createTrackerButton1", true)

        //check if tracker one has been made
        if (!createTrackerButton1){

            createTracker1.isEnabled = false
            createTracker1.text = getString(R.string.disableTextTracker1)

        }
        else if (createTrackerButton1){

            createTracker1.isEnabled = true
            createTracker1.text = getString(R.string.create_tracker_1)

        }


        createTracker1.setOnClickListener(){

            val intent = Intent(this, inputModule::class.java)
            startActivity(intent)

        }

    }
}