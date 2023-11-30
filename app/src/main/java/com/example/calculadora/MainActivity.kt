package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.calculadora.databinding.ActivityMainBinding


//IMPLEMENTAMOS INTERFACE OnClickListener y creamos el metodo mas abajo.

class MainActivity : AppCompatActivity(), OnClickListener {


    private lateinit var binding: ActivityMainBinding //En esta variable creamos el fichero grafico de la mainActivity que es de tipo ActivityMainBinding

    private var pantalla = "0"
    private var botonPulsado = false;
    private var op1 = 0
    private var op2 = 0
    private var resultado = 0
    private var operacion: String = ""
//    private lateinit var ultimaOperacion: Any
//    private var pantallaSecundaria = ""

    //RECUPERAR DATOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pantalla = savedInstanceState?.getString("pantalla") ?: ""
//        pantallaSecundaria = savedInstanceState?.getString("pantallaSecudaria") ?: ""
//        binding.textoPantalla.text = pantalla
//        binding.textoSecundario.text = pantallaSecundaria.toString()

        /*TODO EL CODIGO DE ARRIBA SE DEBE REPETIR POR NORMA
        RESUMEN:
        -  Crear variable para el binding de tipo ActivityMainBinding: private lateinit var binding: ActivityMainBinding
        - Rellenar fichero: binding = ActivityMainBinding.inflate(layoutInflater)
        -  Usar la clase setContentView con Binding como parametro. Con root le estamos diciendo que mire lo mas arriba posible del archivo grafico. Normalmente desde el linearLayout, etc..

        */

        val botones = arrayOf(
            binding.botonSuma,
            binding.botonResta,
            binding.botonDividir,
            binding.botonMultipilcar,
//            binding.botonPorcentaje,
            binding.botonReset,
            binding.botonIgual,
            binding.botonCero,
            binding.botonUno,
            binding.botonDos,
            binding.botonTres,
            binding.botonCuatro,
            binding.botonCinco,
            binding.botonSeis,
            binding.botonSiete,
            binding.botonOcho,
            binding.botonNueve

        )


        botones.forEach { it.setOnClickListener(this) }


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("pantalla", pantalla)
//        outState.putString("pantallaSecundaria",pantallaSecundaria
//        )//No guarda bien el resultado. Comprobar.
    }

    override fun onClick(v: View?) {

        when (v?.id) {


            //COMPORTAMIENTO DE BOTONES NUMERICOS// PROBAR COGIENDO EL .TEXT DE TODOS

//CREAR UN FOREACH PARA QUE COJA EL TEXTO DE CADA BOTON?? USAR LA VARIABLE botones??


            binding.botonCero.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonCero.text.toString()
                    botonPulsado = false
                } else {
                    pantalla += binding.botonCero.text.toString()

                }
            }

            binding.botonUno.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonUno.text.toString()
                    botonPulsado = false
                } else {
                    pantalla += binding.botonUno.text.toString()
                }
            }

            binding.botonDos.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonDos.text.toString()
                    botonPulsado = false
                } else {
                    pantalla += binding.botonDos.text.toString()
                }
            }


            binding.botonTres.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonTres.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonTres.text.toString()
                }
            }

            binding.botonCuatro.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonCuatro.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonCuatro.text.toString()
                }
            }

            binding.botonCinco.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonCinco.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonCinco.text.toString()
                }
            }

            binding.botonSeis.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonSeis.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonSeis.text.toString()
                }
            }

            binding.botonSiete.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonSiete.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonSiete.text.toString()
                }
            }

            binding.botonOcho.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonOcho.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonOcho.text.toString()
                }
            }

            binding.botonNueve.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonNueve.text.toString()
                    botonPulsado = false

                } else {
                    pantalla += binding.botonNueve.text.toString()
                }
            }


            binding.botonReset.id -> {
                pantalla = "0"
                botonPulsado = true
            }

            //COMPORTAMIENTO BOTONES DE OPERACION//

            binding.botonSuma.id -> {

                botonesOperacion("+")
                operacion = "suma"

            }

            binding.botonResta.id -> {

                botonesOperacion("-")
                operacion = "resta"
            }

            binding.botonMultipilcar.id -> {
                botonesOperacion("×")
                operacion = "multiplicacion"
            }

            binding.botonDividir.id -> {
                botonesOperacion("÷")//alt + 246 simbolo division.
                operacion = "division"
            }
//
////            binding.botonPorcentaje.id -> {
////
////                botonesOperacion("÷")
////                calculoPorcentaje(operacion)
////
//
//            }

            binding.botonIgual.id -> {

                accion(operacion)

            }

        }

        binding.textoPantalla.text = pantalla
//        binding.textoSecundario.text = pantallaSecundaria
    }

    fun botonesOperacion(simbolo: String) {
        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {
            op1 = pantalla.toDouble().toInt()
//            pantallaSecundaria = "$op1$simbolo"
            botonPulsado = true
        }
    }

    fun accion(operacion: String) {

        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {

            op2 = pantalla.toInt()
//            pantallaSecundaria += pantalla
            botonPulsado = true
            op1=op2

            when (operacion) {

                "suma" -> {
                    pantalla = (op1 + op2).toInt().toString()
                }

                "resta" -> {
                    pantalla = (op1 - op2).toString()
                }

                "multiplicacion" -> {
                    pantalla = (op1 * op2).toString()
                }

                "division" -> {
                    if (op2 != 0) {
                        pantalla = (op1 / op2.toDouble()).toString()
                    } else {//
                        Toast.makeText(this, "Division por 0 no permitida", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

            }
            binding.textoPantalla.text = pantalla
        }


    }


    fun calculoPorcentaje(operacion: String) {

        //ERROR JAVA LANG. SEGURAMENTE PORLA CONVERSION DE TIPOS.

        when (operacion) {
            "suma" -> {
                resultado = op1 + ((op1 * op2) / 100)
            }

            "resta" -> {
                resultado = op1 - ((op1 * op2) / 100)
            }

            "multiplicacion " -> {
                resultado = op1 * ((op1 * op2) / 100)
            }

            "division" -> {
                resultado = op1 / ((op1 * op2) / 100)
            }

        }


    }


}
























