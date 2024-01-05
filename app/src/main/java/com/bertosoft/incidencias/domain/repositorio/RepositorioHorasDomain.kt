package com.bertosoft.incidencias.domain.repositorio

import com.bertosoft.incidencias.data.model.ModeloHorasData

interface RepositorioHorasDomain {
    fun setHoras(datos: ModeloHorasData): String
}