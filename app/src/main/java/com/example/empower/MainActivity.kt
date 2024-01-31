package com.example.empower

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve text fields
        val etFullName = findViewById<TextInputEditText>(R.id.etFullName)
        val etRegNumber = findViewById<TextInputEditText>(R.id.etRegNumber)
        val etCenterDetails = findViewById<TextInputEditText>(R.id.etCenterDetails)

        val textInputs = arrayOf(etFullName, etRegNumber, etCenterDetails)

        // Set up Enter key navigation
        val onKeyListener = View.OnKeyListener { v, keyCode, event ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                val currentViewIndex = textInputs.indexOf(v)
                if (currentViewIndex != -1 && currentViewIndex < textInputs.size - 1) {
                    textInputs[currentViewIndex + 1].requestFocus()
                    return@OnKeyListener true
                } else {
                    // Last text box: take input and close keyboard
                    val lastInput = (v as TextInputEditText).text.toString()
                    // Process last input (e.g., save to database)
                    closeKeyboard()
                    return@OnKeyListener true // Prevent newline
                }
            }
            false
        }
        textInputs.forEach { it.setOnKeyListener(onKeyListener) }

        // Register button click handler
        val btnRegister = findViewById<Button>(R.id.btnRegister)  // Use Button
        btnRegister.setOnClickListener {
            // Retrieve registration data
            val fullName = etFullName.text.toString()
            val regNumber = etRegNumber.text.toString()
            val centerDetails = etCenterDetails.text.toString()

            // Perform registration logic (e.g., save to database)
            // ... (your registration logic here)

            // Move to activity_main2 after registration
            startActivity(Intent(this, MainActivity2::class.java))  // Start the second activity
        }
    }

    private fun closeKeyboard() {
        val view = this.currentFocus ?: return
        val imm = getSystemService(InputMethodManager::class.java)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
