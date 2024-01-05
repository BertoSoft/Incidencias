package com.bertosoft.incidencias.domain.repositorio

import com.bertosoft.incidencias.data.model.ModeloVoladurasData

interface RepositorioVoladurasDomain {
    fun setPlusVoladuras(datos: ModeloVoladurasData): String
}