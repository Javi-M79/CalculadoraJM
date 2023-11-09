package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //CREAMOS LAS VARIABLES

    private lateinit var texto_pantalla: TextView
    private lateinit var boton_reset: Button
    private lateinit var boton_borrar: Button
    private lateinit var boton_dividir: Button
    private lateinit var boton_siete: Button
    private lateinit var boton_ocho: Button
    private lateinit var boton_nueve: Button
    private lateinit var boton_multipilcar: Button
    private lateinit var boton_cuatro: Button
    private lateinit var boton_cinco: Button
    private lateinit var boton_seis: Button
    private lateinit var boton_suma: Button
    private lateinit var boton_uno: Button
    private lateinit var boton_dos: Button
    private lateinit var boton_tres: Button
    private lateinit var boton_resta: Button
    private lateinit var boton_historial: Button
    private lateinit var boton_cero: Button
    private lateinit var boton_igual: Button


    //Importar fichero grafico



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //UNIMOS LA PARTE GRAFICA CON PARTE LOGICA
        setContentView(R.layout.activity_main)
    }
}