package com.example.pab_2301

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class NavCustomActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nav_custom)

        // Inisialisasi komponen dari layout XML
        val spinnerKategori = findViewById<Spinner>(R.id.spinnerKategori)
        val rgPembayaran = findViewById<RadioGroup>(R.id.rgPembayaran)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvHasil = findViewById<TextView>(R.id.tvHasil)

        // Mengisi pilihan Spinner
        val dataKategori = arrayOf("Elektronik", "Pakaian", "Makanan", "Buku", "Otomotif")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, dataKategori)
        spinnerKategori.adapter = adapter

        // Event saat tombol "Simpan Pilihan" diklik
        btnSubmit.setOnClickListener {
            val kategoriTerpilih = spinnerKategori.selectedItem.toString()

            val selectedRadioId = rgPembayaran.checkedRadioButtonId
            if (selectedRadioId == -1) {
                Toast.makeText(this, "Pilih metode pembayaran terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val rbTerpilih = findViewById<RadioButton>(selectedRadioId)
            val pembayaranTerpilih = rbTerpilih.text.toString()

            val hasil = "Kategori: $kategoriTerpilih\nPembayaran: $pembayaranTerpilih"
            tvHasil.text = hasil
        }
    }
}