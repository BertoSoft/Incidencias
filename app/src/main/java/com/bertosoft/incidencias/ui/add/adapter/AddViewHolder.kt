package com.bertosoft.incidencias.ui.add.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bertosoft.incidencias.databinding.ItemAddBinding
import com.bertosoft.incidencias.domain.model.AddInfo

class AddViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemAddBinding.bind(view)

    fun render(addInfo: AddInfo){
        val context = binding.tvIcono.context

        binding.ivIcono.setImageResource(addInfo.imagen)
        binding.tvIcono.text = context.getString(addInfo.texto)
    }

}