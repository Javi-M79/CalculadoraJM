package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import com.example.calculadora.databinding.ActivityMainBinding


//IMPLEMENTAMOS INTERFACE OnClickListener y creamos el metodo mas abajo.

class MainActivity : AppCompatActivity(), OnClickListener {

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
    private var textoPantalla: String = ""
//    private lateinit var op1: Int
//    private lateinit var op2: Int
//    private lateinit var suma: Int
//    private lateinit var division: Double
//    private lateinit var mult: Int
//    private lateinit var porcentaje: Int
//    private lateinit var resta: Int

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


        binding.botonSuma.setOnClickListener(this)
        binding.botonResta.setOnClickListener(this)
        binding.botonDividir.setOnClickListener(this)
        binding.botonMultipilcar.setOnClickListener(this)
        binding.botonPorcentaje.setOnClickListener(this)
        binding.botonReset.setOnClickListener(this)
        binding.botonBorrar.setOnClickListener(this)
        binding.botonIgual.setOnClickListener(this)
        binding.botonCero.setOnClickListener(this)
        binding.botonUno.setOnClickListener(this)
        binding.botonDos.setOnClickListener(this)
        binding.botonTres.setOnClickListener(this)
        binding.botonCuatro.setOnClickListener(this)
        binding.botonCinco.setOnClickListener(this)
        binding.botonSeis.setOnClickListener(this)
        binding.botonSiete.setOnClickListener(this)
        binding.botonOcho.setOnClickListener(this)
        binding.botonNueve.setOnClickListener(this)
        binding.botonHistorial.setOnClickListener(this)

        //Con this, llamamos a la funcion de la interface.//

    }


    //Metodo de la Interface OnClickListener.
    override fun onClick(v: View?) {

        when (v?.id) {

            binding.botonCero.id -> {
                binding.textoPantalla.text="0"
            }

            binding.botonUno.id -> {
                binding.textoPantalla.text="1"
            }

            binding.botonDos.id -> {
                binding.textoPantalla.text="2"
            }

            binding.botonTres.id -> {
                binding.textoPantalla.text="3"
            }

            binding.botonCuatro.id -> {
                binding.textoPantalla.text="4"
            }

            binding.botonCinco.id -> {
                binding.textoPantalla.text="5"
            }

            binding.botonSeis.id -> {
                binding.textoPantalla.text="6"
            }

            binding.botonSiete.id -> {
                binding.textoPantalla.text="7"
            }

            binding.botonCinco.id -> {
                binding.textoPantalla.text="8"
            }

            binding.botonNueve.id -> {
                binding.textoPantalla.text="9"
            }
        }

//        binding.textoPantalla.text=binding.botonCero.toString()


    }
}