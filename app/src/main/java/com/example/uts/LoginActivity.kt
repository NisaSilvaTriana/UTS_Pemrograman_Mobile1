package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        registerButton = findViewById(R.id.registerButton)

        // Tombol Login: validasi username dan password
        loginButton.setOnClickListener {
            val inputUsername = usernameEditText.text.toString()
            val inputPassword = passwordEditText.text.toString()

            val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
            val savedUsername = sharedPref.getString("username", null)
            val savedPassword = sharedPref.getString("password", null)

            if (inputUsername == savedUsername && inputPassword == savedPassword) {
                // Login berhasil
                Toast.makeText(this, "Login berhasil!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, NewsPortalDashboardActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                // Gagal login
                Toast.makeText(this, "Username atau password salah! Silahkan daftar terlebih dahulu", Toast.LENGTH_SHORT).show()
            }
        }

        // Tombol Register: pindah ke RegisterActivity
        registerButton.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
