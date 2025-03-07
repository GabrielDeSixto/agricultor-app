package com.example.app_agricultor

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Registrar : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar) // Carga el diseño XML

        // Aquí puedes agregar código para interactuar con las vistas
        //val welcomeTextView = findViewById<TextView>(R.id.textViewWelcome)
        // Por ejemplo, puedes cambiar el texto del TextView:
        // welcomeTextView.text = "¡Hola desde Kotlin!"
    }
}