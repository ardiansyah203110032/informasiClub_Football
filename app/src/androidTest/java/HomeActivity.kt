package com.ardiansyahmnur.informasiclub_football

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity() {

    private lateinit var rvClub: RecyclerView
    private var list: ArrayList<Club> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rvClub = findViewById(R.id.rv_clubs)
        rvClub.setHasFixedSize(true)

        list.addAll(ClubsData.listData)
        showRecyclerList()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.about_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.about_page -> {
                val moveIntent = Intent(this@HomeActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
    }

    private fun showSelectedHero(club: Club) {
        val moveIntent = Intent(this@HomeActivity, DetailActivity::class.java)
        moveIntent.putExtra(DetailActivity.EXTRA_NAME, club.name)
        moveIntent.putExtra(DetailActivity.EXTRA_STADIUM, club.stadium)
        moveIntent.putExtra(DetailActivity.EXTRA_DETAIL, club.detail)
        moveIntent.putExtra(DetailActivity.EXTRA_PHOTO, club.photo)
        startActivity(moveIntent)
    }

    private fun showRecyclerList() {
        rvClub.layoutManager = LinearLayoutManager(this)
        val listClubAdapter = ListClubAdapter(list)
        rvClub.adapter = listClubAdapter

        listClubAdapter.setOnItemClickCallback(object : ListClubAdapter.OnItemClickCallback {
            override fun onItemClicked(data: Club) {
                showSelectedHero(data)
            }
        })
    }
}
//pada kode program diatas merupakan sebuah  digunakan untuk memulai sebuah activity lain. Intent dibagi menjadi 2, yaitu : 
//Explicit Intent berfungsi untuk mengaktifkan komponen-komponen dalam satu aplikasi yang sama. 
//sebuah komponen aplikasi yang menyediakan layar yang digunakan pengguna untuk berinteraksi guna melakukan sesuatu, 
//misalnya memilih nomor ponsel, mengambil foto, mengirim email, atau menampilkan peta.
