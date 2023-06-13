package com.example.gastoviagem

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AbastecerListAdapter(private val abastecer: List<Abastacer>): RecyclerView.Adapter<AbastecerListViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AbastecerListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.activity_main_home, parent, false)
        return AbastecerListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return abastecer.size
    }

    override fun onBindViewHolder(holder: AbastecerListViewHolder, position: Int) {
        val abastece = abastecer[position]
        holder.bind(abastece)
    }

}


class AbastecerListViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val tvStation = view.findViewById<TextView>(R.id.text_station)
    private val tvValue = view.findViewById<TextView>(R.id.text_value)

    fun bind(abastece: Abastacer){
        tvStation.text = abastece.posto
        tvValue.text = abastece.valor.toString()
    }
}