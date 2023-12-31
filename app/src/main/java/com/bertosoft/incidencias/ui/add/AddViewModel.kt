package com.bertosoft.incidencias.ui.add

import androidx.lifecycle.ViewModel
import com.bertosoft.incidencias.domain.model.AddInfo
import com.bertosoft.incidencias.domain.model.AddInfo.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(): ViewModel() {

    private var _addDatos = MutableStateFlow<List<AddInfo>>(emptyList())
    val addDatos: StateFlow<List<AddInfo>> = _addDatos

    init {
        _addDatos.value = listOf(HED, HEN, HEF, Voladuras)
    }


}