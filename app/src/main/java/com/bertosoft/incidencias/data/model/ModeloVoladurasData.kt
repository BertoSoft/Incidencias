package com.bertosoft.incidencias.data.model

import android.content.Context
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.domain.model.ModeloVoladurasDomain

data class ModeloVoladurasData(
    val iId: Int,
    val contexto: Context,
    val fecha: String,
    val cantidad: String,
){
    fun toDomain(): ModeloVoladurasDomain {
        val fechaDes = FuncAux().descifrar(fecha)
        val cantidadDes = FuncAux().descifrar(cantidad)
        return ModeloVoladurasDomain(
            iId = iId,
            contexto = contexto,
            fecha = fechaDes,
            cantidad = cantidadDes
        )
    }
}