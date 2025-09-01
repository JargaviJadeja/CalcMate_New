package com.example.calcmate_new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class DateTimeToolsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_date_time_tools)

        // Initialize ImageButtons
        val btnDateDifference = findViewById<ImageButton>(R.id.btnDateDifference)
        val btnTimeZoneConverter = findViewById<ImageButton>(R.id.btnTimeZoneConverter)
        val btnTimestampConverter = findViewById<ImageButton>(R.id.btnTimestampConverter)

        // Set click listeners for each button
        btnDateDifference.setOnClickListener {
            // This toast will be replaced with an intent to a new activity
            //Toast.makeText(this, "Date Difference clicked!", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DateDifferenceActivity::class.java)
            startActivity(intent)

        }

        btnTimeZoneConverter.setOnClickListener {
            // This toast will be replaced with an intent to a new activity
            Toast.makeText(this, "Time Zone Converter clicked!", Toast.LENGTH_SHORT).show()
        }

        btnTimestampConverter.setOnClickListener {
            // This toast will be replaced with an intent to a new activity
            Toast.makeText(this, "Timestamp Converter clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}
