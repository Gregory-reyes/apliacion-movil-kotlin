package com.example.ejercicioprueba.View.adapter

import android.content.Context
import android.database.DataSetObserver
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ejercicioprueba.Model.Bolsos
import com.example.ejercicioprueba.R
import com.squareup.picasso.Picasso

class BolsoAdapter(val context: Context): RecyclerView.Adapter<BolsoAdapter.ViewHolder>(), Adapter {//retorna el recylcer view
    var bolsoList= mutableListOf<Bolsos>()

        fun setListData(data: MutableList<Bolsos>){
            bolsoList=data
        }


    override fun onCreateViewHolder(ViewGroup: ViewGroup, i: Int): ViewHolder {//contenedor de los datos
        val v= LayoutInflater.from(ViewGroup.context).inflate(R.layout.card_view_bolsos, ViewGroup, false)//traemos el layout por el cardview
        return ViewHolder(v) //nos trae la vista
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) { //traemos la informción de la lista de bolsos
        val bolso= bolsoList[i]
        viewHolder.bindWew(bolso)
    }

    override fun getItemCount(): Int { //retornamos el tamaño del bolso
        return bolsoList.size
    }

   inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindWew(bolso: Bolsos){

            Picasso.get().load(bolso.url).into(itemView.findViewById<ImageView>(R.id.imgBolso))

            itemView.findViewById<TextView>(R.id.tittleBolso).text=bolso.tittle
            itemView.findViewById<TextView>(R.id.descriptionBolso).text=bolso.description
            itemView.findViewById<TextView>(R.id.priceBolso).text=bolso.price.toString()

            }
        }

    override fun registerDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun unregisterDataSetObserver(p0: DataSetObserver?) {
        TODO("Not yet implemented")
    }

    override fun getCount(): Int {
        TODO("Not yet implemented")
    }

    override fun getItem(p0: Int): Any {
        TODO("Not yet implemented")
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        TODO("Not yet implemented")
    }

    override fun getViewTypeCount(): Int {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }
}