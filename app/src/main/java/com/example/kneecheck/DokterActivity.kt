package com.example.kneecheck

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.kneecheck.databinding.ActivityDokterBinding

class DokterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDokterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDokterBinding.inflate(layoutInflater)
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

        val navController = findNavController(R.id.nav_host_fragment_activity_dokter)
        navController.navigate(R.id.navigation_dashboard, bundle)
        navView.setupWithNavController(navController)
    }
}