package com.example.school

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_SCHOOL)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        val signUpText=findViewById<TextView>(R.id.sign_up_text)
        val loginButton=findViewById<Button>(R.id.login_btn)
        val email =findViewById<TextInputEditText>(R.id.email)
        val password =findViewById<TextInputEditText>(R.id.password)
        val loading = findViewById<LinearLayout>( R.id.loading_box)
        val mainContainer = findViewById<LinearLayout>( R.id.main_layout )

        signUpText.setOnClickListener {
            val i = Intent(this,Register::class.java)
            startActivity(i)
        }
        loginButton.setOnClickListener {
            loading.visibility = View.VISIBLE
            mainContainer.visibility = View.GONE
            val emailString = email.text.toString()
            val passwordString = password.text.toString()
            if (emailString.isEmpty() || passwordString.isEmpty()) {
                loading.visibility = View.GONE
                mainContainer.visibility = View.VISIBLE
                Toast.makeText(this, "fill in both fields", Toast.LENGTH_LONG).show()
            }else{
                auth.signInWithEmailAndPassword(emailString, passwordString).addOnCompleteListener(this){task ->
                    if (task.isSuccessful) {
                        loading.visibility = View.GONE
                        val i = Intent(this,MainActivity::class.java)
                        startActivity(i)
                    } else {
                        loading.visibility = View.GONE
                        mainContainer.visibility = View.VISIBLE
                        Toast.makeText(this, task.exception?.message, Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }
    }


}