package com.bertosoft.incidencias.ui.detalleadd

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import com.bertosoft.incidencias.R
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.databinding.ActivityDetalleAddBinding
import com.bertosoft.incidencias.domain.model.AddEnumModel.*
import com.bertosoft.incidencias.domain.model.DetalleAddInfo
import com.bertosoft.incidencias.ui.detalleadd.adapter.DetalleAddAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale


@AndroidEntryPoint
class DetalleAddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalleAddBinding
    private lateinit var detalleAddAdapter: DetalleAddAdapter
    private val detalleAddViewModel: DetalleAddViewModel by viewModels()
    private val args: DetalleAddActivityArgs by navArgs()
    private lateinit var respuesta: String
    private lateinit var cantidad: String
    private lateinit var fecha: Calendar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalleAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()

        //
        // Metodos setOnClickListener
        //
        binding.tvFecha.setOnClickListener {
            val listener =
                DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                    fecha.set(Calendar.YEAR, year)
                    fecha.set(Calendar.MONTH, monthOfYear)
                    fecha.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                    binding.tvFecha.setText(FuncAux().strFechaLargaFromCalendar(fecha))
                }

            DatePickerDialog(
                this, listener,
                fecha.get(Calendar.YEAR),
                fecha.get(Calendar.MONTH),
                fecha.get(Calendar.DAY_OF_MONTH)
            ).show()
        }
    }

    private fun initUi() {
        fecha = Calendar.getInstance()
        initTextos()
        initRv()
        initUiState()
    }

    private fun initTextos() {
        binding.tvToolbar.text = args.seleccion.toString()
        binding.tvFecha.text = FuncAux().strFechaLargaFromCalendar(fecha)
    }

    private fun initRv() {
        detalleAddAdapter = DetalleAddAdapter(onItemSeleccionado = {
            val dcantidad: Double = when (it) {
                DetalleAddInfo.uno -> 1.0
                DetalleAddInfo.uno_medio -> 1.5
                DetalleAddInfo.dos -> 2.0
                DetalleAddInfo.dos_medio -> 2.5
                DetalleAddInfo.tres -> 3.0
                DetalleAddInfo.tres_medio -> 3.5
                DetalleAddInfo.cuatro -> 4.0
                DetalleAddInfo.cuatro_medio -> 4.5
                DetalleAddInfo.cinco -> 5.0
                DetalleAddInfo.cinco_medio -> 5.5
                DetalleAddInfo.seis -> 6.0
                DetalleAddInfo.seis_medio -> 6.5
            }
            cantidad = dcantidad.toString()
            //
            // Tenemos la cantidad, debemos de guardar la incidencia
            //
            guardarIncidencia()
            cerrar()
        })
        binding.rvTeclado.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = detalleAddAdapter
        }
    }

    private fun cerrar() {
        Toast.makeText(this, respuesta, Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun guardarIncidencia() {
        val contexto = this
        val incidencia = args.seleccion
        val fechaIncidencia = FuncAux().strFechaCortaFromCalendar(fecha)

        respuesta = detalleAddViewModel.setHoras(contexto, fechaIncidencia, incidencia, cantidad)
    }

    private fun initUiState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                detalleAddViewModel.datos.collect {
                    //
                    // Ha habido cambios en Datos
                    //
                    detalleAddAdapter.refrescaLista(it)
                }
            }
        }
    }

}