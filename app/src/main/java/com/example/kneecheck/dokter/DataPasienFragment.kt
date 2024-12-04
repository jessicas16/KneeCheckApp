package com.example.kneecheck.dokter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.kneecheck.R

class DataPasienFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_data_pasien)

        // Contoh pengaturan logika di halaman ini
        findViewById<Button>(R.id.btnsdhpunyaakun).setOnClickListener {
            // Arahkan ke halaman pendaftaran
            val intent = Intent(this, DetailHistoryFragment::class.java)
            startActivity(intent)
        }
    }
}
