package com.example.taller1eventos

import android.content.Context
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PantallaConfiguracionTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<PantallaConfiguracion>()

    private lateinit var sharedPreferences: android.content.SharedPreferences

    @Before
    fun setUp() {
        sharedPreferences = composeTestRule.activity.getSharedPreferences("configuracion", Context.MODE_PRIVATE)
        sharedPreferences.edit().clear().apply()
    }

    @Test
    fun testCambiarColorFondoARojo() {
        // Hacer clic en el botón "Rojo"
        composeTestRule.onNodeWithText("Rojo").performClick()

        // Verificar que el color de fondo se ha guardado como rojo
        val savedColor = sharedPreferences.getInt("backgroundColor", Color.White.toArgb())
        assert(savedColor == Color.Red.toArgb())
    }

    @Test
    fun testCambiarColorFondoAVerde() {
        // Hacer clic en el botón "Verde"
        composeTestRule.onNodeWithText("Verde").performClick()

        // Verificar que el color de fondo se ha guardado como verde
        val savedColor = sharedPreferences.getInt("backgroundColor", Color.White.toArgb())
        assert(savedColor == Color.Green.toArgb())
    }

    @Test
    fun testMantenerColorFondoAlVolver() {
        // Cambiar el color de fondo a azul
        composeTestRule.onNodeWithText("Azul").performClick()

        // Reiniciar la actividad en el hilo principal
        composeTestRule.runOnUiThread {
            composeTestRule.activity.recreate()
        }

        // Verificar que el color de fondo se mantiene como azul
        val savedColor = sharedPreferences.getInt("backgroundColor", Color.White.toArgb())
        assert(savedColor == Color.Blue.toArgb())
    }
}