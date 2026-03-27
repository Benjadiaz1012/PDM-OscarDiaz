package com.example.laboratorio02

import androidx.compose.ui.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                val usuario: MutableState<String> = remember { mutableStateOf("") }
                val entries = remember { mutableStateListOf<String>() }
                Column(
                    modifier = Modifier
                        .height(800.dp)
                        .padding(innerPadding)
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    TextField(
                        label = { Text("Nombre") },
                        placeholder = { Text("Ingrese su nombre") },
                        value = usuario.value,
                        onValueChange = {
                            usuario.value = it
                        }
                    )
                    Button(
                        onClick = { entries.add(usuario.value) },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(65, 88, 206, 255)
                        )
                    ) { Text(text = "Guardar") }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(text = "Listado de nombres y posición en la lista")
                        Button(
                            onClick = { entries.clear() },
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(65, 88, 206, 255)
                            )
                        ) { Text(text = "Limpiar") }
                    }

                    NombresList(entries)
                }
            }
        }
    }

    @Composable
    fun NombresList(entries: MutableList<String>) {
        Box(
            modifier = Modifier
                .padding(30.dp)
                .border(
                    width = 2.dp,
                    color = Color(65, 88, 206, 255),
                    shape = RoundedCornerShape(8.dp)
                )
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                itemsIndexed(entries.toList()) { index, item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = item
                        )
                        Text(
                            text = (index + 1).toString()
                        )
                    }
                }
            }
        }
    }
}
