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


//    Vincular el fichero grafico. Implementar ViewBinding en build.gradle(module:app) con este codigo antes de las dependencias
//     viewBinding {
//            enable = true
//        }

    private lateinit var binding: ActivityMainBinding //En esta variable creamos el fichero grafico de la mainActivity que es de tipo ActivityMainBinding

    //    private var textoSecudario = ""//Probar a meter los valores introducidos en esta pantalla y mostrar el resultado antes del igual como en la calculadora samsung.
    private var pantalla = ""
    private var op1 = 0
    private var op2 = 0
    private var resultado = 0
    private var operacion: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Cogemos el fichero y lo rellenamos con el metodo "inflate"
        binding =
            ActivityMainBinding.inflate(layoutInflater)//Nombre de la clase + metodo = (variable LayoutInflater)
        setContentView(binding.root)

        /*TODO EL CODIGO DE ARRIBA SE DEBE REPETIR POR NORMA
        -  Crear variable para el binding de tipo ActivityMainBinding
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
//Crear el saveInstace para guardar datos del historial y para la pantalla en horizontal.

    //Metodo de la Interface OnClickListener.
    override fun onClick(v: View?) {

        when (v?.id) {

            binding.botonCero.id -> pantalla += "0"
            binding.botonUno.id -> pantalla += "1"
            binding.botonDos.id -> pantalla += "2"
            binding.botonTres.id -> pantalla += "3"
            binding.botonCuatro.id -> pantalla += "4"
            binding.botonCinco.id -> pantalla += "5"
            binding.botonSeis.id -> pantalla += "6"
            binding.botonSiete.id -> pantalla += "7"
            binding.botonOcho.id -> pantalla += "8"
            binding.botonNueve.id -> pantalla += "9"
            binding.botonReset.id -> pantalla = ""

            //EVENTOS EN BOTONES DE OPERACION//

            binding.botonSuma.id -> {
                op1 = pantalla.toInt()
                pantalla = ""
                operacion = "suma"
            }

            binding.botonResta.id -> {
                op1 = pantalla.toInt()
                pantalla = ""
                operacion = "resta"
            }

            binding.botonMultipilcar.id -> {
                op1 = pantalla.toInt()
                pantalla = ""
                operacion = "multiplicacion"
            }

            binding.botonDividir.id -> {
                op1 = pantalla.toInt()
                pantalla = ""
                operacion = "division"
            }

            binding.botonPorcentaje.id -> {

                op1 = pantalla.toInt()
                pantalla = ""
                operacion = "porcentaje"
            }

            binding.botonIgual.id -> {

                when (operacion) {

                    "suma" -> {
                        op2 = pantalla.toInt()
                        resultado = op1 + op2
                        pantalla = resultado.toString()
                        operacion = ""
                    }

                    "resta" -> {

                        op2 = pantalla.toInt()
                        resultado = op1 - op2
                        pantalla = resultado.toString()
                        operacion = ""
                    }

                    "multiplicacion" -> {

                        op2 = pantalla.toInt()
                        resultado = op1 * op2
                        pantalla = resultado.toString()
                        operacion = ""

                    }

                    "division" -> {

                        op2 = pantalla.toInt() //
                        //Evitar la division por cero.
                        if (op2 != 0) {
                            resultado = op1 / op2
                            pantalla = resultado.toString()
                            operacion = ""
                        } else {
                            pantalla = "Error"
                        }


                    }
                        //REVISAR OPERACION. DECIDIR SI USARLA AL PULSAR IGUAL O CUANDO PULSE EL BOTON PORCENTAJE COMO EN LA CALCULADORA.
                    "porcentaje" -> {

                        op2 = pantalla.toInt() //
                        resultado = (op2 / op1) * 100
                        pantalla = resultado.toString()
                        operacion = ""
                    }


                }


            }

        }
        binding.textoPantalla.text = pantalla
    }

}










