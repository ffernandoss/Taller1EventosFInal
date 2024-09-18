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

class PantallaConfiguracion : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1EventosTheme {
                ConfiguracionPantalla()
            }
        }
    }
}

@Composable
fun ConfiguracionPantalla() {
    var backgroundColor by remember { mutableStateOf(Color.White) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp)
    ) {
        Text("pulsa el boton para cambiar de color", style = MaterialTheme.typography.bodyLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = { backgroundColor = Color.Red },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Red)
            ) {
                Text("Rojo")
            }
            Button(onClick = { backgroundColor = Color.Green },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                Text("Verde")
            }
            Button(onClick = { backgroundColor = Color.Blue },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue)) {
                Text("Azul")
            }
            Button(onClick = { backgroundColor = Color.Yellow },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow)) {
                Text("Amarillo")
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

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

@Preview(showBackground = true)
@Composable
fun ConfiguracionPantallaPreview() {
    Taller1EventosTheme {
        ConfiguracionPantalla()
    }
}