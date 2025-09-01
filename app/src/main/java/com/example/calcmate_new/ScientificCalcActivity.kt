//package com.example.calcmate_new
//
//import android.os.Bundle
//import android.view.View
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import kotlin.math.*
//
//class ScientificCalcActivity : AppCompatActivity() {
//
//    // Declare TextViews for display
//    private lateinit var textViewExpression: TextView
//    private lateinit var textViewResult: TextView
//
//    // StringBuilder to build the expression
//    private var expression = StringBuilder()
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_scientific_calc)
//
//        // Initialize TextViews
//        textViewExpression = findViewById(R.id.textViewExpression)
//        textViewResult = findViewById(R.id.textViewResult)
//
//        // Find all number and operator buttons and set click listeners
//        setButtonListeners()
//    }
//
//    // A helper method to find all buttons and set their click listeners
//    private fun setButtonListeners() {
//        // Numbers and decimal point
//        findViewById<Button>(R.id.btn0).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn1).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn2).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn3).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn4).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn5).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn6).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn7).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn8).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btn9).setOnClickListener(numberClickListener)
//        findViewById<Button>(R.id.btnDot).setOnClickListener(numberClickListener)
//
//        // Operators
//        findViewById<Button>(R.id.btnAdd).setOnClickListener(operatorClickListener)
//        findViewById<Button>(R.id.btnSubtract).setOnClickListener(operatorClickListener)
//        findViewById<Button>(R.id.btnMultiply).setOnClickListener(operatorClickListener)
//        findViewById<Button>(R.id.btnDivide).setOnClickListener(operatorClickListener)
//        findViewById<Button>(R.id.btnPower).setOnClickListener(operatorClickListener)
//
//        // Special functions and controls
//        findViewById<Button>(R.id.btnSin).setOnClickListener(functionClickListener)
//        findViewById<Button>(R.id.btnCos).setOnClickListener(functionClickListener)
//        findViewById<Button>(R.id.btnTan).setOnClickListener(functionClickListener)
//        findViewById<Button>(R.id.btnLog).setOnClickListener(functionClickListener)
//        findViewById<Button>(R.id.btnLn).setOnClickListener(functionClickListener)
//        findViewById<Button>(R.id.btnRoot).setOnClickListener(functionClickListener)
//
//        // Constants and brackets
//        findViewById<Button>(R.id.btnPi).setOnClickListener(constantClickListener)
//        findViewById<Button>(R.id.btnE).setOnClickListener(constantClickListener)
//        findViewById<Button>(R.id.btnOpenBracket).setOnClickListener(bracketClickListener)
//        findViewById<Button>(R.id.btnCloseBracket).setOnClickListener(bracketClickListener)
//
//        // Clear, Backspace, and Equals
//        findViewById<Button>(R.id.btnC).setOnClickListener { clearExpression() }
//        findViewById<Button>(R.id.btnBackspace).setOnClickListener { backspace() }
//        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
//    }
//
//    // Listener for number and decimal point buttons
//    private val numberClickListener = View.OnClickListener { view ->
//        val button = view as Button
//        expression.append(button.text)
//        updateExpressionDisplay()
//    }
//
//    // Listener for operator buttons
//    private val operatorClickListener = View.OnClickListener { view ->
//        val button = view as Button
//        // Prevent adding multiple operators in a row
//        if (expression.isNotEmpty() && !isOperator(expression.last())) {
//            expression.append(button.text)
//            updateExpressionDisplay()
//        }
//    }
//
//    // Listener for scientific function buttons (sin, cos, etc.)
//    private val functionClickListener = View.OnClickListener { view ->
//        val button = view as Button
//        val function = button.text.toString()
//        expression.append(function).append("(")
//        updateExpressionDisplay()
//    }
//
//    // Listener for constant buttons (pi, e)
//    private val constantClickListener = View.OnClickListener { view ->
//        val button = view as Button
//        expression.append(button.text)
//        updateExpressionDisplay()
//    }
//
//    // Listener for bracket buttons
//    private val bracketClickListener = View.OnClickListener { view ->
//        val button = view as Button
//        expression.append(button.text)
//        updateExpressionDisplay()
//    }
//
//    // Helper function to check if a character is an operator
//    private fun isOperator(c: Char): Boolean {
//        return c == '+' || c == '-' || c == '*' || c == '/' || c == 'x'
//    }
//
//    // Updates the expression TextView
//    private fun updateExpressionDisplay() {
//        textViewExpression.text = expression.toString()
//    }
//
//    // Clears the expression
//    private fun clearExpression() {
//        expression.clear()
//        textViewExpression.text = ""
//        textViewResult.text = "0"
//    }
//
//    // Deletes the last character from the expression
//    private fun backspace() {
//        if (expression.isNotEmpty()) {
//            expression.deleteCharAt(expression.length - 1)
//            updateExpressionDisplay()
//        }
//    }
//
//    // Evaluates the expression
//    private fun calculateResult() {
//        try {
//            // A simple implementation for evaluation.
//            // For a real calculator, you would need a more robust expression parser.
//            val result = evaluateExpression(expression.toString())
//            textViewResult.text = result.toString()
//        } catch (e: Exception) {
//            textViewResult.text = "Error"
//            Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    // A simple, basic expression evaluator. Note: This does not handle
//    // order of operations (BODMAS/PEMDAS) correctly for complex expressions.
//    private fun evaluateExpression(expr: String): Double {
//        var tempExpr = expr
//            .replace("sin", "sin(").replace("cos", "cos(")
//            .replace("tan", "tan(").replace("log", "log(")
//            .replace("ln", "ln(").replace("√", "sqrt(")
//            .replace("π", "PI").replace("e", "E")
//
//        // A very basic parser, this will need to be replaced with a proper one
//        // for a robust calculator.
//        val operands = tempExpr.split('+', '-', '*', '/')
//        val operators = tempExpr.filter { it in "+-*/" }
//
//        // The fix: use .length for the string variable "operators"
//        if (operands.size != (operators.length + 1)) {
//            throw IllegalArgumentException("Invalid expression format")
//        }
//
//        var result = operands[0].toDouble()
//        for (i in operators.indices) {
//            val nextOperand = operands[i + 1].toDouble()
//            when (operators[i]) {
//                '+' -> result += nextOperand
//                '-' -> result -= nextOperand
//                '*' -> result *= nextOperand
//                '/' -> {
//                    if (nextOperand == 0.0) throw ArithmeticException("Division by zero")
//                    result /= nextOperand
//                }
//            }
//        }
//        return result
//    }
//}



