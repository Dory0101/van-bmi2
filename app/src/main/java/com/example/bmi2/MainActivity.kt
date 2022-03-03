package com.example.bmi2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.bmi2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun bmi(view: View) {
        println("hahaha")
        var Weight = binding.edWeight.text.toString().toFloat()
        var Height = binding.edHeight.text.toString().toFloat()
        println(Weight/(Height*Height))
    }
}