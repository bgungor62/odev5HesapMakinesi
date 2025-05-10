package com.example.odev5hesapmakinesi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.odev5hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var firstNumber: String = ""
    private var secondNumber: String = ""
    private var isSecond: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val numberButtons = listOf(
            binding.btn0, binding.btn1, binding.btn2, binding.btn3,
            binding.btn4, binding.btn5, binding.btn6,
            binding.btn7, binding.btn8, binding.btn9
        )

        for (button in numberButtons) {
            button.setOnClickListener {
                val num = button.text.toString()
                if (!isSecond) {
                    firstNumber += num
                    binding.editText.setText(firstNumber)
                } else {
                    secondNumber += num
                    binding.editText.setText(secondNumber)
                }
            }
        }

        binding.btnTopla.setOnClickListener {
            if (firstNumber.isNotEmpty()) {
                isSecond = true
                binding.editText.setText("+")
            }
        }

        binding.btnSonuc.setOnClickListener {
            if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty()) {
                val sonuc = firstNumber.toInt() + secondNumber.toInt()
                binding.editText.setText(sonuc.toString())

                firstNumber = sonuc.toString()
                secondNumber = ""
                isSecond = false
            }
        }

        binding.btnSil.setOnClickListener {
            firstNumber = ""
            secondNumber = ""
            isSecond = false
            binding.editText.setText("")
        }
    }
}
