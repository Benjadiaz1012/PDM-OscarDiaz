package com.example.laboratorio01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf

var eleccion = mutableStateOf("")
var detalle = informacion("Dell", "8GB", "512GB", "Windows 10")

data class informacion(
    var marca: String,
    var ram: String,
    var almacenamiento: String,
    var sistema: String,
    var encendida: Boolean = false
){
    fun encender(): String {
        return if (!encendida) {
            encendida = true
            "Computadora encendida"
        } else {
            "Ya está encendida"
        }
    }

    fun apagar(): String {
        return if (encendida) {
            encendida = false
            "Computadora apagada"
        } else {
            "Ya está apagada"
        }
    }

    fun estado(): String {
        return "Marca: $marca\nRAM: $ram\nAlmacenamiento: $almacenamiento\nSistema: $sistema\nEstado: ${if (encendida) "Encendida" else "Apagada"}"
    }

    fun cambiarRam(nueva: String) {
        ram = nueva
    }

    fun cambiarAlmacenamiento(nuevo: String) {
        almacenamiento = nuevo
    }
}

data class Programa(var nombre: String)
class Computadora : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = androidx.compose.ui.Modifier.fillMaxSize()) { innerPadding ->
                Computadora(modifier = Modifier.padding(innerPadding))
            }
        }
    }
}
@Composable
fun Computadora(modifier: Modifier = Modifier){

    val programas = listOf(
        Programa("Notion 2026"),
        Programa("Facebook 2024"),
        Programa("VSCode 2026"),
        Programa("Spotify 2023"),
        Programa("Chrome 2026")
    )

    var texto = "Escribe un número del 1 al 6"

    val menu = "MENU:\n" +
            "1. Estado de computadora\n" +
            "2. Encender computadora\n" +
            "3. Apagar computadora\n" +
            "4. Cambiar RAM\n" +
            "5. Cambiar Memoria\n" +
            "6. Programas\n\n" +
            "Ingrese una opción:"

    TextField(
        value = eleccion.value,
        onValueChange = { eleccion.value = it },
        modifier = modifier.padding(top = 20.dp)
    )

    val opcion = eleccion.value.toIntOrNull()

    when (opcion) {

        1 -> texto = detalle.estado()

        2 -> texto = detalle.encender()

        3 -> texto = detalle.apagar()

        4 -> {
            if (detalle.encendida) {
            detalle.cambiarRam("16GB")
            texto = "RAM cambiada a 16GB"
            } else {
                texto = "Primero debe encender la computadora"
            }
        }

        5 -> {
            if (detalle.encendida) {
                detalle.cambiarAlmacenamiento("1TB")
                texto = "Memoria cambiada a 1TB"
            } else {
                texto = "Primero debe encender la computadora"
            }
        }

        6 -> {
            if (detalle.encendida) {
            texto = ""
            for (programasCompletos in programas) {
                texto = texto + programasCompletos.nombre + "\n"
            }

            val programas2026 = programas.filter {
                it.nombre == "Notion 2026" ||
                        it.nombre == "VSCode 2026" ||
                        it.nombre == "Chrome 2026"
            }

            var textos = ""
            for (programasFiltrados in programas2026) {
                textos = textos + programasFiltrados.nombre + "\n"
            }

            texto = "Lista completa\n\n" + texto +
                    "\nLista 2026\n\n" + textos
            } else {
                texto = "Primero debe encender la computadora"
            }
        }

        else -> texto = "Ingrese una opción válida"

    }
    Text(
        text = menu +"\n\n"+ texto,
        modifier = modifier.padding(top = 100.dp)
    )
}