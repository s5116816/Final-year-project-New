package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //variable holding buttons to trackers
        val trackerButton1 = findViewById<Button>(R.id.trackerButton1)
        val trackerButton2 = findViewById<Button>(R.id.trackerButton2)
        val trackerButton3 = findViewById<Button>(R.id.trackerButton3)
        val trackerButton4 = findViewById<Button>(R.id.trackerButton4)

        val unlockTrackerPref = getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)
        val tracker1 = unlockTrackerPref.getBoolean("tracker1", false)
        val tracker2 = unlockTrackerPref.getBoolean("tracker2", false)
        val tracker3 = unlockTrackerPref.getBoolean("tracker3", false)


        if (tracker1) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name1 = namePref.getString("userName1", "")

            trackerButton1.isEnabled = true
            trackerButton1.text = name1

        } else if (!tracker1) {

            trackerButton1.isEnabled = false
            trackerButton1.text = getText(R.string.trackerButton).toString()

        }

        if (tracker2) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name2 = namePref.getString("userName2", "")

            trackerButton2.isEnabled = true
            trackerButton2.text = name2

        } else if (!tracker2) {

            trackerButton2.isEnabled = false
            trackerButton2.text = getText(R.string.trackerButton).toString()

        }


        if (tracker3) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name2 = namePref.getString("userName3", "")

            trackerButton3.isEnabled = true
            trackerButton3.text = name2


        } else if (!tracker3) {

            trackerButton3.isEnabled = false
            trackerButton3.text = getText(R.string.trackerButton).toString()

        }



        trackerButton1.setOnClickListener() {

            val intent = Intent(this, trackerModule::class.java)
            startActivity(intent)

        }

        trackerButton2.setOnClickListener() {

            val intent = Intent(this, trackerModule2::class.java)
            startActivity(intent)

        }


        trackerButton3.setOnClickListener() {

            val intent = Intent(this, trackerModule3::class.java)
            startActivity(intent)

        }


    }

    //Functions below handle navigation throughout the app
    fun toAbout(view: View) {
        val intent = Intent(this, AboutApp::class.java)
        startActivity(intent)
    }

    //button to advance to CreateNewTracker module
    fun toCreateNewTracker(view: View) {
        val intent = Intent(this, CreateNewTracker::class.java)
        startActivity(intent)
    }


    fun toUserInfo(view: View) {
        val intent = Intent(this, UserInfoModule::class.java)
        startActivity(intent)
    }


}