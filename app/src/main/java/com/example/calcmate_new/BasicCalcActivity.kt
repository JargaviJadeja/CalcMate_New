package com.example.calcmate_new

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BasicCalcActivity : AppCompatActivity() {

    private lateinit var tvInput: TextView
    private var input: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_calc)

        tvInput = findViewById(R.id.tvInput)

        // Number buttons (0-9, 00)
        val btnIds = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
            R.id.btnZeroZero
        )

        for (id in btnIds) {
            findViewById<Button>(id).setOnClickListener {
                input += (it as Button).text
                tvInput.text = input
            }
        }

        // Operator buttons (+, -, *, /, .)
        val operators = listOf(R.id.btnPlus, R.id.btnMinus, R.id.btnMultiply, R.id.btnDivide, R.id.btnDot)
        for (id in operators) {
            findViewById<Button>(id).setOnClickListener {
                // Avoid duplicate operators
                if (input.isNotEmpty() && !"+-*/.".contains(input.last())) {
                    input += (it as Button).text
                    tvInput.text = input
                }
            }
        }

        // Clear (C) button
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            input = ""
            tvInput.text = "0"
        }

        // Percentage (%) button
        findViewById<Button>(R.id.btnPercent).setOnClickListener {
            if (input.isNotEmpty() && !"+-*/.".contains(input.last())) {
                try {
                    val value = eval(input).toString().toDouble()
                    val result = value / 100
                    tvInput.text = result.toString()
                    input = result.toString()
                } catch (e: Exception) {
                    tvInput.text = "Error"
                    input = ""
                }
            }
        }

        // Delete (DEL) button
        findViewById<Button>(R.id.btnDel).setOnClickListener {
            if (input.isNotEmpty()) {
                input = input.substring(0, input.length - 1)
                if (input.isEmpty()) {
                    tvInput.text = "0"
                } else {
                    tvInput.text = input
                }
            }
        }

        // Equals button
        findViewById<Button>(R.id.btnEqual).setOnClickListener {
            try {
                val result = eval(input)
                tvInput.text = result.toString()
                input = result.toString()
            } catch (e: Exception) {
                tvInput.text = "Error"
                input = ""
            }
        }
    }

    // Simple expression evaluator
    private fun eval(expression: String): Double {
        return object : Any() {
            var pos = -1
            var ch = 0

            fun nextChar() {
                ch = if (++pos < expression.length) expression[pos].code else -1
            }

            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.code) nextChar()
                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }

            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < expression.length) throw RuntimeException("Unexpected: " + expression[pos])
                return x
            }

            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    when {
                        eat('+'.code) -> x += parseTerm()
                        eat('-'.code) -> x -= parseTerm()
                        else -> return x
                    }
                }
            }

            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    when {
                        // Change this line: `*`.code to `×`.code
                        eat('×'.code) -> x *= parseFactor()
                        // This line was changed to correctly parse the division symbol '÷'
                        eat('÷'.code) -> x /= parseFactor()
                        else -> return x
                    }
                }
            }

            fun parseFactor(): Double {
                if (eat('+'.code)) return parseFactor()
                if (eat('-'.code)) return -parseFactor()

                var x: Double
                val startPos = pos
                if (eat('('.code)) {
                    x = parseExpression()
                    eat(')'.code)
                } else if ((ch >= '0'.code && ch <= '9'.code) || ch == '.'.code) {
                    while ((ch >= '0'.code && ch <= '9'.code) || ch == '.'.code) nextChar()
                    x = expression.substring(startPos, pos).toDouble()
                } else {
                    throw RuntimeException("Unexpected: " + ch.toChar())
                }
                return x
            }
        }.parse()
    }
}
