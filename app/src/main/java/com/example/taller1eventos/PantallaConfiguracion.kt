package com.example.taller1eventos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1eventos.ui.theme.Taller1EventosTheme

// Clase principal de la actividad
class PantallaConfiguracion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1EventosTheme {
                ConfiguracionPantalla() // Llama a la función composable para mostrar la pantalla de configuración
            }
        }
    }
}

// Función composable que define la pantalla de configuración
@Composable
fun ConfiguracionPantalla() {
    var backgroundColor by remember { mutableStateOf(Color.White) } // Estado para almacenar el color de fondo
    val context = LocalContext.current // Contexto actual

    // Columna que contiene todos los elementos de la pantalla
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        // Texto que indica al usuario que pulse el botón para cambiar de color
        Text("pulsa el boton para cambiar de color", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos

        // Fila que contiene los botones para cambiar el color de fondo
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Botón para cambiar el color de fondo a rojo
            Button(onClick = { backgroundColor = Color.Red },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Rojo")
            }
            // Botón para cambiar el color de fondo a verde
            Button(onClick = { backgroundColor = Color.Green },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                Text("Verde")
            }
            // Botón para cambiar el color de fondo a azul
            Button(onClick = { backgroundColor = Color.Blue },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                Text("Azul")
            }
            // Botón para cambiar el color de fondo a amarillo
            Button(onClick = { backgroundColor = Color.Yellow },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Text("Amarillo")
            }
        }

        Spacer(modifier = Modifier.height(16.dp)) // Espacio entre elementos

        // Botón para volver a la pantalla de inicio
        Button(
            onClick = {
                val intent = Intent(context, PantallaInicio::class.java)
                context.startActivity(intent)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver a la Pantalla de Inicio")
        }
    }
}

// Función de vista previa para la pantalla de configuración
@Preview(showBackground = true)
@Composable
fun ConfiguracionPantallaPreview() {
    Taller1EventosTheme {
        ConfiguracionPantalla()
    }
}