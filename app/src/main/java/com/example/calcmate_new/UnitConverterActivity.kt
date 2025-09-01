package com.example.calcmate_new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class UnitConverterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unit_converter)

        // Find each ImageButton by its ID from the XML layout
        val btnLength = findViewById<ImageButton>(R.id.btnLengthConverter)
        val btnWeight = findViewById<ImageButton>(R.id.btnWeightConverter)
        val btnTemperature = findViewById<ImageButton>(R.id.btnTemperatureConverter)
        val btnVolume = findViewById<ImageButton>(R.id.btnVolumeConverter)
        val btnArea = findViewById<ImageButton>(R.id.btnAreaConverter)
        val btnDataTransferRate = findViewById<ImageButton>(R.id.btnDataTransferRateConverter)

        // Set up click listeners for each button.


        btnLength.setOnClickListener {

            val intent = Intent(this, LengthConverterActivity::class.java)
            startActivity(intent)
        }

        btnWeight.setOnClickListener {

            val intent = Intent(this, WeightConverterActivity::class.java)
            startActivity(intent)
        }

        btnTemperature.setOnClickListener {
            val intent = Intent(this, TemperatureConverterActivity::class.java)
            startActivity(intent)
        }

        btnVolume.setOnClickListener {
            val intent = Intent(this, VolumeConverterActivity::class.java)
            startActivity(intent)
        }

        btnArea.setOnClickListener {
            val intent = Intent(this, AreaConverterActivity::class.java)
            startActivity(intent)
        }

        btnDataTransferRate.setOnClickListener {
            val intent = Intent(this, DataTransferRateConverterActivity::class.java)
            startActivity(intent)
        }
    }
}
