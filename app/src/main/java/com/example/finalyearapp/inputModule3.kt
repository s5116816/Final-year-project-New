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

class inputModule3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_module3)

        //allows textViews to scroll vertically
        val chapterScrollable: TextView = findViewById(R.id.chapterTextView3)
        val artifactScrollable: TextView = findViewById(R.id.artefactTextView3)
        chapterScrollable.movementMethod = ScrollingMovementMethod()
        artifactScrollable.movementMethod = ScrollingMovementMethod()

    }

    //store list of tasks from each user input
    var taskList = arrayListOf<String>()


    //gets input from chapterUserInput and outputs it in chapterTextView.
    // Each input will be added in the array of taskList
    fun addToChapter(view: View) {

        //variables holding chapterUserInput and chapterTextView
        val chapterUserInput = findViewById<EditText>(R.id.chapterUserInput3)
        val chapterTextView = findViewById<TextView>(R.id.chapterTextView3)

        //converts user input to a string
        val userInput1 = chapterUserInput.text.toString()


        //toast message if converted string is empty
        if (userInput1 == "") {

            Toast.makeText(applicationContext, "enter your chapter name", Toast.LENGTH_SHORT)
                .show()

        } else {

            //adds the string into the Textview
            chapterTextView.append(userInput1)
            chapterTextView.append("\n")

            //string will be added to array
            taskList.add(userInput1)

        }


    }


    // same process as addToChapter function
    fun addToArtifact(view: View) {

        val artifactUserInput = findViewById<EditText>(R.id.artifactUserInput3)
        val artifactTextView = findViewById<TextView>(R.id.artefactTextView3)

        val userInput2 = artifactUserInput.text.toString()

        if (userInput2 == "") {

            Toast.makeText(applicationContext, "enter your task", Toast.LENGTH_SHORT)
                .show()

        } else {

            artifactTextView.append(userInput2)
            artifactTextView.append("\n")

            taskList.add(userInput2)
        }

    }


    //saves all of the entered details to make the tracker
    fun saveData(view: View) {

        //check if taskList array size is less than 25
        if (taskList.size > 25) {

            Toast.makeText(applicationContext, "limit reached! go back and try again", Toast.LENGTH_SHORT).show()
        } else {

            //variables for name and project name
            val firstName = findViewById<EditText>(R.id.firstName3)
            val projectName = findViewById<EditText>(R.id.projectName3)

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

                //storing the user name and project name into "names" sharedpreferences
                val namesPref = getSharedPreferences("names", Context.MODE_PRIVATE)
                val namesEdit = namesPref.edit()

                namesEdit.putString("userName3", stringName)
                namesEdit.putString("projectName3", stringPName)

                namesEdit.apply()


                //checks if taskList is empty or not
                if (taskList.isEmpty()) {

                    Toast.makeText(
                        applicationContext,
                        "please provide information for report or artifact",
                        Toast.LENGTH_LONG
                    ).show()


                } else if (taskList.isNotEmpty()) {


                    //converts taskList into a json and store in "storeArray" sharedPreference
                    val arrayPrefs = getSharedPreferences("storeArray", Context.MODE_PRIVATE)
                    val jsonEdit = arrayPrefs.edit()
                    val gson = Gson()
                    val json = gson.toJson(taskList)

                    //storing the array here
                    jsonEdit.putString("taskList3", json)
                    jsonEdit.apply()


                    //a boolean variable will be stored and pass to CreateNewTracker.kt to disable
                    //selectTracker1 button
                    val createTrackerPref = getSharedPreferences("createTrackerButtons", Context.MODE_PRIVATE)
                    val createTrackerEdit = createTrackerPref.edit()

                    //storing boolean
                    createTrackerEdit.putBoolean("createTrackerButton3", false)
                    createTrackerEdit.apply()


                    //Storing a true boolean in unlockTracker pref
                    //which will be used to allow trackerButton1 in mainMenu module to be clickable
                    val unlockTrackerPref =
                        getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)
                    val unlockTrackerEdit = unlockTrackerPref.edit()

                    unlockTrackerEdit.putBoolean("tracker3", true)
                    unlockTrackerEdit.apply()


                    Toast.makeText(applicationContext, "Tracker has been made", Toast.LENGTH_SHORT)
                        .show()


                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }
}