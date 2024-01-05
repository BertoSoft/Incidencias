package com.bertosoft.incidencias.domain.usescase

import android.content.Context
import com.bertosoft.incidencias.data.repositorio.RepositorioVoladuras
import com.bertosoft.incidencias.domain.model.ModeloVoladurasDomain
import javax.inject.Inject

class SetPlusVoladuraUseCase @Inject constructor(private val repositorio: RepositorioVoladuras) {
    operator fun invoke(contexto: Context, fecha: String, cantidad: String): String {
        //
        // Aqui el cambio de modelo de datos
        //
        return repositorio.setPlusVoladuras (ModeloVoladurasDomain(-1, contexto, fecha, cantidad).toData())
    }
}