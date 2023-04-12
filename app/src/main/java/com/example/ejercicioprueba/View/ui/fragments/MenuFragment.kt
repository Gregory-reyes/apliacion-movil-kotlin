package com.example.ejercicioprueba.View.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.ejercicioprueba.R


class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    //Creando los evento para cada uno de los fragmentos
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardAccesorios= view.findViewById<CardView>(R.id.fragAccesorios) //CardView hace refenrencia para que evento se realice en el recuadro
        cardAccesorios.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_accesoriosFragment)
        }
        val cardBilleteras= view.findViewById<CardView>(R.id.fragBilleteras)
        cardBilleteras.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_billeterasFragment)
        }
        val cardBolsos= view.findViewById<CardView>(R.id.fragBolsos)
        cardBolsos.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_bolsosFragment)
        }
        val cardCalzado= view.findViewById<CardView>(R.id.fragCalzado)
        cardCalzado.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_calzadoFragment)
        }
        val cardCamisas= view.findViewById<CardView>(R.id.fragCamisas)
        cardCamisas.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_camisasFragment)
        }
        val cardCorreas= view.findViewById<CardView>(R.id.fragCorreas)
        cardCorreas.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_correasFragment)
        }
        val cardGorras= view.findViewById<CardView>(R.id.fragGorras)
        cardGorras.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_gorrasFragment)
        }
        val cardJeans= view.findViewById<CardView>(R.id.fragJeans)
        cardJeans.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_jeansFragment)
        }
        val cardPerfumes= view.findViewById<CardView>(R.id.fragPerfumes)
        cardPerfumes.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_perfumesFragment)
        }
    }

}