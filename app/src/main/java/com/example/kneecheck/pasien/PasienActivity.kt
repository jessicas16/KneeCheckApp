package com.example.kneecheck.dokter

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kneecheck.R
import com.example.kneecheck.databinding.ActivityDokterBinding
import com.example.kneecheck.databinding.ActivityPasienBinding

class PasienActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPasienBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPasienBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navView: BottomNavigationView = binding.navView

        val id = intent.getStringExtra("id")
        val name = intent.getStringExtra("name")
        val token = intent.getStringExtra("token")



        val bundle = Bundle().apply {
            putString("id", id)
            putString("name", name)
            putString("token", token)
        }

        val navController = findNavController(R.id.nav_host_fragment_activity_bottom_navigation_pasien)
        navController.navigate(R.id.navigation_scan, bundle)
        navView.setupWithNavController(navController)
    }
}