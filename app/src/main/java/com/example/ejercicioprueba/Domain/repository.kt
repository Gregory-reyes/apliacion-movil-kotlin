package com.example.ejercicioprueba.Domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.ejercicioprueba.Model.Bolsos
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class repository {
    fun getBolsosData(): LiveData<MutableList<Bolsos>>{
        val mutableLiveData= MutableLiveData<MutableList<Bolsos>>()
        FirebaseFirestore.getInstance().collection("Bolsos").get().addOnSuccessListener {
            result->
            val listData= mutableListOf<Bolsos>()

            for(document in result){
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