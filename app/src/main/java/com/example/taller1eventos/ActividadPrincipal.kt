package com.example.taller1eventos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taller1eventos.ui.theme.Taller1EventosTheme

class SecondActivity : ComponentActivity() {
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
    Text(text = "Esta es la segunda ventana",
    modifier=Modifier.fillMaxSize().background(Color.Yellow))

}

@Preview(showBackground = true)
@Composable
fun SecondScreenPreview() {
    Taller1EventosTheme {
        SegundaPantalla()
    }
}