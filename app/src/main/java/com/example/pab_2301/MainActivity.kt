package com.example.pab_2301

import com.example.pab_2301.R
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Spinner
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sesuaikan ID dengan XML
        val edtNama = findViewById<EditText>(R.id.editNama)
        val rgJk = findViewById<RadioGroup>(R.id.rgjk)
        val spKota = findViewById<Spinner>(R.id.spKota)
        val swMenyetujui = findViewById<Switch>(R.id.swMenyetujui)
        val btnSimpan = findViewById<Button>(R.id.btn_submit)
        val btnKeNavCustom = findViewById<Button>(R.id.btnKeNavCustom)

        val kota = arrayOf("Pilih Kota", "Jakarta", "Bandung", "Surabaya", "Padang")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, kota)
        spKota.adapter = adapter

        btnSimpan.setOnClickListener {
            if (edtNama.text.toString().trim().isEmpty()) {
                Toast.makeText(this, "Nama Tidak Boleh Kosong!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!swMenyetujui.isChecked) {
                Toast.makeText(this, "Anda harus menyetujui S&K!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val jk = when (rgJk.checkedRadioButtonId) {
                R.id.rblaki -> "Laki-Laki"
                R.id.rbPerempuan -> "Perempuan"
                else -> "Belum Dipilih"
            }

            val data = "Nama : ${edtNama.text}" +
                    "\nJenis Kelamin : $jk" +
                    "\nKota : ${spKota.selectedItem}"

            val intent = Intent(this, DuaActivity::class.java)
            intent.putExtra("DATA_HASIL", data)
            startActivity(intent)
        }

        btnKeNavCustom.setOnClickListener {
            val intent = Intent(this, NavCustomActivity::class.java)
            startActivity(intent)
        }
    }
}