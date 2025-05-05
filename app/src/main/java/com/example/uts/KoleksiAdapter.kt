package com.example.uts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.content.ContextCompat

class BajuAdapter(private val context: Context, private val data: List<koleksi>) : BaseAdapter() {
    override fun getCount(): Int = data.size
    override fun getItem(position: Int): Any = data[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val row = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_baju, parent, false)

        val gambar = row.findViewById<ImageView>(R.id.gambarBaju)
        val nama = row.findViewById<TextView>(R.id.namaBaju)
        val harga = row.findViewById<TextView>(R.id.hargaBaju)

        val baju = data[position]
        gambar.setImageResource(baju.gambar)
        nama.text = baju.nama
        harga.text = baju.harga

        return row
    }
}
