package com.bertosoft.incidencias.domain.model

import android.content.Context
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.data.model.ModeloVoladurasData

data class ModeloVoladurasDomain (
    val iId: Int,
    val contexto: Context,
    val fecha: String,
    val cantidad: String,
){
    fun toData(): ModeloVoladurasData {

        val fechaCod = FuncAux().cifrar(fecha)
        val cantidadCod = FuncAux().cifrar(cantidad)

        return ModeloVoladurasData(
            iId = iId,
            contexto = contexto,
            fecha = fechaCod,
            cantidad =cantidadCod
        )
    }
}