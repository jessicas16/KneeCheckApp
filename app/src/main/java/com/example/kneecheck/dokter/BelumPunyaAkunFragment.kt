package com.example.kneecheck.dokter

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import com.example.kneecheck.R

class BelumPunyaAkunFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_belum_punya_akun)

        // Contoh pengaturan logika di halaman ini
        findViewById<Button>(R.id.btnblmpunyaakun).setOnClickListener {
            // Arahkan ke halaman pendaftaran
            val intent = Intent(this, DetailHistoryFragment::class.java)
            startActivity(intent)
        }
    }
}
