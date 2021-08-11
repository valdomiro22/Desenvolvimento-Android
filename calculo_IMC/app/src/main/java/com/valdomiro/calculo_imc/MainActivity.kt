package com.valdomiro.calculo_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.valdomiro.calculo_imc.databinding.ActivityMainBinding
import java.lang.Float
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val btCalcular = binding.btCalcular
        val mensagem = binding.mensagem

        btCalcular.setOnClickListener {

            val editPeso = binding.editPeso.text.toString()
            val editAltura = binding.editAltura.text.toString()

            if (editPeso.isEmpty()) {
                mensagem.text = "Informe o seu Peso"
            } else if (editAltura.isEmpty()) {
                mensagem.text = "Informe a sua altura"
            } else {
                calculoDeImc()
            }
        }
    }

    private fun calculoDeImc() {

        val pesoID = binding.editPeso
        val alturaID = binding.editAltura
        val imc: kotlin.Float

        val peso = Integer.parseInt(pesoID.text.toString())
        val altura = (alturaID.text.toString()).toFloat()
        var resultado = binding.mensagem

        imc = peso / (altura * altura)

        val mensagem = when {
            imc <= 18.5 -> "Peso baixo"
            imc <= 24.9 -> "Peso normal"
            imc <= 29.9 -> "Sobrepeso"
            imc <= 34.9 -> "Obesidade grau 1"
            imc <= 39.9 -> "Obesidade grau 2"
            imc >= 40 -> "Obesidade grau 3"
            else -> "Peso invalido"
        }

        imc.toString()
        resultado.text = "IMC = $imc\n $mensagem"
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.reset -> {

                val limparEditPeso = binding.editPeso
                val limparEditAltura = binding.editAltura
                val limparMensagem = binding.mensagem

                limparEditPeso.setText("")
                limparEditAltura.setText("")
                limparMensagem.text = ""
            }
        }

        return super.onOptionsItemSelected(item)
    }
}