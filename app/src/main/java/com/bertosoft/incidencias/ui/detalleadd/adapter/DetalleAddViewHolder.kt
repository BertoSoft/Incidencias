package com.bertosoft.incidencias.ui.detalleadd.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bertosoft.incidencias.databinding.ItemDetalleAddBinding
import com.bertosoft.incidencias.domain.model.DetalleAddInfo

class DetalleAddViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemDetalleAddBinding.bind(view)

    fun render(detalleAddInfo: DetalleAddInfo, onItemSeleccionado: (DetalleAddInfo) -> Unit){

        binding.ivImagen.setImageResource(detalleAddInfo.imagen)

        binding.parentRV.setOnClickListener { onItemSeleccionado(detalleAddInfo) }
    }
}