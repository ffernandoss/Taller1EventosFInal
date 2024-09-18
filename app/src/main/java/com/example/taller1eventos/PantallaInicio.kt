package com.example.taller1eventos

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1eventos.ui.theme.Taller1EventosTheme
import java.util.Calendar

class PantallaInicio : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1EventosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val mensaje = mensajeDeBienvenida()
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray)
                            .padding(innerPadding)
                            .wrapContentSize()
                    ) {
                        Text(
                            text = mensaje,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                        )
                        Spacer(modifier = Modifier.height(25.dp))
                        Button(
                            onClick = {
                                val intent = Intent(this@PantallaInicio, ActividadPrincipal::class.java)
                                startActivity(intent)
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text("Continuar")
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun pantallaPrincipal() {
    Taller1EventosTheme {
        val mensaje = mensajeDeBienvenida()
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.LightGray)
                .wrapContentSize()
        ) {
            Text(
                text = mensaje,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text("Continuar")
            }
        }
    }
}

@Composable
private fun mensajeDeBienvenida(): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 6..12 -> "Buenos días"
        in 13..19 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}