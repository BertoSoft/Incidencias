package com.bertosoft.incidencias.ui.add

import android.content.Context
import androidx.lifecycle.ViewModel
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.domain.model.AddInfo
import com.bertosoft.incidencias.domain.model.AddInfo.*
import com.bertosoft.incidencias.domain.usescase.SetPlusVoladuraUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val setPlusVoladuraUseCase: SetPlusVoladuraUseCase) : ViewModel() {

    private var _addDatos = MutableStateFlow<List<AddInfo>>(emptyList())
    val addDatos: StateFlow<List<AddInfo>> = _addDatos

    init {
        _addDatos.value = listOf(HED, HEN, Voladuras, HEF)
    }

    fun setPlusVoladuras(contexto: Context): String{
        val fecha = FuncAux().strFechaCortaFromCalendar(Calendar.getInstance())

        return setPlusVoladuraUseCase(contexto, fecha, "0.5")
    }


}