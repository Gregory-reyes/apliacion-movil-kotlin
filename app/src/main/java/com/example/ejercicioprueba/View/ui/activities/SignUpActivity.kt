package com.example.ejercicioprueba.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioprueba.R
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SignUpActivity: AppCompatActivity() {
    lateinit var register:Button
    lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

//Declaramos las variable llamandolas del activity_login
        firebaseAuth = Firebase.auth
        register= findViewById(R.id.register2)

        val name = findViewById<EditText>(R.id.signupname)
        val celular = findViewById<EditText>(R.id.signupphone)
        val email = findViewById<EditText>(R.id.signupemail)
        val password1 = findViewById<EditText>(R.id.signuppassword1)
        val password2 = findViewById<EditText>(R.id.signuppassword2)

        register.setOnClickListener {
            //startActivity(Intent(this,LoginActivity::class.java))
            createUser(email.text.toString(),password1.text.toString())
        }
    }
//Función de autentificación registro de email y contraseña
    fun createUser(email:String, password1:String){
        firebaseAuth.createUserWithEmailAndPassword(email,password1)
            .addOnCompleteListener(this){
                Task->if (Task.isSuccessful){
                    startActivity(Intent(this,LoginActivity::class.java))
                }else{
                    Toast.makeText(applicationContext, "Try again", Toast.LENGTH_LONG).show()
                }
            }
    }

}