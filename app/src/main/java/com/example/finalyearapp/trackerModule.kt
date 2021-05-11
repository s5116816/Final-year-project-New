package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class trackerModule : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_module)


        //my XML variables from this module's view
        val scrollableList: LinearLayout = findViewById(R.id.trackerList)
        val deleteTracker = findViewById<Button>(R.id.deleteButton)
        val circleProgressBar = findViewById<ProgressBar>(R.id.circleProgressBar)
        val projectTitle = findViewById<TextView>(R.id.projectTitle)
        val userName = findViewById<TextView>(R.id.userName)


        //buttonValue store current amount of generated buttons
        //circleprogr value increase or degrease depending on clicks from generated buttons
        var buttonValue = 0
        var circleProgr = 0.0


        //variables holding sharedPreferences and Gson
        val myPref = applicationContext.getSharedPreferences("storeArray", Context.MODE_PRIVATE)
        val gson = Gson()

        //get json from sharedPreference
        val getJson = myPref.getString("chapterList", null)

        //convert json chapterList back to a string array
        val type = object : TypeToken<ArrayList<String>>() {}.type
        val chapterList = gson.fromJson<ArrayList<String>>(getJson, type)


        // variable holding "names" sharedPreferences
        val namesPref = applicationContext.getSharedPreferences("names", Context.MODE_PRIVATE)

        //getting the user's name and project title
        val getUserName = namesPref.getString("userName", "")
        val getProjectName = namesPref.getString("projectName", "")

        //output in these textViews
        projectTitle.text = getProjectName
        userName.text = getUserName


        //deletes the tracker
        deleteTracker.setOnClickListener() {

            //emptying user input from array and store it in sharedPreferences
            chapterList.clear()


            val deletePrefArray = getSharedPreferences("storeArray", Context.MODE_PRIVATE)
            val editArray = deletePrefArray.edit()
            val emptyArray = gson.toJson(chapterList)

            editArray.putString("chapterList", emptyArray)
            editArray.apply()


            val deletePrefNames = getSharedPreferences("names", Context.MODE_PRIVATE)
            val editNames = deletePrefNames.edit()

            editNames.putString("userName", "")
            editNames.putString("projectName", "")
            editNames.apply()


            //code to re-enable access to createTracker1 button in CreateNewTracker.kt
            val buttonStatePref = getSharedPreferences("buttonState", Context.MODE_PRIVATE)
            val buttonStateEdit = buttonStatePref.edit()

            buttonStateEdit.putBoolean("booleanVar", true)

            buttonStateEdit.apply()


            //code to disable the button that can access this module after tracker deletion
            val unlockTrackerPref = getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)
            val unlockTrackerEdit = unlockTrackerPref.edit()

            unlockTrackerEdit.putBoolean("trackerButton1", false)

            unlockTrackerEdit.apply()


            //might delete
            circleProgressBar.progress = 0


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }



        //update the progress bar in XML file based on button clicks
        fun progressBarUpdate() {

            //my variables for progress bar and textview
            val textViewProgressPercentage =
                findViewById<TextView>(R.id.textView_progressPercentage)


            //outputs the progress in the progress bar
            // textView outputs the current progress level, outputs a string between 0 and 100
            circleProgressBar.progress = circleProgr.toInt()
            textViewProgressPercentage.text = circleProgressBar.progress.toString()
        }


        //loops through the chapterList array to generate buttons dynamically,
        //add them in the linearLayout
        // and providing setOnclicklistners for each generated button
        for (i in chapterList) {

            // button created here
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            button.text = i

            //add button to linearLayout and increase button value by 1 increment
            scrollableList.addView(button)
            buttonValue += 1

            // boolean initialized as false as buttons don't have a green color once made
            var isGreen = false


            // gives buttons an onclickListener to be able to increase or degrease progress in
            //progress bar
            button.setOnClickListener {


                // checks if button is not green
                if (!isGreen) {

                    //checks current button value to execute one of these statements
                    when (buttonValue) {

                        // increase circleProgr, change color to green
                        //set isgreen to true and execute progressBarUpdate function
                        1 -> {
                            circleProgr += 100
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                        2 -> {
                            circleProgr += 50
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                        3 -> {
                            circleProgr += 33.4
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        4 -> {
                            circleProgr += 25
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        5 -> {
                            circleProgr += 20
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        6 -> {
                            circleProgr += 16.7
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        7 -> {
                            circleProgr += 14.3
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                        8 -> {
                            circleProgr += 12.5
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                        9 -> {
                            circleProgr += 11.2
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                        10 -> {
                            circleProgr += 10
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()
                        }
                    }


                    // checks if button is green
                } else if (isGreen) {

                    // execute one of the statements based on button value
                    when (buttonValue) {

                        // degrease circleProgr, change color to white
                        //set isgreen to false and execute progressBarUpdate function
                        1 -> {
                            circleProgr -= 100
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()
                        }
                        2 -> {
                            circleProgr -= 50
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()
                        }
                        3 -> {
                            circleProgr -= 33.4
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()
                        }
                        4 -> {
                            circleProgr -= 25
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()
                        }
                        5 -> {
                            circleProgr -= 20
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                        6 -> {
                            circleProgr -= 16.7
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                        7 -> {
                            circleProgr -= 14.3
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                        8 -> {
                            circleProgr -= 12.5
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                        9 -> {
                            circleProgr -= 11.2
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                        10 -> {
                            circleProgr -= 10
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()

                        }
                    }
                }
            }
        }
    }
}