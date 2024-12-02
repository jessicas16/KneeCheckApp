package com.example.kneecheck

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.kneecheck.config.ApiConfiguration
import com.example.kneecheck.config.DefaultRepo
import com.example.kneecheck.databinding.ActivityLoginBinding
import com.example.kneecheck.entity.loginDTO
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private var repo: DefaultRepo? = null
    private val ioScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    private val mainScope: CoroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            ApiConfiguration.getApiService()
            repo = ApiConfiguration.defaultRepo
            Log.d("API", "API Connected")
        } catch (e : Error){
            Log.e("Error API", e.message.toString())
        }
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val emailEt: EditText = binding.emailEditText
        val passwordEt: EditText = binding.passwordEditText
        val loginBtn: TextView = binding.loginButton
        val registerBtn: TextView = binding.daftar

        loginBtn.setOnClickListener {
            val email = emailEt.text.toString()
            val password = passwordEt.text.toString()

            if (email.isEmpty()) {
                emailEt.error = "Email is required"
                emailEt.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                passwordEt.error = "Password is required"
                passwordEt.requestFocus()
                return@setOnClickListener
            }

            ioScope.launch {
                val login = loginDTO(
                    email = email,
                    password = password
                )
                try {
                    repo?.login(login)
                    mainScope.launch {
                        Toast.makeText(this@LoginActivity, "Login Success", Toast.LENGTH_SHORT).show()
                    }
                } catch (e: Exception) {
                    Log.e("Error Login", e.message.toString())
                    mainScope.launch {
                        Toast.makeText(this@LoginActivity, "email atau password salah", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        registerBtn.setOnClickListener {
            val intent = Intent(baseContext, ChooseProfileActivity::class.java)
            startActivity(intent)
        }

    }
}