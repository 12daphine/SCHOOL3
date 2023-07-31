package com.example.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Register : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SCHOOL)
        setContentView(R.layout.activity_register)

        auth= FirebaseAuth.getInstance()

        val loginText = findViewById<TextView>(R.id.log_text)
        val registerButton = findViewById<Button>(R.id.register_btn)
        val email = findViewById<TextInputEditText>(R.id.email)
        val password = findViewById<TextInputEditText>(R.id.password)


        loginText.setOnClickListener {
            val i = Intent(this, Login::class.java)
            startActivity(i)
        }
        registerButton.setOnClickListener {
            val emailString = email.text.toString()
            val passwordString = password.text.toString()
            if (emailString.isEmpty() || passwordString.isEmpty()) {
                Toast.makeText(this, "fill in both fields", Toast.LENGTH_LONG).show()
            }else{
                auth.createUserWithEmailAndPassword( emailString, passwordString).addOnCompleteListener(this){task ->
                    if (task.isSuccessful) {
                        val i = Intent(this,MainActivity::class.java)
                        startActivity(i)
                    } else {
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }

}
