package com.ardiansyahmnur.informasiclub_football

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListClubAdapter(private val listClub: ArrayList<Club>) : RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_club, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val club = listClub[position]

        Glide.with(holder.itemView.context)
            .load(club.photo)
            .apply(RequestOptions().override(55, 55))
            .into(holder.imgPhoto)

        holder.tvName.text = club.name
        holder.tvStadium.text = club.stadium
        holder.tvDetail.text = club.detail

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listClub[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listClub.size
    }

    inner class ListViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName : TextView = itemView.findViewById(R.id.tv_item_name)
        var tvStadium : TextView = itemView.findViewById(R.id.tv_item_stadium)
        var tvDetail : TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto : ImageView = itemView.findViewById(R.id.img_item_photo)

    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Club)
    }
}
//pada kode program diatas memiliki sebuah akses guna jembatan antara dan AdapterView (contohnya ListView) dengan data.
//Adapter inilah yang menyediakan akses ke item data dan juga bertanggung jawab untuk membuat sebuah View pada setiap item dalam kumpulan data.
//menampilkan item yang dimuat ke dalam adaptor. Jenis adaptor yang paling umum berasal dari sumber data berbasis array. 
//Panduan ini menunjukkan cara menyelesaikan beberapa langkah penting terkait penyiapan adaptor.
//ArrayAdapters adalah adapter yang simple yang biasanya digunakan untuk mengubah ArrayList sebuah object menjadi View item yang dimasukkan ke dalam ListView Container
