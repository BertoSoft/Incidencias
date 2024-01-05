package com.bertosoft.incidencias.domain.usescase

import android.content.Context
import com.bertosoft.incidencias.data.repositorio.RepositorioHoras
import com.bertosoft.incidencias.domain.model.AddEnumModel
import com.bertosoft.incidencias.domain.model.ModeloHorasDomain
import javax.inject.Inject

class SetHorasUseCase @Inject constructor(private val repositorio: RepositorioHoras) {
    operator fun invoke(
        contexto: Context,
        fecha: String,
        incidencia: AddEnumModel,
        cantidad: String
    ): String{
        //
        // Aqui el cambio de modelo de datos
        //
       return repositorio.setHoras(ModeloHorasDomain(-1, contexto, fecha, incidencia, cantidad).toData())
    }
}