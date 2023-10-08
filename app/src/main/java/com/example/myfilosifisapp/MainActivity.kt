package com.example.myfilosifisapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var rvFilsuf: RecyclerView
    private val list: ArrayList<Filsuf> = ArrayList()

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilsuf = findViewById(R.id.rv_filsuf)
        rvFilsuf.setHasFixedSize(true)
        list.addAll(getListFilsuf())
        showRecyclerList()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }


    private fun showRecyclerList() {
        rvFilsuf.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = ListFilsufAdapter(list)
        rvFilsuf.adapter = listHeroAdapter

        listHeroAdapter.setOnItemClickCallback(object : ListFilsufAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Filsuf) {
                // Saat item diklik, buat Intent untuk memulai aktivitas detail
                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                // Kirim data Filsuf ke aktivitas detail
                intent.putExtra("FILSUF_DATA", data)
                startActivity(intent)
            }
        })
    }


    private fun getListFilsuf(): ArrayList<Filsuf> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listFilsuf = ArrayList<Filsuf>()
        for (i in dataName.indices) {
            val filsuf = Filsuf(dataName[i], dataDescription[i], dataPhoto[i])
            listFilsuf.add(filsuf)
        }
        return listFilsuf
    }

    private fun showSelectedFilsuf(filsuf: Filsuf) {
        Toast.makeText(this, "Kamu memilih " + filsuf.name, Toast.LENGTH_SHORT).show()
    }
}
