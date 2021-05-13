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
        val createTracker3 = findViewById<Button>(R.id.createTracker3)
        val createTracker4 = findViewById<Button>(R.id.createTracker4)
        val createTracker5 = findViewById<Button>(R.id.createTracker5)
        val createTracker6 = findViewById<Button>(R.id.createTracker6)
        val createTracker7 = findViewById<Button>(R.id.createTracker7)


        val createTrackerPref = applicationContext.getSharedPreferences("createTrackerButtons", Context.MODE_PRIVATE)
        val createTrackerButton1 = createTrackerPref.getBoolean("createTrackerButton1", true)
        val createTrackerButton2 = createTrackerPref.getBoolean("createTrackerButton2", true)
        val createTrackerButton3 = createTrackerPref.getBoolean("createTrackerButton3", true)
        val createTrackerButton4 = createTrackerPref.getBoolean("createTrackerButton4", true)
        val createTrackerButton5 = createTrackerPref.getBoolean("createTrackerButton5", true)
        val createTrackerButton6 = createTrackerPref.getBoolean("createTrackerButton6", true)


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

        if (!createTrackerButton3){

            createTracker3.isEnabled = false
            createTracker3.text = getString(R.string.disableTextTracker)

        }
        else if(createTrackerButton3){

            createTracker3.isEnabled = true
            createTracker3.text = getString(R.string.create_tracker_3)


        }

        if (!createTrackerButton4){

            createTracker4.isEnabled = false
            createTracker4.text = getString(R.string.disableTextTracker)

        }
        else if (createTrackerButton4){

            createTracker4.isEnabled = true
            createTracker4.text = getString(R.string.create_tracker_4)

        }

        //check if tracker one has been made
        if (!createTrackerButton5){

            createTracker5.isEnabled = false
            createTracker5.text = getString(R.string.disableTextTracker)

        }
        else if (createTrackerButton5){

            createTracker5.isEnabled = true
            createTracker5.text = getString(R.string.create_tracker_5)

        }

        if (!createTrackerButton6){

            createTracker6.isEnabled = false
            createTracker6.text = getString(R.string.disableTextTracker)

        }
        else if (createTrackerButton6){

            createTracker6.isEnabled = true
            createTracker6.text = getString(R.string.create_tracker_6)

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

        createTracker3.setOnClickListener(){

            val intent = Intent(this, inputModule3::class.java)
            startActivity(intent)

        }

        createTracker4.setOnClickListener(){

            val intent = Intent(this, inputModule4::class.java)
            startActivity(intent)

        }

        createTracker5.setOnClickListener(){

            val intent = Intent(this, inputModule5::class.java)
            startActivity(intent)

        }

        createTracker6.setOnClickListener(){

            val intent = Intent(this, inputModule6::class.java)
            startActivity(intent)

        }

    }
}