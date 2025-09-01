package com.example.calcmate_new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HealthCalcActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_health_calculator)




        val btnBodyFat = findViewById<ImageButton>(R.id.btnBodyFat)
        val btnHeartRate = findViewById<ImageButton>(R.id.btnHeartRate)


        findViewById<ImageButton>(R.id.btnBmiCalc).setOnClickListener {
            startActivity(Intent(this, BmiCalculatorActivity::class.java))
        }

        findViewById<ImageButton>(R.id.btnBmrCalc).setOnClickListener {
            startActivity(Intent(this, BmrCalculatorActivity::class.java))
        }

        findViewById<ImageButton>(R.id.btnIdealWeight).setOnClickListener {
            startActivity(Intent(this, IdealWeightActivity::class.java))
        }

        findViewById<ImageButton>(R.id.btnCalorieIntake).setOnClickListener {
            startActivity(Intent(this, CalorieTrackerActivity::class.java))
        }

        btnBodyFat.setOnClickListener {
            Toast.makeText(this, "Body Fat Button clicked", Toast.LENGTH_SHORT).show()

            // val intent = Intent(this, BodyFatCalculatorActivity::class.class)
            // startActivity(intent)
        }

        btnHeartRate.setOnClickListener {
            Toast.makeText(this, "Heart Rate Button clicked", Toast.LENGTH_SHORT).show()

            // val intent = Intent(this, HeartRateCalculatorActivity::class.java)
            // startActivity(intent)
        }
    }
}