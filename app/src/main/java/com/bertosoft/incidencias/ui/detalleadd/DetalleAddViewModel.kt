package com.bertosoft.incidencias.ui.detalleadd

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bertosoft.incidencias.domain.model.AddEnumModel
import com.bertosoft.incidencias.domain.model.DetalleAddInfo
import com.bertosoft.incidencias.domain.usescase.SetHorasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetalleAddViewModel @Inject constructor(private val setHorasUseCase: SetHorasUseCase): ViewModel() {

    private var _datos =  MutableStateFlow<List<DetalleAddInfo>>(emptyList())
    val datos: StateFlow<List<DetalleAddInfo>> = _datos

    init {
        _datos.value = listOf(
            DetalleAddInfo.uno,
            DetalleAddInfo.uno_medio,
            DetalleAddInfo.dos,
            DetalleAddInfo.dos_medio,
            DetalleAddInfo.tres,
            DetalleAddInfo.tres_medio,
            DetalleAddInfo.cuatro,
            DetalleAddInfo.cuatro_medio,
            DetalleAddInfo.cinco,
            DetalleAddInfo.cinco_medio,
            DetalleAddInfo.seis,
            DetalleAddInfo.seis_medio
            )
    }

    fun setHoras(
        contexto: Context,
        fecha: String,
        incidencia: AddEnumModel,
        cantidad: String
    ): String{
        return setHorasUseCase(
            contexto,
            fecha,
            incidencia,
            cantidad
        )
    }
}