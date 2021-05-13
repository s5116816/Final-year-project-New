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
        val createTracker2 = findViewById<Button>(R.id.createTracker2)

        val createTrackerPref = applicationContext.getSharedPreferences("createTrackerButtons", Context.MODE_PRIVATE)
        val createTrackerButton1 = createTrackerPref.getBoolean("createTrackerButton1", true)
        val createTrackerButton2 = createTrackerPref.getBoolean("createTrackerButton2", true)

        //check if tracker one has been made
        if (!createTrackerButton1){

            createTracker1.isEnabled = false
            createTracker1.text = getString(R.string.disableTextTracker)

        }
        else if (createTrackerButton1){

            createTracker1.isEnabled = true
            createTracker1.text = getString(R.string.create_tracker_1)

        }


        if (!createTrackerButton2){

            createTracker2.isEnabled = false
            createTracker2.text = getString(R.string.disableTextTracker)

        }
        else if (createTrackerButton2){

            createTracker2.isEnabled = true
            createTracker2.text = getString(R.string.create_tracker_2)


        }


        //Button accessing their respective input modules
        createTracker1.setOnClickListener(){

            val intent = Intent(this, inputModule::class.java)
            startActivity(intent)

        }

        createTracker2.setOnClickListener(){

            val intent = Intent(this, inputModule2::class.java)
            startActivity(intent)

        }

    }
}