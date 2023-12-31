package com.bertosoft.incidencias.ui.add.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bertosoft.incidencias.R
import com.bertosoft.incidencias.domain.model.AddInfo
import com.bertosoft.incidencias.ui.add.AddViewModel

class AddAdapter(private var addLista: List<AddInfo> = emptyList()): RecyclerView.Adapter<AddViewHolder>() {

    fun refrescaLista(nuevaLista: List<AddInfo>){
        addLista = nuevaLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddViewHolder {
        return AddViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_add, parent, false))
    }

    override fun getItemCount(): Int = addLista.size

    override fun onBindViewHolder(holder: AddViewHolder, position: Int) {
        holder.render(addLista[position])
    }
}