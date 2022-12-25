package com.ardiansyahmnur.informasiclub_football

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        supportActionBar?.hide()

        Handler().postDelayed({
            val intent = Intent( this@MainActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}
//pada kode program diatas merupakan salah satu komponen yang ada di Android Studio yang berfungsi untuk menampilkan user interface (UI) dari aplikasi yang akan dibuat, 
//biasanya diletakkan pada “setcontentview”. Bukan hanya menampilkan UI, activity juga digunakan untuk melakukan berbagai kegiatan yang diperlukan di dalam aplikasi
//dirancang untuk memfasilitasi paradigma ini. Jika satu aplikasi memanggil aplikasi lainnya, 
//aplikasi pemanggil akan memanggil aktivitas di aplikasi lain, bukan aplikasi sebagai keseluruhan atomik.memiliki sebuah fungsi
//Intent pada android merupakan sebuah class yang digunakan untuk berpindah activity atau halaman. 
//Sedangkan activity sendiri merupakan suatu halaman yang dapat dilihat pengguna untuk berinteraksi dengan aplikasi.
