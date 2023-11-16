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
    private var historial = ""
    private var op1 = 0
    private var op2 = 0
    private var resultado =
        0 //Probar con String para ver si se puede resetear al pulsar un numero despues de mostrarlo.
    private var operacion: String = ""


    //RECUPERAR DATOS

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultado = savedInstanceState?.getInt("resultado") ?: 0

        binding =
            ActivityMainBinding.inflate(layoutInflater)//Nombre de la clase + metodo = (variable LayoutInflater)
        setContentView(binding.root)

        /*TODO EL CODIGO DE ARRIBA SE DEBE REPETIR POR NORMA
        RESUMEN:
        -  Crear variable para el binding de tipo ActivityMainBinding: private lateinit var binding: ActivityMainBinding
        - Rellenar fichero: binding = ActivityMainBinding.inflate(layoutInflater)
        -  Usar la clase serContentView con la raiz de la variable Binding como parametro. Con root le estamos diciendo que mire lo mas arriba posible del archivo grafico. Normalmente desde el linearLayout, etc..

        */


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

    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("resultado", resultado)
        binding.textoPantalla.text = resultado.toString()
    }

    //Metodo de la Interface OnClickListener.
    override fun onClick(v: View?) {

        /*IMPLEMENTAR RESETEO AL MOSTRAR RESULTADO PARA EMPEZAR DE NUEVO Y NO CONCATERNAR NUEVOS VALORES AL RESULTADO.
          IF ELSE?
          Trabajar con al variable resultado. Resetearla?
      */
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
            binding.botonReset.id -> {
                pantalla = ""; pantallaSecudaria = ""
            }

            //EVENTOS EN BOTONES DE OPERACION//

            binding.botonSuma.id -> {

                if (pantalla.isEmpty()) {

                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
                } else {

                    op1 += pantalla.toInt()
                    historial = pantalla
                    pantalla = ""
                    pantallaSecudaria = "+"; historial
                    operacion = "suma"

                }
            }

            binding.botonResta.id -> {
                if (pantalla.isEmpty()) {

                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
                } else {
                    op1 = pantalla.toInt()
                    pantalla = ""
                    pantallaSecudaria = "-"
                    operacion = "resta"
                }
            }

            binding.botonMultipilcar.id -> {
                if (pantalla.isEmpty()) {

                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
                } else {

                    op1 = pantalla.toInt()
                    pantalla = ""
                    pantallaSecudaria = "x"
                    operacion = "multiplicacion"
                }
            }

            binding.botonDividir.id -> {
                if (pantalla.isEmpty()) {

                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
                } else {
                    op1 = pantalla.toInt()
                    pantalla = ""
                    pantallaSecudaria = "/"
                    operacion = "division"
                }
            }
            /*DECIDIR SU USO.
             SI MUESTRA SIMBOLO EN SECUNDARIA O MUESTRA EL RESULTADO DE LA OPERACION AL PULSARLO*/

            binding.botonPorcentaje.id -> {

                if (pantalla.isEmpty()) {

                    Toast.makeText(this, "Accion no permitida", Toast.LENGTH_SHORT).show()
                } else {
                    when (operacion) {

                        "suma" -> {

                            op2 = pantalla.toInt()
                            resultado = op1 + (op1 * op2 / 100)
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

                                Toast.makeText(
                                    this,
                                    "Division por 0 no permitida",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }


                        }
                    }
                }
            }

            binding.botonIgual.id -> {

                when (operacion) {

                    "suma" -> {

                        op2 = pantalla.toInt()
                        resultado = op1 + op2
                        op1 = resultado
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

                        } else {//
                            Toast.makeText(this, "Division por 0 no permitida", Toast.LENGTH_SHORT)
                                .show()
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
        binding.textoSecundario.text = pantallaSecudaria
    }


}










