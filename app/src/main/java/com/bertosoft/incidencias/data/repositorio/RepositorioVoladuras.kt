package com.bertosoft.incidencias.data.repositorio

import com.bertosoft.incidencias.R
import com.bertosoft.incidencias.data.database.AdminDbHelper
import com.bertosoft.incidencias.data.model.ModeloVoladurasData
import com.bertosoft.incidencias.data.funciones.FuncAux
import com.bertosoft.incidencias.domain.repositorio.RepositorioVoladurasDomain
import javax.inject.Inject

class RepositorioVoladuras @Inject constructor(private  val funcAux: FuncAux): RepositorioVoladurasDomain {

    private var strSql: String? = null

    override fun setPlusVoladuras(datos: ModeloVoladurasData): String{
        //
        // Recibimos lo valores ya codificados y los grabamos
        //
        val respuesta: String
        val adminDbHlper = AdminDbHelper(datos.contexto, null)
        val sqlWriteDb = adminDbHlper.writableDatabase

        val idRegistro = funcAux.existeRegistroFecha(datos.contexto, datos.fecha)

        if(idRegistro < 0){
            strSql = "INSERT INTO Incidencias (Fecha, " +
                    "Voladuras) VALUES ('${datos.fecha}'," +
                    "'${datos.cantidad}');"
            respuesta = datos.contexto.getString(R.string.add_voladuras)
        }
        else{
            strSql = "UPDATE Incidencias SET Fecha = '" +
                    "${datos.fecha}', Voladuras = '" +
                    "${datos.cantidad}' WHERE _id = $idRegistro;"

            respuesta = datos.contexto.getString(R.string.update_voladuras)
        }
        sqlWriteDb.execSQL(strSql)

        sqlWriteDb.close()
        adminDbHlper.close()

        return respuesta
    }









}