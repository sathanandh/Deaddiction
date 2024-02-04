package com.example.empower
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.empower.R

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Find the buttons by their IDs
        val button1 = findViewById<Button>(R.id.button1)
        val button2 = findViewById<Button>(R.id.button2)
        val button3 = findViewById<Button>(R.id.button3)
        val button4 = findViewById<Button>(R.id.button4)

        // Set click listeners for each button
        button1.setOnClickListener {
            // Handle button 1 click here
            // Example:
            // Toast.makeText(this, "Button 1 clicked!", Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            // Handle button 2 click here
        }

        button3.setOnClickListener {
            // Handle button 3 click here
        }

        button4.setOnClickListener {
            // Handle button 4 click here
        }
    }
}
