package com.bertosoft.incidencias.ui.detalleadd.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bertosoft.incidencias.R
import com.bertosoft.incidencias.domain.model.DetalleAddInfo

class DetalleAddAdapter(
    private var lista: List<DetalleAddInfo> = emptyList(),
    private val onItemSeleccionado: (DetalleAddInfo) -> Unit
    ): RecyclerView.Adapter<DetalleAddViewHolder>() {

    fun refrescaLista(nuevaLista: List<DetalleAddInfo>){
        lista = nuevaLista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetalleAddViewHolder {
        return DetalleAddViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_detalle_add, parent, false)
        )
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: DetalleAddViewHolder, position: Int) {
        holder.render(lista[position], onItemSeleccionado)
    }
}