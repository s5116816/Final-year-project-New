package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson

class inputModule : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_module)

        //allows textViews to scroll vertically
        val chapterScrollable: TextView = findViewById(R.id.chapterTextView)
        val artefactScrollable: TextView = findViewById(R.id.artefactTextView)
        chapterScrollable.movementMethod = ScrollingMovementMethod()
        artefactScrollable.movementMethod = ScrollingMovementMethod()
    }

    //store list of chapters from each user input
    var chapterList = arrayListOf<String>()

    //gets input from chapterUserInput and outputs it in chapterTextView.
    // Each input will be added in the array of chapterlist
    fun addToChapter(view: View) {

        //variables holding chapterUserInput and chapterTextView
        val chapterUserInput = findViewById<EditText>(R.id.chapterUserInput)
        val chapterTextView = findViewById<TextView>(R.id.chapterTextView)

        //converts user input to a string
        val userInput1 = chapterUserInput.text.toString()


        //adds the string into the Textview
        chapterTextView.append(userInput1)
        chapterTextView.append("\n")

        //string will be added to array
        chapterList.add(userInput1)

        //removes string from array if string is empty
        if (userInput1 == "") {

            chapterList.remove(userInput1)
        }
    }

    // same process as addToChapter function
    fun addToArtefact(view: View) {

        val moduleUserInput = findViewById<EditText>(R.id.artefactUserInput)
        val moduleTextView = findViewById<TextView>(R.id.artefactTextView)

        val userInput2 = moduleUserInput.text.toString()

        moduleTextView.append(userInput2)
        moduleTextView.append("\n")

        chapterList.add(userInput2)


        if (userInput2 == "") {

            chapterList.remove(userInput2)
        }
    }


    //moves to trackermodule and pass on chapterlist to that activity
    fun continueToTracker(view: View) {

        //converts array of user input into a json and store in sharedPreference
        val myPrefs = getSharedPreferences("storeArray", Context.MODE_PRIVATE)
        val edit = myPrefs.edit()
        val gson = Gson()
        val json = gson.toJson(chapterList)

        edit.putString("chapterList", json)
        edit.commit()


        //a boolean variable will be stored and pass to CreateNewTracker.kt to disable
        //selectTracker1 button
        val buttonStatePref = getSharedPreferences("buttonState", Context.MODE_PRIVATE)
        val buttonStateEdit = buttonStatePref.edit()


        buttonStateEdit.putBoolean("booleanVar", false)

        buttonStateEdit.apply()


        val intent = Intent(this, MainActivity::class.java)

        startActivity(intent)

    }


}