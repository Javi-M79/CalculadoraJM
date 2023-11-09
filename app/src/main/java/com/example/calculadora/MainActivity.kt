package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.calculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , OnClickListener{ //IMPLEMENTAMOS INTERFACE OnClickListener y creamos el metodo mas abajo.

    /*
    CREAMOS LAS VARIABLES
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
    private lateinit var boton_igual: Button*/


//    Vincular el fichero grafico. Implementar ViewBinding en build.gradle(module:app) con este codigo antes de las dependencias
//     viewBinding {
//            enable = true
//        }

    private lateinit var binding: ActivityMainBinding //En esta variable creamos el fichero grafico de la mainActivity que es de tipo ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Cogemos el fichero y lo rellenamos con el metodo "inflate"
        binding =
            ActivityMainBinding.inflate(layoutInflater)//Nombre de la clase + metodo = (variable LayoutInflater)
        setContentView(binding.root)

        /*TODO EL CODIGO DE ARRIBA SE DEBE REPETIR POR NORMA
        -  Crear variable para el ActivityMain de tipo ActivityMainBinding
        - Rellenar fichero
        -  Usar la clase serContentView con la raiz de la variable Binding como parametro. Con root le estamos diciendo que mire lo mas arriba posible. Normalmente desde el linearLayout, etc..

        */

        //Si usamos binding. nos apareceran todos los elementos que hemos creado en la parte grafica.

        binding.botonBorrar.setOnClickListener(this)//Con this, llamamos a la funcion de la interface.
        binding.botonCero
        binding.botonDividir


        //

    }


    //Metodo de la Interface OnClickListener.
    override fun onClick(v: View?) {

    }
}