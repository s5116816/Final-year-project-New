package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
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


    //saves all of the entered details to make the tracker
    fun saveData(view: View) {

        //variables for name and project name
        val firstName = findViewById<EditText>(R.id.firstName)
        val projectName = findViewById<EditText>(R.id.projectName)

        //convert to string
        val stringName = firstName.text.toString()
        val stringPName = projectName.text.toString()

        //checks if string variables are empty or not
        if (stringName.isEmpty() && stringPName.isEmpty() || stringName.isEmpty() || stringPName.isEmpty()) {

            Toast.makeText(
                applicationContext,
                "please type in your name and project title",
                Toast.LENGTH_LONG
            ).show()
        } else {

            //storing the user name and project name into "name" sharedpreferences
            val mypref = getSharedPreferences("names", Context.MODE_PRIVATE)
            val edit = mypref.edit()

            edit.putString("userName", stringName)
            edit.putString("projectName", stringPName)

            edit.apply()

            //checks if chapterList is empty or not
            if (chapterList.isEmpty()) {

                Toast.makeText(
                    applicationContext,
                    "please provide information for report or artefact",
                    Toast.LENGTH_LONG
                ).show()

            } else if (chapterList.isNotEmpty()) {

                //converts chapterList into a json and store in "storeArray" sharedPreference
                val myPrefs = getSharedPreferences("storeArray", Context.MODE_PRIVATE)
                val jsonEdit = myPrefs.edit()
                val gson = Gson()
                val json = gson.toJson(chapterList)

                jsonEdit.putString("chapterList", json)
                jsonEdit.apply()


                //a boolean variable will be stored and pass to CreateNewTracker.kt to disable
                //selectTracker1 button
                val buttonStatePref = getSharedPreferences("buttonState", Context.MODE_PRIVATE)
                val buttonStateEdit = buttonStatePref.edit()

                buttonStateEdit.putBoolean("booleanVar", false)
                buttonStateEdit.apply()

                Toast.makeText(applicationContext, "Tracker has been made", Toast.LENGTH_SHORT)
                    .show()


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }
}