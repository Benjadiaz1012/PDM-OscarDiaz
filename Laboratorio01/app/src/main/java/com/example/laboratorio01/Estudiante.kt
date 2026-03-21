package com.example.laboratorio01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

data class listaEstudiante(
    var nombre: String,
    var carnet: String,
    var asignatura: String
)
class Estudiante : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = androidx.compose.ui.Modifier.fillMaxSize()) { innerPadding ->
                Lista(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
@Composable
 fun Lista(modifier: Modifier = Modifier){
    val ciclo01 = listOf(
        listaEstudiante("Juan", "00041923", "Dispositivos Moviles"),
        listaEstudiante("Marcos", "00016023", "Dispositivos Moviles"),
        listaEstudiante("Sam", "00067323", "Dispositivos Moviles"),
        listaEstudiante("Juana", "0085024", "Analisis Numerico"),
        listaEstudiante("Liliana", "0006523", "Analisis Numerico"),
        listaEstudiante("Fredi", "00056124", "Analisis Numerico"),
        listaEstudiante("Kathya", "00098122", "Analisis Numerico"),
    )
    var texto = ""
    for (estudiante in ciclo01) {
            texto = texto + "Nombre: ${estudiante.nombre}\n" +
                    "Carnet:  ${estudiante.carnet}\n" +
                    "Asignatura: ${estudiante.asignatura}\n\n"
    }
    val dispositivosMoviles = ciclo01.filter {
        it.asignatura == "Dispositivos Moviles"
    }
    var textos = ""
    for (estudiante in dispositivosMoviles) {
        textos = textos + "Nombre: ${estudiante.nombre}\n" +
                "Carnet:  ${estudiante.carnet}\n" +
                "Asignatura: ${estudiante.asignatura}\n\n"
        Text(text = "Lisa completa \n\n"+texto +"Lista de moviles\n\n"+ textos, modifier=modifier)
    }
}