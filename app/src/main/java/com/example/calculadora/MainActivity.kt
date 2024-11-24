package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var displayEditText: EditText
    private var lastNumeric = false
    private var stateError = false
    private var lastDot = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayEditText = findViewById(R.id.displayEditText)

        // Configurando listeners para botões numéricos
        setNumericOnClickListener()

        // Configurando listeners para botões de operação
        setOperatorOnClickListener()
    }

    private fun setNumericOnClickListener() {
        val numericButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
            R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        )

        numericButtons.forEach { id ->
            findViewById<Button>(id).setOnClickListener {
                if (stateError) {
                    displayEditText.setText("")
                    stateError = false
                }
                displayEditText.append((it as Button).text)
                lastNumeric = true
            }
        }

        // Botão ponto decimal
        findViewById<Button>(R.id.btnDot).setOnClickListener {
            if (lastNumeric && !stateError && !lastDot) {
                displayEditText.append(".")
                lastNumeric = false
                lastDot = true
            }
        }
    }

    private fun setOperatorOnClickListener() {
        // Operadores básicos
        val operatorButtons = mapOf(
            R.id.btnAdd to "+",
            R.id.btnSubtract to "-",
            R.id.btnMultiply to "*",
            R.id.btnDivide to "/"
        )

        operatorButtons.forEach { (id, operator) ->
            findViewById<Button>(id).setOnClickListener {
                if (lastNumeric && !stateError) {
                    displayEditText.append(operator)
                    lastNumeric = false
                    lastDot = false
                }
            }
        }

        // Botão Clear
        findViewById<Button>(R.id.btnClear).setOnClickListener {
            displayEditText.setText("")
            lastNumeric = false
            stateError = false
            lastDot = false
        }

        // Botão Delete
        findViewById<Button>(R.id.btnDelete).setOnClickListener {
            val text = displayEditText.text.toString()
            if (text.isNotEmpty()) {
                displayEditText.setText(text.substring(0, text.length - 1))
                try {
                    val lastChar = text[text.length - 2]
                    if (lastChar.isDigit()) {
                        lastNumeric = true
                    }
                } catch (e: Exception) {
                    lastNumeric = false
                    stateError = false
                    lastDot = false
                }
            }
        }

        // Botão Igual
        findViewById<Button>(R.id.btnEquals).setOnClickListener {
            if (lastNumeric && !stateError) {
                val text = displayEditText.text.toString()
                try {
                    // Substituindo os operadores visuais pelos operadores matemáticos
                    val expression = text.replace("×", "*").replace("÷", "/")

                    val result = ExpressionBuilder(expression)
                        .build()
                        .evaluate()

                    // Formatando o resultado para retirar decimais desnecessários
                    val displayResult = if (result % 1 == 0.0) {
                        result.toLong().toString()
                    } else {
                        String.format("%.8f", result).trimEnd('0').trimEnd('.')
                    }

                    displayEditText.setText(displayResult)
                    lastDot = displayResult.contains(".")
                } catch (ex: Exception) {
                    displayEditText.setText("Erro")
                    stateError = true
                    lastNumeric = false
                }
            }
        }
    }
}