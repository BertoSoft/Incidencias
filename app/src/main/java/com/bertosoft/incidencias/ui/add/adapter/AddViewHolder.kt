package com.bertosoft.incidencias.ui.add.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.bertosoft.incidencias.databinding.ItemAddBinding
import com.bertosoft.incidencias.domain.model.AddInfo

class AddViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemAddBinding.bind(view)

    fun render(addInfo: AddInfo, onItemSeleccionado: (AddInfo) -> Unit) {
        val context = binding.tvIcono.context

        binding.ivIcono.setImageResource(addInfo.imagen)
        binding.tvIcono.text = context.getString(addInfo.texto)

        binding.parentRV.setOnClickListener {
            comienzaAnimacionRotacion(
                binding.ivIcono,
                nuevaLambda = { onItemSeleccionado(addInfo)})
        }
    }

    private fun comienzaAnimacionRotacion(view: View, nuevaLambda: () -> Unit) {

        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction(nuevaLambda)
            start()
        }
    }
}