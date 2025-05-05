package com.example.uts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class NewsPortalDashboardActivity : AppCompatActivity() {

    data class Baju(val nama: String, val harga: String, val gambar: Int)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_portal_dashboard)

        val listView = findViewById<ListView>(R.id.listBaju)

        val daftarBaju = listOf(
            Baju("Jas Formal", "Rp1.500.000", R.drawable.jas),
            Baju("Jas Tuxedo", "Rp2.000.000", R.drawable.jas1),
            Baju("Jas Wedding", "Rp2.500.000", R.drawable.jas2),
            Baju("Jas Bleazer", "Rp1.750.000", R.drawable.jas3)
        )

        val adapter = object : BaseAdapter() {
            override fun getCount() = daftarBaju.size
            override fun getItem(position: Int) = daftarBaju[position]
            override fun getItemId(position: Int) = position.toLong()

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
                val view = convertView ?: LayoutInflater.from(this@NewsPortalDashboardActivity)
                    .inflate(R.layout.item_baju, parent, false)

                val baju = daftarBaju[position]
                view.findViewById<ImageView>(R.id.gambarBaju).setImageResource(baju.gambar)
                view.findViewById<TextView>(R.id.namaBaju).text = baju.nama
                view.findViewById<TextView>(R.id.hargaBaju).text = baju.harga

                return view
            }
        }

        listView.adapter = adapter
    }
}
