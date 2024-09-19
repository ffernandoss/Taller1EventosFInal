package com.example.taller1eventos

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<ActividadPrincipal>()

    @Test
    fun testGuardarNombre() {
        // Ingresar un nombre en el TextField
        composeTestRule.onNodeWithText("Ingrese su nombre").performTextInput("Juan")

        // Hacer clic en el botón "Guardar Nombre"
        composeTestRule.onNodeWithText("Guardar Nombre").performClick()

        // Verificar que el nombre guardado se muestra correctamente
        composeTestRule.onNodeWithText("Nombre guardado: Juan").assertIsDisplayed()
    }

    @Test
    fun testIrATerceraPantallaSinNombre() {
        // Hacer clic en el botón "Ir a Tercera Pantalla" sin ingresar un nombre
        composeTestRule.onNodeWithText("Ir a Tercera Pantalla").performClick()

        // Verificar que se muestra el diálogo de error
        composeTestRule.onNodeWithText("Debe ingresar un nombre").assertIsDisplayed()
    }

    @Test
    fun testIrATerceraPantallaConNombre() {
        // Ingresar un nombre en el TextField
        composeTestRule.onNodeWithText("Ingrese su nombre").performTextInput("Juan")

        // Hacer clic en el botón "Guardar Nombre"
        composeTestRule.onNodeWithText("Guardar Nombre").performClick()

        // Hacer clic en el botón "Ir a Tercera Pantalla"
        composeTestRule.onNodeWithText("Ir a Tercera Pantalla").performClick()

        // Verificar que se inicia la actividad PantallaConfiguracion
        // Nota: Esto puede requerir una configuración adicional para verificar el cambio de actividad
    }





}