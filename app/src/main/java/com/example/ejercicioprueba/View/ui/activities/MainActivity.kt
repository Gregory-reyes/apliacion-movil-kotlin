package com.example.ejercicioprueba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.ejercicioprueba.View.ui.activities.LoginActivity
import com.example.ejercicioprueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Asociar el activity con el layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //COnfiguración que funcione la animación
        binding.animationView.playAnimation()
        //Transición de la animación y la siguente activity(4s)
        handler = Handler(Looper.myLooper()!!)
        handler.postDelayed({
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
            finish() },4000)

        //setContentView(R.layout.activity_main)

       /* val botonEnviar: Button = findViewById(R.id.btnEnviar)//

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