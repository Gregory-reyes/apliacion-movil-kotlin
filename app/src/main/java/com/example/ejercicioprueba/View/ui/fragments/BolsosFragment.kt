package com.example.ejercicioprueba.View.ui.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioprueba.R
import com.example.ejercicioprueba.View.adapter.BolsoAdapter
import com.example.ejercicioprueba.ViewModel.BolsoViewModel

class BolsosFragment : Fragment() {
    lateinit var recyclerBolso: RecyclerView
    lateinit var adapter: BolsoAdapter
    val viewModel by lazy { ViewModelProvider(this).get(BolsoViewModel::class.java) }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_bolsos, container, false)
        recyclerBolso= view.findViewById(R.id.rvBolsos)
        adapter= BolsoAdapter(requireContext())
        recyclerBolso.layoutManager= LinearLayoutManager(context)
        recyclerBolso.adapter=adapter //asignamos el adaptador
        observeData()

        return view
    }

    @SuppressLint("NotifyDataSetChanged")
    fun observeData(){
        viewModel.fetchBolsosData().observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            (adapter).setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

}