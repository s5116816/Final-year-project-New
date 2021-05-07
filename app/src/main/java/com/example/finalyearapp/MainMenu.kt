package com.example.finalyearapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    //Functions below handle navigation throughout the app
    fun toAbout(view: View){
        val intent = Intent(this,AboutApp::class.java)
            startActivity(intent)
    }

    //button to advance to CreateNewTracker module
    fun toCreateNewTracker(view: View){
        val intent = Intent(this,CreateNewTracker::class.java)
        startActivity(intent)
    }

    //does not work
    fun toTracker(view: View){
        val intent = Intent(this,trackerModule::class.java)
        startActivity(intent)
    }

    fun toUserInfo(view: View){
        val intent = Intent(this,UserInfoModule::class.java)
        startActivity(intent)
    }



}