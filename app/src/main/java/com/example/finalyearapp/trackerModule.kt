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

   // private var isGreen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tracker_module)


        //variables holding sharedPreferences and Gson
        val myPref = applicationContext.getSharedPreferences("storeArray", Context.MODE_PRIVATE)
        val gson = Gson()

        //get json from sharedPreference
        val getJson = myPref.getString("chapterList", null)

        //convert json chapterList back to a string array
        val type = object : TypeToken<ArrayList<String>>() {}.type
        val chapterList = gson.fromJson<ArrayList<String>>(getJson, type)


        //holding a linearLayout from this activity's xml in a variable
        val scrollableList: LinearLayout = findViewById(R.id.trackerList)

        //the current amount of buttons being made dynamically are stored here
        var buttonValue = 0

        //used for increasing and decreasing progress, initialized as 0.0
        var circleProgr = 0.0


        //update the progress bar in XML file based on button clicks
        fun progressBarUpdate() {

            //my variables for progress bar and textview
            val circleProgressBar = findViewById<ProgressBar>(R.id.circleProgressBar)
            val textViewProgressPercentage = findViewById<TextView>(R.id.textView_progressPercentage)


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
            button.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
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