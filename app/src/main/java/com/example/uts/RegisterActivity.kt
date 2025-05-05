package com.example.uts

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {

    private lateinit var registerUsername: EditText
    private lateinit var registerPassword: EditText
    private lateinit var registerEmail: EditText
    private lateinit var loginFromRegisterButton: TextView
    private lateinit var loginButtonFromRegister: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Inisialisasi elemen input dan tombol
        registerUsername = findViewById(R.id.registerUsername)
        registerPassword = findViewById(R.id.registerPassword)
        registerEmail = findViewById(R.id.registerEmail)
        loginFromRegisterButton = findViewById(R.id.loginFromRegisterButton)
        loginButtonFromRegister = findViewById(R.id.loginButtonFromRegister)

        // Klik "Sudah punya akun? Login" → kembali ke LoginActivity
        loginFromRegisterButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Klik tombol "Login" setelah pengisian data
        loginButtonFromRegister.setOnClickListener {
            val username = registerUsername.text.toString()
            val password = registerPassword.text.toString()
            val email = registerEmail.text.toString()

            if (username.isNotEmpty() && password.isNotEmpty() && email.isNotEmpty()) {
                // ✅ Simpan data ke SharedPreferences
                val sharedPref = getSharedPreferences("UserData", MODE_PRIVATE)
                with(sharedPref.edit()) {
                    putString("username", username)
                    putString("password", password)
                    apply()
                }

                // Notifikasi dan pindah ke Login
                Toast.makeText(this, "Registrasi berhasil! Silakan login.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Harap isi semua field!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
