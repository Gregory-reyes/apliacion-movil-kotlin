package com.example.ejercicioprueba

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val botonEnviar: Button = findViewById(R.id.btnEnviar)

        botonEnviar.setOnClickListener {
           // Toast.makeText(this, "Se presiono el Button", Toast.LENGTH_SHORT).show()
           val texto: TextView = findViewById(R.id.txtHello)
           texto.text = aleatorio(22).toString()
        }*/
    }
    /*fun aleatorio(max: Int):Int{
        return (1..max).random()
    }*/
}