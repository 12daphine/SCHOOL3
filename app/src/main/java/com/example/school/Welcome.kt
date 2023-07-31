package com.example.school


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Welcome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val log: ImageView = findViewById(R.id.log_image)
        val well: TextView = findViewById(R.id.my_school)
        val top_anim: Animation = AnimationUtils.loadAnimation(this, R.anim.top)
        val bottom_anim: Animation = AnimationUtils.loadAnimation(this, R.anim.bottom)
        log.startAnimation(top_anim)
        well.startAnimation(bottom_anim)

        val next = findViewById<TextView>(R.id.next_btn)
        next.setOnClickListener {
            val i = Intent(this, Login::class.java)
            startActivity(i)
        }
    }
}