package com.example.calcmate_new

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.*
import java.util.Stack

class ScientificCalcActivity : AppCompatActivity() {

    // Declare TextViews for display
    private lateinit var textViewExpression: TextView
    private lateinit var textViewResult: TextView

    // StringBuilder to build the expression
    private var expression = StringBuilder()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scientific_calc)

        // Initialize TextViews
        textViewExpression = findViewById(R.id.textViewExpression)
        textViewResult = findViewById(R.id.textViewResult)

        // Find all number and operator buttons and set click listeners
        setButtonListeners()
    }

    // A helper method to find all buttons and set their click listeners
    private fun setButtonListeners() {
        // Numbers and decimal point
        findViewById<Button>(R.id.btn0).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn1).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn2).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn3).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn4).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn5).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn6).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn7).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn8).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btn9).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.btnDot).setOnClickListener(numberClickListener)

        // Operators
        findViewById<Button>(R.id.btnAdd).setOnClickListener(operatorClickListener)
        findViewById<Button>(R.id.btnSubtract).setOnClickListener(operatorClickListener)
        findViewById<Button>(R.id.btnMultiply).setOnClickListener(operatorClickListener)
        findViewById<Button>(R.id.btnDivide).setOnClickListener(operatorClickListener)
        findViewById<Button>(R.id.btnPower).setOnClickListener(operatorClickListener)

        // Special functions and controls
        findViewById<Button>(R.id.btnSin).setOnClickListener(functionClickListener)
        findViewById<Button>(R.id.btnCos).setOnClickListener(functionClickListener)
        findViewById<Button>(R.id.btnTan).setOnClickListener(functionClickListener)
        findViewById<Button>(R.id.btnLog).setOnClickListener(functionClickListener)
        findViewById<Button>(R.id.btnLn).setOnClickListener(functionClickListener)
        findViewById<Button>(R.id.btnRoot).setOnClickListener(functionClickListener)

        // Constants and brackets
        findViewById<Button>(R.id.btnPi).setOnClickListener(constantClickListener)
        findViewById<Button>(R.id.btnE).setOnClickListener(constantClickListener)
        findViewById<Button>(R.id.btnOpenBracket).setOnClickListener(bracketClickListener)
        findViewById<Button>(R.id.btnCloseBracket).setOnClickListener(bracketClickListener)

        // Clear, Backspace, and Equals
        findViewById<Button>(R.id.btnC).setOnClickListener { clearExpression() }
        findViewById<Button>(R.id.btnBackspace).setOnClickListener { backspace() }
        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }
    }

    // Listener for number and decimal point buttons
    private val numberClickListener = View.OnClickListener { view ->
        val button = view as Button
        expression.append(button.text)
        updateExpressionDisplay()
    }

    // Listener for operator buttons
    private val operatorClickListener = View.OnClickListener { view ->
        val button = view as Button
        // Prevent adding multiple operators in a row
        if (expression.isNotEmpty() && !isOperator(expression.last())) {
            expression.append(button.text)
            updateExpressionDisplay()
        }
    }

    // Listener for scientific function buttons (sin, cos, etc.)
    private val functionClickListener = View.OnClickListener { view ->
        val button = view as Button
        val function = button.text.toString()
        expression.append(function).append("(")
        updateExpressionDisplay()
    }

    // Listener for constant buttons (pi, e)
    private val constantClickListener = View.OnClickListener { view ->
        val button = view as Button
        expression.append(button.text)
        updateExpressionDisplay()
    }

    // Listener for bracket buttons
    private val bracketClickListener = View.OnClickListener { view ->
        val button = view as Button
        expression.append(button.text)
        updateExpressionDisplay()
    }

    // Helper function to check if a character is an operator
    private fun isOperator(c: Char): Boolean {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || c == 'x'
    }

    // Updates the expression TextView
    private fun updateExpressionDisplay() {
        textViewExpression.text = expression.toString()
    }

    // Clears the expression
    private fun clearExpression() {
        expression.clear()
        textViewExpression.text = ""
        textViewResult.text = "0"
    }

    // Deletes the last character from the expression
    private fun backspace() {
        if (expression.isNotEmpty()) {
            expression.deleteCharAt(expression.length - 1)
            updateExpressionDisplay()
        }
    }

    // Evaluates the expression
    private fun calculateResult() {
        try {
            val result = evaluateExpression(expression.toString())
            textViewResult.text = result.toString()
        } catch (e: Exception) {
            textViewResult.text = "Error"
            Toast.makeText(this, "Invalid Expression", Toast.LENGTH_SHORT).show()
        }
    }

    // New, robust function to evaluate the expression using a two-stack algorithm
    private fun evaluateExpression(expr: String): Double {
        // Pre-process the expression to handle functions and constants
        var expressionToEvaluate = expr
            .replace("π", PI.toString())
            .replace("e", E.toString())
            .replace("sin(", "s(")
            .replace("cos(", "c(")
            .replace("tan(", "t(")
            .replace("log(", "l(")
            .replace("ln(", "n(")
            .replace("√(", "r(")
            .replace("x", "*") // Handle the 'x' for multiplication

        val values = Stack<Double>()
        val ops = Stack<Char>()

        var i = 0
        while (i < expressionToEvaluate.length) {
            when (expressionToEvaluate[i]) {
                in '0'..'9', '.' -> {
                    val buffer = StringBuilder()
                    while (i < expressionToEvaluate.length && (expressionToEvaluate[i].isDigit() || expressionToEvaluate[i] == '.')) {
                        buffer.append(expressionToEvaluate[i++])
                    }
                    values.push(buffer.toString().toDouble())
                    i--
                }
                '(' -> ops.push(expressionToEvaluate[i])
                ')' -> {
                    while (ops.isNotEmpty() && ops.peek() != '(') {
                        applyOp(ops.pop(), values)
                    }
                    if (ops.isNotEmpty()) ops.pop()
                    if (ops.isNotEmpty() && "sctl nr".contains(ops.peek())) {
                        val op = ops.pop()
                        val value = values.pop()
                        when (op) {
                            's' -> values.push(sin(value))
                            'c' -> values.push(cos(value))
                            't' -> values.push(tan(value))
                            'l' -> values.push(log10(value))
                            'n' -> values.push(ln(value))
                            'r' -> values.push(sqrt(value))
                        }
                    }
                }
                in "+-*/^" -> {
                    while (ops.isNotEmpty() && hasPrecedence(expressionToEvaluate[i], ops.peek())) {
                        applyOp(ops.pop(), values)
                    }
                    ops.push(expressionToEvaluate[i])
                }
            }
            i++
        }

        while (ops.isNotEmpty()) {
            applyOp(ops.pop(), values)
        }

        return values.pop()
    }

    // Helper function to check operator precedence
    private fun hasPrecedence(op1: Char, op2: Char): Boolean {
        if (op2 == '(' || op2 == ')') return false
        if ((op1 == '*' || op1 == '/' || op1 == '^') && (op2 == '+' || op2 == '-')) return false
        if ((op1 == '^') && (op2 == '*' || op2 == '/')) return false
        return true
    }

    // Helper function to apply an operator to the values stack
    private fun applyOp(op: Char, values: Stack<Double>) {
        val val2 = values.pop()
        val val1 = values.pop()
        when (op) {
            '+' -> values.push(val1 + val2)
            '-' -> values.push(val1 - val2)
            '*' -> values.push(val1 * val2)
            '/' -> {
                if (val2 == 0.0) throw ArithmeticException("Division by zero")
                values.push(val1 / val2)
            }
            '^' -> values.push(val1.pow(val2))
        }
    }
}

