package com.example.myfilosifisapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Menerima data Filsuf yang dikirim dari MainActivity
        val data: Filsuf? = intent.getParcelableExtra("FILSUF_DATA")

        // data Filsuf pada UI
        if (data != null) {
            val nameTextView = findViewById<TextView>(R.id.tv_detail_name)
            val descriptionTextView = findViewById<TextView>(R.id.tv_detail_description)
            val photoImageView = findViewById<ImageView>(R.id.iv_detail_photo)

            nameTextView.text = data.name
            descriptionTextView.text = data.description
            Glide.with(this).load(data.photo).into(photoImageView)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_detail, menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_share -> {
                // Mendapatkan data teks dari objek data
                val data: Filsuf? = intent.getParcelableExtra("FILSUF_DATA")
                val textToShare = data?.description ?: "Teks yang ingin Anda bagikan jika data tidak tersedia" // Menggunakan deskripsi dari objek data, atau teks cadangan jika data tidak ada

                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_TEXT, textToShare)
                startActivity(Intent.createChooser(shareIntent, "Bagikan melalui"))
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
