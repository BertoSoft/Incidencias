package com.bertosoft.incidencias.domain.model

import android.content.Context
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.data.model.ModeloHorasData

data class ModeloHorasDomain(
    val iId: Int,
    val contexto: Context,
    val fecha: String,
    val incidencia: AddEnumModel,
    val cantidad: String
){
    fun toData(): ModeloHorasData {
        val fechaCod = FuncAux().cifrar(fecha)
        val cantidadCod = FuncAux().cifrar(cantidad)
        return ModeloHorasData(
            iId = iId,
            contexto = contexto,
            fecha = fechaCod,
            incidencia = incidencia,
            cantidad = cantidadCod
        )
    }
}
