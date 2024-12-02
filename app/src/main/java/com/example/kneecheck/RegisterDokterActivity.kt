package com.example.kneecheck

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kneecheck.databinding.ActivityRegisterDokterBinding

class RegisterDokterActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterDokterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterDokterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftarDokter.setOnClickListener {

        }
    }
}