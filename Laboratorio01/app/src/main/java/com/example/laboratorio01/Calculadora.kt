package com.example.laboratorio01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class Calculadora : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                Datos(modifier = Modifier.padding(innerPadding))
                Suma(3, 2, modifier = Modifier.padding(top =  80.dp))
                Restar(3, 2, modifier = Modifier.padding(top = 100.dp))
                Multiplicar(3, 2, modifier = Modifier.padding(top = 120.dp))
                Dividir(3,2, modifier = Modifier.padding(top = 140.dp))
            }
        }
    }
}
@Composable
fun Suma(x: Int,y: Int, modifier: Modifier = Modifier) {
    var resultado= x+y;
    Text(
        text = "La suma es $resultado",
        modifier = modifier
    )
}
@Composable
fun Restar(x: Int, y:Int, modifier: Modifier = Modifier){
    var resultado= x-y;
    Text(
        text = "La resta es $resultado",
        modifier = modifier
    )
}
@Composable
fun Multiplicar(x: Int, y:Int, modifier: Modifier = Modifier){
    var resultado= x*y;
    Text(
        text = "La multiplicacion es $resultado",
        modifier = modifier
    )
}
@Composable
fun Dividir(x: Int, y:Int, modifier: Modifier = Modifier){
    if (y!=0){
        var resultado= x/y;
        Text(
            text = "La division es $resultado",
            modifier = modifier
        )
    }
    else(
        Text( text = "No se peude dividir entre 0",
        modifier = modifier)
    )
    }
@Composable
fun Datos(modifier: Modifier = Modifier){
    val marca = "La marca de su calculadora es MASIO"
    val vida = "\n Su calculadora tiene estimado 3 años de vida"
    var precio = "\n Su calculadora tiene un precio de $10 "
    val numero ="\n Los numeros a usar son 2 y 3\n"
    Text(
        text = marca + vida + precio + numero,
        modifier = modifier
    )

}

