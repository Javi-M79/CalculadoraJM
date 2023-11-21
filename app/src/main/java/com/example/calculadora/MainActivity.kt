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


    /*    Vincular el fichero grafico. Implementar ViewBinding en build.gradle(module:app) con este codigo antes de las dependencias
             viewBinding {
                enable = true
                }*/

    private lateinit var binding: ActivityMainBinding //En esta variable creamos el fichero grafico de la mainActivity que es de tipo ActivityMainBinding
    private var pantallaSecudaria = ""
    private var pantalla = ""
    private var botonPulsado = false;
    private var op1 = 0
    private var op2 = 0
    private var operacion: String = ""
    private lateinit var ultimaOperacion: Any


    //RECUPERAR DATOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =
            ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        pantalla = savedInstanceState?.getString("pantalla") ?: ""
        pantallaSecudaria = savedInstanceState?.getString("pantallaSecudaria") ?: ""
        binding.textoPantalla.text = pantalla.toString()
        binding.textoSecundario.text = pantallaSecudaria.toString()

        /*TODO EL CODIGO DE ARRIBA SE DEBE REPETIR POR NORMA
        RESUMEN:
        -  Crear variable para el binding de tipo ActivityMainBinding: private lateinit var binding: ActivityMainBinding
        - Rellenar fichero: binding = ActivityMainBinding.inflate(layoutInflater)
        -  Usar la clase setContentView con Binding como parametro. Con root le estamos diciendo que mire lo mas arriba posible del archivo grafico. Normalmente desde el linearLayout, etc..

        */


        //Crear Array de los botones y recorrerlos con un foreach para asignarles el metodo setOnclickListener(this)


        val botones = arrayOf(
            binding.botonSuma,
            binding.botonResta,
            binding.botonDividir,
            binding.botonMultipilcar,
            binding.botonPorcentaje,
            binding.botonReset,
            binding.botonIgual,
            binding.botonPorcentaje,
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


//        binding.botonSuma.setOnClickListener(this)
//        binding.botonResta.setOnClickListener(this)
//        binding.botonDividir.setOnClickListener(this)
//        binding.botonMultipilcar.setOnClickListener(this)
//        binding.botonPorcentaje.setOnClickListener(this)
//        binding.botonReset.setOnClickListener(this)
////        binding.botonBorrar.setOnClickListener(this)
//        binding.botonIgual.setOnClickListener(this)
//        binding.botonCero.setOnClickListener(this)
//        binding.botonUno.setOnClickListener(this)
//        binding.botonDos.setOnClickListener(this)
//        binding.botonTres.setOnClickListener(this)
//        binding.botonCuatro.setOnClickListener(this)
//        binding.botonCinco.setOnClickListener(this)
//        binding.botonSeis.setOnClickListener(this)
//        binding.botonSiete.setOnClickListener(this)
//        binding.botonOcho.setOnClickListener(this)
//        binding.botonNueve.setOnClickListener(this)
////        binding.botonHistorial.setOnClickListener(this)

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("pantalla", pantalla)
        outState.putString("pantallaSecundaria", pantallaSecudaria)
    }


    override fun onClick(v: View?) {


        when (v?.id) {

            //COMPORTAMIENTO DE BOTONES NUMERICOS// PROBAR COGIENDO EL .TEXT DE TODOS

//CREAR UN FOREACH PARA QUE COJA EL TEXTO DE CADA BOTON?? USAR LA VARIABLE botonesnumericos??


            binding.botonCero.id -> {
                if (botonPulsado) {
                    pantalla = "0"
                } else {
                    pantalla += "0"
                }
            }

            binding.botonUno.id -> {
                if (botonPulsado) {
                    pantalla = "1"
                } else {
                    pantalla += "1"
                }
            }

            binding.botonDos.id -> {
                if (botonPulsado) {
                    pantalla = "2"
                } else {
                    pantalla += "2"
                }
            }


            binding.botonTres.id -> {
                if (botonPulsado) {
                    pantalla = "3"

                } else {
                    pantalla += "3"
                }
            }

            binding.botonCuatro.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonCuatro.text.toString()

                } else {
                    pantalla += binding.botonCuatro.text.toString()
                }
            }

            binding.botonCinco.id -> {
                if (botonPulsado) {
                    pantalla = "5"

                } else {
                    pantalla += "5"
                }
            }

            binding.botonSeis.id -> {
                if (botonPulsado) {
                    pantalla = "6"

                } else {
                    pantalla += "6"
                }
            }

            binding.botonSiete.id -> {
                if (botonPulsado) {
                    pantalla = "7"

                } else {
                    pantalla += "7"
                }
            }

            binding.botonOcho.id -> {
                if (botonPulsado) {
                    pantalla = "8"

                } else {
                    pantalla += "8"
                }
            }

            binding.botonNueve.id -> {
                if (botonPulsado) {
                    pantalla = "9"

                } else {
                    pantalla += "9"
                }
            }

            binding.botonReset.id -> {
                pantalla = ""; pantallaSecudaria = ""
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
                botonesOperacion("x")
                operacion = "multiplicacion"
            }

            binding.botonDividir.id -> {
                botonesOperacion("÷")//alt + 246 simbolo division.
                operacion = "division"
            }
            /*DECIDIR SU USO.
             SI MUESTRA SIMBOLO EN SECUNDARIA O MUESTRA EL RESULTADO DE LA OPERACION AL PULSARLO*/

