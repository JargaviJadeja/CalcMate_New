package com.example.calcmate_new

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FinancialToolsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_financial_tools)

        // Find each ImageButton by its ID from the XML layout
        val btnLoanCalculator = findViewById<ImageButton>(R.id.btnLoanCalculator)
        val btnCompoundInterestCalculator = findViewById<ImageButton>(R.id.btnCompoundInterestCalculator)
        val btnSimpleInterestCalculator = findViewById<ImageButton>(R.id.btnSimpleInterestCalculator)
        val btnTipCalculator = findViewById<ImageButton>(R.id.btnTipCalculator)

        // Set up click listeners for each button.
        btnLoanCalculator.setOnClickListener {
            val intent = Intent(this, LoanCalculatorActivity::class.java)
            startActivity(intent)

        }

        btnCompoundInterestCalculator.setOnClickListener {
            val intent = Intent(this, CompoundInterestCalculatorActivity::class.java)
            startActivity(intent)

        }

        btnSimpleInterestCalculator.setOnClickListener {
              val intent = Intent(this, SimpleInterestCalculatorActivity::class.java)
              startActivity(intent)

        }

        btnTipCalculator.setOnClickListener {
              val intent = Intent(this, TipCalculatorActivity::class.java)
              startActivity(intent)

        }
    }
}
