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
        val trackerButton5 = findViewById<Button>(R.id.trackerButton5)
        val trackerButton6 = findViewById<Button>(R.id.trackerButton6)
        val trackerButton7 = findViewById<Button>(R.id.trackerButton7)

        val unlockTrackerPref = getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)
        val tracker1 = unlockTrackerPref.getBoolean("tracker1", false)
        val tracker2 = unlockTrackerPref.getBoolean("tracker2", false)
        val tracker3 = unlockTrackerPref.getBoolean("tracker3", false)
        val tracker4 = unlockTrackerPref.getBoolean("tracker4", false)
        val tracker5 = unlockTrackerPref.getBoolean("tracker5", false)
        val tracker6 = unlockTrackerPref.getBoolean("tracker6",false)
        val tracker7 = unlockTrackerPref.getBoolean("tracker7", false)


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
            val name3 = namePref.getString("userName3", "")

            trackerButton3.isEnabled = true
            trackerButton3.text = name3


        } else if (!tracker3) {

            trackerButton3.isEnabled = false
            trackerButton3.text = getText(R.string.trackerButton).toString()

        }

        if (tracker4) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name4 = namePref.getString("userName4", "")

            trackerButton4.isEnabled = true
            trackerButton4.text = name4

        }
         else if (!tracker4) {

            trackerButton4.isEnabled = false
            trackerButton4.text = getText(R.string.trackerButton).toString()

        }

        if (tracker5){

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name5 = namePref.getString("userName5", "")

            trackerButton5.isEnabled = true
            trackerButton5.text = name5

        }
        else if (!tracker5){

            trackerButton5.isEnabled = false
            trackerButton5.text = getText(R.string.trackerButton).toString()

        }


        if (tracker6) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name6 = namePref.getString("userName6", "")

            trackerButton6.isEnabled = true
            trackerButton6.text = name6

        } else if (!tracker6) {

            trackerButton6.isEnabled = false
            trackerButton6.text = getText(R.string.trackerButton).toString()

        }

        if (tracker7) {

            val namePref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val name7 = namePref.getString("userName7", "")

            trackerButton7.isEnabled = true
            trackerButton7.text = name7

        } else if (!tracker7) {

            trackerButton7.isEnabled = false
            trackerButton7.text = getText(R.string.trackerButton).toString()

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

        trackerButton4.setOnClickListener() {

            val intent = Intent(this, trackerModule4::class.java)
            startActivity(intent)

        }

        trackerButton5.setOnClickListener(){

            val intent = Intent(this, trackerModule5::class.java)
            startActivity(intent)

        }

        trackerButton6.setOnClickListener(){

            val intent = Intent(this, trackerModule6::class.java)
            startActivity(intent)

        }
        
        trackerButton7.setOnClickListener(){

            val intent = Intent(this, trackerModule7::class.java)
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