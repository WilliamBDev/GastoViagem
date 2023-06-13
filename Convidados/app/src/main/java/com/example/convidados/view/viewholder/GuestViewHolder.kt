package com.example.convidados.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.convidados.R
import com.example.convidados.model.GuestModel

class GuestViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    fun bind(guest: GuestModel){
        itemView.findViewById<TextView>(R.id.text_name)
    }

}