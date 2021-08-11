package com.valdomiro.calculadora_de_notas

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.valdomiro.calculadora_de_notas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btCalcular.setOnClickListener {

            val n1 = binding.nota1
            val n2 = binding.nota2
            val n3 = binding.nota3
            val n4 = binding.nota4
            val faltas = binding.faltas
            val resultado = binding.txtResultado

            val nota1 = Integer.parseInt(n1.text.toString())
            val nota2 = Integer.parseInt(n2.text.toString())
            val nota3 = Integer.parseInt(n3.text.toString())
            val nota4 = Integer.parseInt(n4.text.toString())
            val numeroFalstas = Integer.parseInt(faltas.text.toString())

            val media = (nota1 + nota2 + nota3 + nota4) / 4

            if (media >= 50 && numeroFalstas <= 20) {
                resultado.text = "Aluno aprovado\nMédia = $media\nNúmero de faltas = $numeroFalstas"
                resultado.setTextColor(getColor(R.color.green))
            } else if (numeroFalstas > 20) {
                resultado.text = "Aluno reprovado por faltas\nMédia = $media\nNúmero de faltas = $numeroFalstas"
                resultado.setTextColor(getColor(R.color.red))
            } else if (media < 50) {
                resultado.text = "Aluno reprovado por nota\nMédia = $media\nNúmero de faltas = $numeroFalstas"
                resultado.setTextColor(getColor(R.color.red))
            }
        }
    }
}