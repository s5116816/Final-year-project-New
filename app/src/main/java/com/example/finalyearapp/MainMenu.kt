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

        val myPref = getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)

        val tracker1 = myPref.getBoolean("trackerButton1", false)

        if (tracker1) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name1 = namePref.getString("userName1", "")

            trackerButton1.isEnabled = true
            trackerButton1.text = name1

        } else if (!tracker1) {

            trackerButton1.isEnabled = false
            trackerButton1.text = getText(R.string.trackerButton).toString()

        }


        trackerButton1.setOnClickListener() {

            val intent = Intent(this, trackerModule::class.java)
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