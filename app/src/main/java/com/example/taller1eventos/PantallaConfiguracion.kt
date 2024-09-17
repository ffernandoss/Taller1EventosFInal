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
                Text("Pantalla de Configuración")
            }
        }
    }
}

@Preview
@Composable
fun PantallaConfiguracionPreview() {
    Taller1EventosTheme {

    }
}