package com.example.ejercicioprueba.View.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicioprueba.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class SignUpActivity: AppCompatActivity() {
    lateinit var register:Button
    lateinit var firebaseAuth: FirebaseAuth

    lateinit var databaseReference: DatabaseReference
    //lateinit var database: FirebaseDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

//Declaramos las variable llamandolas del activity_login
        firebaseAuth = Firebase.auth
        //database = FirebaseDatabase.getInstance()
        databaseReference = databaseReference.database.reference.child("User")

        register= findViewById(R.id.register2)

        val name = findViewById<EditText>(R.id.signupname)
        val celular = findViewById<EditText>(R.id.signupphone)
        val email = findViewById<EditText>(R.id.signupemail)
        val password1 = findViewById<EditText>(R.id.signuppassword1)
        val password2 = findViewById<EditText>(R.id.signuppassword2)

        register.setOnClickListener {
            //startActivity(Intent(this,LoginActivity::class.java))
            createUser(email.text.toString(),password1.text.toString(),name.text.toString(),celular.text.toString(),password2.text.toString())
        }
    }
//Función de autentificación registro de email y contraseña
    fun createUser(email: String, password1: String, name: String, celular: String, password2: String){
        firebaseAuth.currentUser?.sendEmailVerification()
        firebaseAuth.createUserWithEmailAndPassword(email,password1)
            .addOnCompleteListener(this){
                Task->if (Task.isSuccessful){
                    val user = firebaseAuth.currentUser
                    val userdb = databaseReference.child(user?.uid.toString())
                    userdb.child("Name").setValue(name)
                    userdb.child("Celular").setValue(celular)
                    //userdb.child("Email").setValue(email)
                    //userdb.child("Password1").setValue(password1)
                    userdb.child("Password2").setValue(password2)
                    startActivity(Intent(this,LoginActivity::class.java))
                }else{
                    Toast.makeText(applicationContext, "Try again", Toast.LENGTH_LONG).show()
                }
            }
    }

}