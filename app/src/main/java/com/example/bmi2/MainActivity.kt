package com.example.bmi2

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.bmi2.databinding.ActivityMainBinding
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    val REQUSET_DISPLAY_BMI = 16
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.bHelp.setOnClickListener {
//            Log.d("MainActivity", "Need help!")
//        }
        binding.bHelp.setOnClickListener {
            Log.d("MainActivity", "help clicked")
        }
    }

    fun bmi(view: View) {
//        Log.v() //verble???
        Log.d("MainActivity", "clicked") //debug after online delete
//        Log.i() //information after online sometimes delete
//        Log.w() //warining
//        Log.e() //error
        println("hahaha")
        var weight = binding.edWeight.text.toString().toFloat()
        var height = binding.edHeight.text.toString().toFloat()
        var bmi = weight/(height*height)
        Log.d("MainActivity", bmi.toString())
        Toast.makeText(this, "Your BMI $bmi", Toast.LENGTH_LONG)
//        println(weight/(height*height))
//        val builder = AlertDialog.Builder(this)
//        builder.setTitle("Hello")
//        builder.setMessage("Your BMI is $bmi")
//        builder.setPositiveButton("OK", null)
//        val dialog = builder.create()
//        dialog.show()
        AlertDialog.Builder(this)
            .setTitle("Hello")
            .setMessage("Your BMI is $bmi")
            .setPositiveButton("OK") { dialog, which ->
                //anonymous class
                binding.edWeight.setText("")
                binding.edHeight.setText("")
            }
//            .show()
        binding.tvBmi.text = "Your BMI is ${bmi.roundToInt()}"
//        val intent = Intent(this, ResultActivity::class.java)
//        intent.putExtra("BMI_EXTRA", bmi)
////        startActivity(intent)
//        startActivityForResult(intent, REQUSET_DISPLAY_BMI)

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("BMI_EXTRA", bmi)
        startActivityForResult(intent, REQUSET_DISPLAY_BMI)
    }



    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d(TAG, "onActivityResult")
        if (requestCode == REQUSET_DISPLAY_BMI && resultCode == RESULT_OK) {
            Log.d(TAG, "back from ResultActivity")
        }
    }
}