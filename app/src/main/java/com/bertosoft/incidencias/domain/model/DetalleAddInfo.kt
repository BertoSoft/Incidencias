package com.bertosoft.incidencias.domain.model

import com.bertosoft.incidencias.R

sealed class DetalleAddInfo(val imagen: Int){
    data object uno: DetalleAddInfo(R.drawable.uno)
    data object uno_medio: DetalleAddInfo(R.drawable.uno_cinco)
    data object dos: DetalleAddInfo(R.drawable.dos)
    data object dos_medio: DetalleAddInfo(R.drawable.doscinco)
    data object tres: DetalleAddInfo(R.drawable.tres)
    data object tres_medio: DetalleAddInfo(R.drawable.tresmedio)
    data object cuatro: DetalleAddInfo(R.drawable.cuatro)
    data object cuatro_medio: DetalleAddInfo(R.drawable.cuatromedio)
    data object cinco: DetalleAddInfo(R.drawable.cinco)
    data object cinco_medio: DetalleAddInfo(R.drawable.cincomedia)
    data object seis: DetalleAddInfo(R.drawable.seis)
    data object seis_medio: DetalleAddInfo(R.drawable.seismedia)
}
