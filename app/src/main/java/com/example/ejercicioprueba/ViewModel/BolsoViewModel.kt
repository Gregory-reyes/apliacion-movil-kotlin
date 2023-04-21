package com.example.ejercicioprueba.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ejercicioprueba.Domain.repository
import com.example.ejercicioprueba.Model.Bolsos

class BolsoViewModel:ViewModel() {
    val repository=repository()

    fun fetchBolsosData(): LiveData<MutableList<Bolsos>> {
        val mutableLiveData= MutableLiveData<MutableList<Bolsos>>()
        repository.getBolsosData().observeForever {
            mutableLiveData.value=it
        }
        return mutableLiveData
    }
}