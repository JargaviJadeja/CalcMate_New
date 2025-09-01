package com.example.calcmate_new

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.SwitchCompat

class SettingsActivity : AppCompatActivity() {

    // Define a constant for the SharedPreferences file name
    private val PREFS_NAME = "ThemePrefs"
    private val THEME_KEY = "theme_mode"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        // Find the back arrow button by its ID
        val ivBack: ImageView = findViewById(R.id.ivBack)

        // Set an OnClickListener on the back arrow to finish the current activity
        ivBack.setOnClickListener {
            finish()
        }

        // Get a reference to the theme switch from the layout file
        val themeSwitch: SwitchCompat = findViewById(R.id.switchDarkMode)

        // Load the saved theme preference
        val sharedPrefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val isNightMode = sharedPrefs.getBoolean(THEME_KEY, false) // Default to light mode

        // Set the initial state of the switch based on the saved preference
        themeSwitch.isChecked = isNightMode

        // Set a listener for when the switch state changes
        themeSwitch.setOnCheckedChangeListener { _, isChecked ->
            // Save the new theme preference
            with(sharedPrefs.edit()) {
                putBoolean(THEME_KEY, isChecked)
                apply()
            }
            // Apply the new theme
            applyTheme(isChecked)
        }

        // ---------------------------------------------------------------------
        // ADDED CODE: Handles the click for the "About" section.
        // ---------------------------------------------------------------------

        // Find the "About" TextView (or CardView if you're using that)
        val aboutTextView: TextView = findViewById(R.id.aboutTextView) // **Make sure to use the correct ID from your XML!**

        // Set a click listener to start the AboutusActivity.
        aboutTextView.setOnClickListener {
            val intent = Intent(this, AboutusActivity::class.java)
            startActivity(intent)
        }



    }

    /**
     * Applies the selected theme to the application.
     * @param isNightMode True for dark mode, False for light mode.
     */
    private fun applyTheme(isNightMode: Boolean) {
        if (isNightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }
}