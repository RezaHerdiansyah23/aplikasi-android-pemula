package com.example.myfilosifisapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imageView = findViewById<ImageView>(R.id.iv_profile)
        val nameTextView = findViewById<TextView>(R.id.tv_name)
        val emailTextView = findViewById<TextView>(R.id.tv_email)

        imageView.setImageResource(R.drawable.reza_herdiansyah)
        nameTextView.text = "Reza Herdiansyah"
        emailTextView.text = "panttech69@gmail.com"

    }
}