package com.example.finalyearapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.TextView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class trackerModule5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_module5)

        //my XML variables from this module's view
        val scrollableList: LinearLayout = findViewById(R.id.trackerList5)
        val deleteTracker = findViewById<Button>(R.id.deleteButton5)
        val circleProgressBar = findViewById<ProgressBar>(R.id.circleProgressBar5)
        val projectTitle = findViewById<TextView>(R.id.projectTitle5)
        val userName = findViewById<TextView>(R.id.userName5)


        //buttonValue store current amount of generated buttons
        //circleprogr value increase or degrease depending on clicks from generated buttons
        var buttonValue = 0
        var circleProgr = 0.0


        //variables holding sharedPreferences and Gson
        val arrayPref = applicationContext.getSharedPreferences("storeArray", Context.MODE_PRIVATE)
        val gson = Gson()

        //get json from sharedPreference
        val getJson = arrayPref.getString("taskList5", null)

        //convert json taskList back to a string array
        val type = object : TypeToken<ArrayList<String>>() {}.type
        val taskList = gson.fromJson<ArrayList<String>>(getJson, type)



        // variable holding "names" sharedPreferences
        val namesPref = applicationContext.getSharedPreferences("names", Context.MODE_PRIVATE)

        //getting the user's name and project title
        val getUserName = namesPref.getString("userName5", "")
        val getProjectName = namesPref.getString("projectName5", "")

        //output in these textViews
        projectTitle.text = getProjectName
        userName.text = getUserName


        //deletes the tracker when clicking the delete button
        deleteTracker.setOnClickListener() {

            //emptying user input from array and store it in sharedPreferences
            taskList.clear()


            val deletePrefArray = getSharedPreferences("storeArray", Context.MODE_PRIVATE)
            val editArray = deletePrefArray.edit()
            val emptyArray = gson.toJson(taskList)

            editArray.putString("taskList5", emptyArray)
            editArray.apply()


            //delete current names in "names" preferences
            val deletePrefNames = getSharedPreferences("names", Context.MODE_PRIVATE)
            val editNames = deletePrefNames.edit()

            editNames.putString("userName5", "")
            editNames.putString("projectName5", "")
            editNames.apply()


            //code to re-enable access to createTracker1 button in CreateNewTracker.kt
            val createtrackerPref = getSharedPreferences("createTrackerButtons", Context.MODE_PRIVATE)
            val createTrackereEdit = createtrackerPref.edit()

            createTrackereEdit.putBoolean("createTrackerButton5", true)

            createTrackereEdit.apply()


            //code to disable the button that can access this module after tracker deletion
            val unlockTrackerPref = getSharedPreferences("unlockTracker", Context.MODE_PRIVATE)
            val unlockTrackerEdit = unlockTrackerPref.edit()

            unlockTrackerEdit.putBoolean("tracker5", false)

            unlockTrackerEdit.apply()


            //return to main menu
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


        //update the progress bar in XML file based on button clicks
        fun progressBarUpdate() {

            //my variables for progress bar and textview
            val textViewProgressPercentage =
                findViewById<TextView>(R.id.textView_progressPercentage5)


            //outputs the progress in the progress bar
            // textView outputs the current progress level, outputs a string between 0 and 100
            circleProgressBar.progress = circleProgr.toInt()
            textViewProgressPercentage.text = circleProgressBar.progress.toString()
        }


        //loops through the taskList array to generate buttons dynamically,
        //add them in the linearLayout
        // and providing setOnclicklistners for each generated button
        for (i in taskList) {

            // button created here
            val button = Button(this)
            button.layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)

            // add text to button and size
            button.text = i
            button.textSize = 15f

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
                        11 -> {
                            circleProgr += 9.1
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        12 -> {
                            circleProgr += 8.4
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        13 -> {
                            circleProgr += 7.7
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        14 -> {
                            circleProgr += 7.2
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()


                        }
                        15 -> {
                            circleProgr += 6.7
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()


                        }
                        16 -> {
                            circleProgr += 6.25
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()


                        }
                        17 -> {
                            circleProgr += 5.9
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        18 -> {
                            circleProgr += 5.6
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        19 -> {
                            circleProgr += 5.3
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        20 -> {
                            circleProgr += 5
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()


                        }
                        21 -> {
                            circleProgr += 4.8
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        22 -> {
                            circleProgr += 4.55
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        23 -> {
                            circleProgr += 4.35
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        24 -> {
                            circleProgr += 4.2
                            button.setBackgroundColor(Color.GREEN)
                            isGreen = true
                            progressBarUpdate()

                        }
                        25 -> {
                            circleProgr += 4
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
                        11 -> {
                            circleProgr -= 9.1
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        12 -> {
                            circleProgr -= 8.4
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        13 -> {
                            circleProgr -= 7.7
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        14 -> {
                            circleProgr -= 7.2
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        15 -> {
                            circleProgr -= 6.7
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        16 -> {
                            circleProgr -= 6.25
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        17 -> {
                            circleProgr -= 5.9
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        18 -> {
                            circleProgr -= 5.6
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        19 -> {
                            circleProgr -= 5.3
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        20 -> {
                            circleProgr -= 5
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        21 -> {
                            circleProgr -= 4.8
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        22 -> {
                            circleProgr -= 4.55
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        23 -> {
                            circleProgr -= 4.35
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        24 -> {
                            circleProgr -= 4.2
                            button.setBackgroundColor(Color.WHITE)
                            isGreen = false
                            progressBarUpdate()


                        }
                        25 -> {
                            circleProgr -= 4
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
