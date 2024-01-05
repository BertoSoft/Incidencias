package com.bertosoft.incidencias.data.model

import android.content.Context
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.domain.model.AddEnumModel
import com.bertosoft.incidencias.domain.model.ModeloHorasDomain

data class ModeloHorasData(
    val iId: Int,
    val contexto: Context,
    val fecha: String,
    val incidencia: AddEnumModel,
    val cantidad: String
){
    fun toDomain(): ModeloHorasDomain {
        val fechaDes = FuncAux().descifrar(fecha)
        val cantidadDes = FuncAux().descifrar(cantidad)
        return ModeloHorasDomain(
            iId = iId,
            contexto = contexto,
            fecha = fechaDes,
            incidencia = incidencia,
            cantidad = cantidadDes
        )
    }
}
