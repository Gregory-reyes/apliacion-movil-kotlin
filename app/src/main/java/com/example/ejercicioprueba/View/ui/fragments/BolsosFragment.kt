package com.example.ejercicioprueba.View.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioprueba.R
import com.example.ejercicioprueba.View.adapter.BolsoAdapter

class BolsosFragment : Fragment() {
    lateinit var recyclerBolsos: RecyclerView
    lateinit var adapter: Adapter
    val viewModel by lazy {ViewModelProviders(this).get(BolsoViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bolsos, container, false)
        recyclerBolsos= view.findViewById(R.id.rvBolsos)
    }

}