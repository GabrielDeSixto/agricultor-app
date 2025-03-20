package com.example.app_agricultor

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity) // Asegúrate de que el layout se llame "activity_main"

        // Referencias a los elementos del layout
        val editTextEmail = findViewById<EditText>(R.id.editTextTextEmailAddress)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val textViewRegister = findViewById<TextView>(R.id.textViewRegister)

        // Listener del botón de login
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            // Aquí deberías verificar el usuario y contraseña, puedes hacer lo que quieras
            if (email == "admin" && password == "1234") {
                Toast.makeText(this, "Login correcto", Toast.LENGTH_SHORT).show()
                // Aqui deberias poner la pantalla a la que quieres ir
                //val intent = Intent(this, YourNextActivity::class.java)
                //startActivity(intent)
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }
        }
        // Listener del texto de registrarse
        textViewRegister.setOnClickListener {
           // val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}