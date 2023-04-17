package com.example.ejercicioprueba.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.os.RecoverySystem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioprueba.R
import com.example.ejercicioprueba.databinding.ActivityMainBinding
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity:AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var signup: Button
    lateinit var home: Button
    lateinit var firebaseAuth: FirebaseAuth
    //lateinit var autoStateListener: AuthStateListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        firebaseAuth = Firebase.auth
        var email = findViewById<EditText>(R.id.loginEmail)
        var password = findViewById<EditText>(R.id.loginPassword)

    //Configuración de los evento de click de todos los  layout con funcionalidades
        signup= findViewById(R.id.register1)
        signup.setOnClickListener {
            startActivity(Intent(this,SignUpActivity::class.java))
        }

        var restore = findViewById<TextView>(R.id.loginRestore)
        restore.setOnClickListener {
            startActivity(Intent(this,RestoreActivity::class.java))
        }

        home= findViewById(R.id.login)
        home.setOnClickListener {
            login(email.text.toString(),password.text.toString())
        }
    }
    //Función del login
    fun login(email:String,password:String){
        firebaseAuth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener(this){
                Task->if(Task.isSuccessful){
                    val user= firebaseAuth.currentUser
                Toast.makeText(baseContext,user?.uid.toString(),Toast.LENGTH_LONG).show()
                startActivity(Intent(this,HomeActivity::class.java))
                }else{
                    Toast.makeText(baseContext,"Error",Toast.LENGTH_LONG).show()
                }

            }
    }
}