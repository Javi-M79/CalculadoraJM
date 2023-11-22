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
    private var pantallaSecundaria = ""
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
        pantallaSecundaria = savedInstanceState?.getString("pantallaSecudaria") ?: ""
        binding.textoPantalla.text = pantalla.toString()
        binding.textoSecundario.text = pantallaSecundaria.toString()

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


    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("pantalla", pantalla)
        outState.putString(
            "pantallaSecundaria",
            pantallaSecundaria
        )//No guarda bien el resultado. Comprobar.
    }

    override fun onClick(v: View?) {

        when (v?.id) {


            //COMPORTAMIENTO DE BOTONES NUMERICOS// PROBAR COGIENDO EL .TEXT DE TODOS

//CREAR UN FOREACH PARA QUE COJA EL TEXTO DE CADA BOTON?? USAR LA VARIABLE botones??

            binding.botonCero.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonCero.text.toString()

                } else {
                    pantalla += binding.botonCero.text.toString()

                }
            }

            binding.botonUno.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonUno.text.toString()
                } else {
                    pantalla += binding.botonUno.text.toString()
                }
            }

            binding.botonDos.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonDos.text.toString()
                } else {
                    pantalla += binding.botonDos.text.toString()
                }
            }


            binding.botonTres.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonTres.text.toString()

                } else {
                    pantalla += binding.botonTres.text.toString()
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
                    pantalla = binding.botonCinco.text.toString()

                } else {
                    pantalla += binding.botonCinco.text.toString()
                }
            }

            binding.botonSeis.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonSeis.text.toString()

                } else {
                    pantalla += binding.botonSeis.text.toString()
                }
            }

            binding.botonSiete.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonSiete.text.toString()

                } else {
                    pantalla += binding.botonSiete.text.toString()
                }
            }

            binding.botonOcho.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonOcho.text.toString()

                } else {
                    pantalla += binding.botonOcho.text.toString()
                }
            }

            binding.botonNueve.id -> {
                if (botonPulsado) {
                    pantalla = binding.botonNueve.text.toString()

                } else {
                    pantalla += binding.botonNueve.text.toString()
                }
            }

            binding.botonReset.id -> {
                pantalla = ""; pantallaSecundaria = ""
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

            binding.botonPorcentaje.id -> {

                operacion = "porcentaje"

            }

            binding.botonIgual.id -> {

                accion(operacion)

            }

        }

        binding.textoPantalla.text = pantalla
        binding.textoSecundario.text = pantallaSecundaria
    }

    fun botonesOperacion(simbolo: String) {
        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {
            op1 = pantalla.toDouble().toInt()
            pantalla = ""
            pantallaSecundaria = "$op1$simbolo"
        }
    }

    fun accion(operacion: String) {
        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {

            op2 = pantalla.toInt()
            pantallaSecundaria += pantalla
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
                        pantalla = (op1 / op2.toDouble()).toString()
                        this.operacion = ""

                    } else {//
                        Toast.makeText(this, "Division por 0 no permitida", Toast.LENGTH_SHORT)
                            .show()
                    }


                }

                "porcentaje" -> {
                    botonPorcentaje()
                }

            }

        }

    }

    fun botonPorcentaje() {

        if (pantalla.isEmpty()) {
            Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
        } else {
            val porcentaje = pantalla.toDouble()
            pantallaSecundaria += pantalla
            botonPulsado = true

            when (operacion) {
                "suma" -> {
                    pantalla = { op1 + (op1 * porcentaje / 100) }.toString()
                    operacion = ""
                }

                "resta" -> {
                    pantalla = { op1 - (op1 * porcentaje / 100) }.toString()
                    operacion = ""
                }

                "multiplicacion" -> {
                    pantalla = { op1 * (porcentaje / 100)}.toString()
                    operacion = ""
                }

                "division" -> {
                    if (porcentaje != 0.0) {
                        pantalla = {op1 / (porcentaje / 100)}.toString()
                        operacion = ""
                    } else {
                        Toast.makeText(this, "División por 0 no permitida", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }

    }


}





















