package com.example.calcmate_new

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.calcmate_new.R

// Add the import statements for the new activities here
import com.example.calcmate_new.HistoryActivity
import com.example.calcmate_new.SettingsActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)   // <-- res/layout/activity_dashboard.xml

        // Make sure these IDs exist in activity_dashboard.xml
        findViewById<ImageButton>(R.id.btnBasicCalc).setOnClickListener {
            startActivity(Intent(this, BasicCalcActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnScientificCalc).setOnClickListener {
            startActivity(Intent(this, ScientificCalcActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnUnitConverter).setOnClickListener {
            startActivity(Intent(this, UnitConverterActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnFinancialTools).setOnClickListener {
            startActivity(Intent(this, FinancialToolsActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnHealthCalc).setOnClickListener {
            startActivity(Intent(this, HealthCalcActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnDateTimeTools).setOnClickListener {
            startActivity(Intent(this, DateTimeToolsActivity::class.java))
        }
        findViewById<ImageButton>(R.id.btnProgrammerCalc).setOnClickListener {
            startActivity(Intent(this, ProgrammerCalcActivity::class.java))
        }

        // Add the footer logic
        setupFooter()
    }

    private fun setupFooter() {
        val btnHome: ImageButton = findViewById(R.id.btnHome)
        val btnHistory: ImageButton = findViewById(R.id.btnHistory)
        val btnSettings: ImageButton = findViewById(R.id.btnSettings)

        // Set up the listeners for the footer buttons
        btnHome.setOnClickListener {
            // Since this is the Home page, we don't start a new activity.
            updateFooterIcons("home")
        }

        btnHistory.setOnClickListener {
            // Update the icons and then navigate to the History screen
            updateFooterIcons("history")
            val intent = Intent(this@DashboardActivity, HistoryActivity::class.java)
            startActivity(intent)
        }

        btnSettings.setOnClickListener {
            // Update the icons and then navigate to the Settings screen
            updateFooterIcons("settings")
            val intent = Intent(this@DashboardActivity, SettingsActivity::class.java)
            startActivity(intent)
        }

        // Set initial state of footer icons (Home is selected)
        updateFooterIcons("home")
    }

    // A helper method to handle the icon color changes
    private fun updateFooterIcons(activeTab: String) {
        val btnHome: ImageButton = findViewById(R.id.btnHome)
        val btnHistory: ImageButton = findViewById(R.id.btnHistory)
        val btnSettings: ImageButton = findViewById(R.id.btnSettings)

        // Get the colors from resources
        val selectedColor = resources.getColor(R.color.tab_selected_color, theme)
        val unselectedColor = resources.getColor(R.color.tab_icon_color, theme)

        // Reset all buttons to the unselected color
        btnHome.setColorFilter(unselectedColor)
        btnHistory.setColorFilter(unselectedColor)
        btnSettings.setColorFilter(unselectedColor)

        // Set the active button to the selected color
        when (activeTab) {
            "home" -> btnHome.setColorFilter(selectedColor)
            "history" -> btnHistory.setColorFilter(selectedColor)
            "settings" -> btnSettings.setColorFilter(selectedColor)
        }
    }
}
