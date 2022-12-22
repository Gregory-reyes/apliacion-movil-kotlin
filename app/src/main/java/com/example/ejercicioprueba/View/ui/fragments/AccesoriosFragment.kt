package com.example.ejercicioprueba.View.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ejercicioprueba.R

/**
 * A simple [Fragment] subclass.
 * Use the [AccesoriosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccesoriosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_accesorios, container, false)
    }
}