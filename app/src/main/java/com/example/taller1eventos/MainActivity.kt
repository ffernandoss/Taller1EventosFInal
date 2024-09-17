package com.example.taller1eventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1eventos.ui.theme.Taller1EventosTheme
import java.util.Calendar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Taller1EventosTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val greetingMessage = mensajeDeBienvenida()
                    Greeting(
                        name = greetingMessage,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun pantallaPrincipal() {
    Taller1EventosTheme {
       val mensaje= mensajeDeBienvenida(modifier=Modifier.fillMaxSize().padding(16.dp))
        Text(text = mensaje)
    }
}
    
@Composable
private fun mensajeDeBienvenida(modifier: Modifier=Modifier): String {
    val calendar = Calendar.getInstance()
    val hour = calendar.get(Calendar.HOUR_OF_DAY)
   if (hour in 6..12) {
        return "Buenos días"
    } else if (hour in 13..19) {
        return "Buenas tardes"
    } else {
        return "Buenas noches"
    }
   }

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = name,
        modifier = modifier
    )
}
