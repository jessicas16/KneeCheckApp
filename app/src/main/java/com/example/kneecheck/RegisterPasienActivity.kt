package com.example.kneecheck

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kneecheck.databinding.ActivityRegisterPasienBinding

class RegisterPasienActivity : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterPasienBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterPasienBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDaftarPasien.setOnClickListener {

        }
    }
}