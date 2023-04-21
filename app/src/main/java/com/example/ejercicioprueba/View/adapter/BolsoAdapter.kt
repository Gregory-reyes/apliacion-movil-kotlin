package com.example.ejercicioprueba.View.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioprueba.Model.Bolsos
import com.example.ejercicioprueba.R
import com.squareup.picasso.Picasso

class BolsoAdapter(val context: Context): RecyclerView.Adapter<BolsoAdapter.ViewHolder>() {
    var bolsoList= mutableListOf<Bolsos>()

        fun setListData(data: MutableList<Bolsos>){
            bolsoList=data
        }


    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {
        val view= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_bolsos, ViewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        val bolso= bolsoList[i]
        viewHolder.bindWew(bolso)
    }

    override fun getItemCount(): Int {
        return bolsoList.size
    }

   inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindWew(bolso: Bolsos){
            val img= itemView.findViewById<ImageView>(R.id.imgBolsos)
            Picasso.get().load(bolso.url).into(img)

            itemView.findViewById<TextView>(R.id.tittleBolsos).text=bolso.tittle
            itemView.findViewById<TextView>(R.id.descriptionBolsos).text=bolso.description
            itemView.findViewById<TextView>(R.id.priceBolsos).text=bolso.price

            }
        }
}