package com.example.login
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val emailEditText = findViewById<EditText>(R.id.editTextEmail)
        val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
        val validateButton = findViewById<Button>(R.id.buttonValidate)

        validateButton.setOnClickListener {

            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()


            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Fields cannot be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }


            val emailPattern = Regex("^[A-Za-z0-9._%+-]+@college\\.edu$")
            if (!email.matches(emailPattern)) {
                Toast.makeText(this, "Enter valid college email (example@college.edu)", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }


            val passwordPattern = Regex("^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#\$%^&+=!]).{12,}$")

            if (!password.matches(passwordPattern)) {
                Toast.makeText(
                    this,
                    "Password must be 12+ chars, include 1 uppercase, 1 number & 1 special symbol",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful ✅", Toast.LENGTH_LONG).show()
        }
    }
}