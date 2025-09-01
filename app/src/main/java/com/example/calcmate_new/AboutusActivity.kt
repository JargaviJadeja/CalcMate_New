package com.example.calcmate_new

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // This links the Kotlin file to the new XML layout file.
        // You'll need to create this file in your res/layout directory.
        setContentView(R.layout.activity_about)

        // Set up the back button in the toolbar if you're using one.
        // This code assumes you have a toolbar set up in your layout.
        // If not, you can remove this part.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "About Us"
    }

    override fun onSupportNavigateUp(): Boolean {
        // This handles the back button in the toolbar.
        onBackPressedDispatcher.onBackPressed()
        return true
    }
}