//            binding.botonPorcentaje.id -> {
//
//
//                if (pantalla.isEmpty()) {
//
//                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
//                } else {
//
//                    when (operacion) {
//
//                        "suma" -> {
//
//                            op2 = pantalla.toInt()
//                            pantalla = op1 + (op1 * op2 / 100)
//                            resultado.toString()
//                            operacion = ""
//
//
//                        }
//
//                        "resta" -> {
//
//                            op2 = pantalla.toInt()
//                            resultado = op1 - op2
//                            pantalla = resultado.toString()
//                            operacion = ""
//                        }
//
//                        "multiplicacion" -> {
//
//                            op2 = pantalla.toInt()
//                            resultado = op1 * op2
//                            pantalla = resultado.toString()
//                            operacion = ""
//
//                        }
//
//                        "division" -> {
//
//
//                            op2 = pantalla.toInt() //
//                            //Evitar la division por cero.
//                            if (op2 != 0) {
//                                resultado = op1 / op2
//                                pantalla = resultado.toString()
//                                operacion = ""
//
//
//                            } else {
//
//                                Toast.makeText(
//                                    this,
//                                    "Division por 0 no permitida",
//                                    Toast.LENGTH_SHORT
//                                )
//                                    .show()
//                            }
//
//
//                        }
//                    }
//                }
//            }

            binding.botonIgual.id -> {

                accion(operacion)

            }

        }

        binding.textoPantalla.text = pantalla
        binding.textoSecundario.text = pantallaSecudaria
    }

    fun botonesOperacion(simbolo: String) {
        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {
            op1 = pantalla.toInt()
            pantalla = ""
            pantallaSecudaria = "$op1$simbolo"


        }

    }

    fun accion(operacion: String) {
        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {

            op2 = pantalla.toInt()
            pantallaSecudaria += pantalla
            botonPulsado = true

            when (operacion) {

                "suma" -> {
                    pantalla = (op1 + op2).toString()
                    this.operacion = ""

                }

                "resta" -> {
                    pantalla = (op1 - op2).toString()
                    this.operacion = ""

                }

                "multiplicacion" -> {
                    pantalla = (op1 * op2).toString()
                    this.operacion = ""

                }

                "division" -> {
                    if (op2 != 0) {
                        pantalla = (op1 / op2.toDouble()).toDouble().toString()
                        this.operacion = ""


                    } else {//
                        Toast.makeText(this, "Division por 0 no permitida", Toast.LENGTH_SHORT)
                            .show()
                    }


                }

            }

        }


    }


//    fun botonPorcentaje()
}













