package com.bertosoft.incidencias.data.repositorio

import com.bertosoft.incidencias.R
import com.bertosoft.incidencias.data.database.AdminDbHelper
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.data.model.ModeloHorasData
import com.bertosoft.incidencias.data.model.ModeloIncidencias
import com.bertosoft.incidencias.domain.model.AddEnumModel
import com.bertosoft.incidencias.domain.repositorio.RepositorioHorasDomain
import javax.inject.Inject

class RepositorioHoras @Inject constructor(private  val funcAux: FuncAux): RepositorioHorasDomain {

    private var strSql: String? = null

    override fun setHoras(datos: ModeloHorasData): String {
        //
        // Recibimos lo valores ya codificados y los grabamos
        //
        var respuesta = ""
        var incidencias = ModeloIncidencias("", "", "", "")

        when(datos.incidencia){
            AddEnumModel.HED -> {
                incidencias = ModeloIncidencias( datos.cantidad,  "", "", "")
                respuesta = datos.contexto.getString(R.string.add_hed)
            }
            AddEnumModel.HEN -> {
                incidencias = ModeloIncidencias("",datos.cantidad,  "", "")
                respuesta = datos.contexto.getString(R.string.add_hen)
            }
            AddEnumModel.HEF -> {
                incidencias = ModeloIncidencias( "", "", datos.cantidad, "")
                respuesta = datos.contexto.getString(R.string.add_hef)
            }
            else -> {}
        }

        val idRegistro = funcAux.existeRegistroFecha(datos.contexto, datos.fecha)

        val adminDbHlper = AdminDbHelper(datos.contexto, null)
        val sqlWriteDb = adminDbHlper.writableDatabase
        if(idRegistro < 0){
            strSql = "INSERT INTO Incidencias (Fecha, " +
                    "Hed, " +
                    "Hen, " +
                    "Hef, " +
                    "Voladuras) VALUES ('${datos.fecha}'," +
                    "'${incidencias.hed}'," +
                    "'${incidencias.hen}'," +
                    "'${incidencias.hef}'," +
                    "'${incidencias.voladuras}');"
        }
        else{
            incidencias.voladuras = funcAux.leerVoladurasFromId(datos.contexto, idRegistro)

            strSql = "UPDATE Incidencias SET Fecha = '" +
                    "${datos.fecha}', Hed = '" +
                    "${incidencias.hed}', Hen = '" +
                    "${incidencias.hen}', Hef = '" +
                    "${incidencias.hef}', Voladuras = '" +
                    "${incidencias.voladuras}' WHERE _id = $idRegistro;"

            respuesta = datos.contexto.getString(R.string.update_horas)
        }
        sqlWriteDb.execSQL(strSql)

        sqlWriteDb.close()
        adminDbHlper.close()

        return respuesta
    }
}