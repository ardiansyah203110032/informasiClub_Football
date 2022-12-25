package com.ardiansyahmnur.informasiclub_football

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity() {
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_STADIUM = "extra_stadium"
        const val EXTRA_DETAIL = "extra_detail"
        const val EXTRA_PHOTO = "extra_photo"

    }
//memberikan nilai variabel yang memuat text dan image.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val nameText: TextView = findViewById(R.id.textName)
        val stadiumText: TextView = findViewById(R.id.textStadium)
        val detailText : TextView = findViewById(R.id.textDetail)
        val imgClub:ImageView = findViewById(R.id.imgClub)

        val name = intent.getStringExtra(EXTRA_NAME)
        val stadium = intent.getStringExtra(EXTRA_STADIUM)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
        val img = intent.getIntExtra(EXTRA_PHOTO,0)

//pada kode tersebut terhubung pada sebuah fragmen aktivty yang terhubung pada data yang menampilkan text dan image.

        nameText.text = name
        stadiumText.text = stadium
        detailText.text = detail
        Glide.with(this)
            .load(img)
            .apply(RequestOptions())
            .into(imgClub)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.share_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_share -> {
                val sendIntent: Intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(Intent.EXTRA_TEXT, intent.getStringExtra(EXTRA_NAME))
                    type = "text/plain"
                }
                startActivity(sendIntent)
            }
        }
    }
}
//memuat semua detail dari aplikasi dengan varuabel dan konten yang diatur.
