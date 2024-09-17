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

class ActividadPrincipal : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Taller1EventosTheme {
                SegundaPantalla()
            }
        }
    }
}

@Composable
fun SegundaPantalla() {
    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf("") }
    var showDialog by remember { mutableStateOf(false) }
    val context = LocalContext.current

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("OK")
                }
            },
            title = { Text("Error") },
            text = { Text("Debe ingresar un nombre") }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Yellow)
            .padding(16.dp)
    ) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingrese su nombre") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { savedName = name },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Guardar Nombre")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Nombre guardado: $savedName",
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                if (savedName.isNotEmpty()) {
                    val intent = Intent(context, PantallaConfiguracion::class.java)
                    context.startActivity(intent)
                } else {
                    showDialog = true
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Ir a Tercera Pantalla")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SegundaPantallaPreview() {
    Taller1EventosTheme {
        SegundaPantalla()
    }
}