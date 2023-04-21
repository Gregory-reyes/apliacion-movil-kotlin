package com.example.ejercicioprueba.Domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ejercicioprueba.Model.Bolsos
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class repository {
    //Función que nos trae la información de Firebase
    fun getBolsosData(): LiveData<MutableList<Bolsos>>{//Nos pemite almacenar la información de la colección
        val mutableLiveData= MutableLiveData<MutableList<Bolsos>>() //definimos la variable mutableLiveData definir los libros
        FirebaseFirestore.getInstance().collection("Bolsos").get().addOnSuccessListener {//llamamos a la colección que tenemos en Firebase en nuestro caso es Bolsos
            result-> //result se encarga de almacenar la información de la colección
            val listData= mutableListOf<Bolsos>()//Definir la lista

            for(document in result){//Recorrer la lista información de la colección
                val url=document.getString("url")
                val description=document.getString("description")
                val price=document.getString("price")
                val tittle=document.getString("tittle")
                val bolsos=Bolsos(url!!,description!!,price!!,tittle!!)
                listData.add(bolsos)
            }
            mutableLiveData.value=listData
        }
        return mutableLiveData

    }
}